package com.scorpmod.tileentity;

import java.util.ArrayList;

import com.scorpmod.ScorpMod;
import com.scorpmod.Recipes.BottlerRecipies;
import com.scorpmod.Recipes.WasherRecipies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileWasher extends TileEntity implements ISidedInventory
{
        private ItemStack[] inventory;
        public int pressTime = 0;
        public int abc = 1;

        public TileWasher()
        {
                this.inventory = new ItemStack[3];
        }

        @Override
        public int getSizeInventory()
        {
                return this.inventory.length;
        }

        @Override
        public ItemStack getStackInSlot(int i)
        {
                return this.inventory[i];
        }

        @Override
        public ItemStack decrStackSize(int slotIndex, int amount)
        {
                ItemStack stack = getStackInSlot(slotIndex);

                if (stack != null)
                {

                        if (stack.stackSize <= amount)
                        {
                                setInventorySlotContents(slotIndex, null);
                        }
                        else
                        {
                                stack = stack.splitStack(amount);
                                if (stack.stackSize == 0)
                                {
                                        setInventorySlotContents(slotIndex, null);
                                }
                        }
                }
                return stack;
        }

        @Override
        public ItemStack getStackInSlotOnClosing(int slotIndex)
        {
                ItemStack stack = getStackInSlot(slotIndex);

                if (stack != null)
                {
                        setInventorySlotContents(slotIndex, null);
                }

                return stack;
        }

        @Override
        public void setInventorySlotContents(int slot, ItemStack stack)
        {
                this.inventory[slot] = stack;

                if (stack != null && stack.stackSize > getInventoryStackLimit())
                {
                        stack.stackSize = getInventoryStackLimit();
                }

        }

        @Override
        public String getInventoryName()
        {
                return "Coin Press";
        }

        @Override
        public boolean hasCustomInventoryName()
        {
                return false;
        }

        @Override
        public int getInventoryStackLimit()
        {
                return 64;
        }

        @Override
        public boolean isUseableByPlayer(EntityPlayer entityplayer)
        {
        	return entityplayer.worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
        }

        @Override
        public void openInventory()
        {
        }

        @Override
        public void closeInventory()
        {
        }

        @Override
        public void readFromNBT(NBTTagCompound tagCompound)
        {
                super.readFromNBT(tagCompound);

                NBTTagList tagList = tagCompound.getTagList("Inventory", 10);

                for (int i = 0; i < tagList.tagCount(); i++)
                {
                        NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);

                        byte slot = tag.getByte("Slot");

                        if (slot >= 0 && slot < inventory.length)
                        {
                                inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
                        }
                }
        }

        @Override
        public void writeToNBT(NBTTagCompound tagCompound)
        {
                super.writeToNBT(tagCompound);

                NBTTagList itemList = new NBTTagList();

                for (int i = 0; i < inventory.length; i++)
                {
                        ItemStack stack = inventory[i];

                        if (stack != null)
                        {
                                NBTTagCompound tag = new NBTTagCompound();

                                tag.setByte("Slot", (byte) i);
                                stack.writeToNBT(tag);
                                itemList.appendTag(tag);
                        }
                }

                tagCompound.setTag("Inventory", itemList);
        }

        public void pressItem()
        {
                if (this.inventory[0] != null && this.inventory[1] != null)
                {
                        ItemStack var1 = WasherRecipies.instance().getRecipeResult(this.inventory[0].getItem(), this.inventory[1].getItem());
                        if (this.inventory[2] == null)
                        {
                                this.inventory[2] = var1.copy();
                        }
                        else if (this.inventory[2] == var1)
                        {
                                ++this.inventory[2].stackSize;
                        }
                        this.inventory[0].getItem().setContainerItem(null);
                        this.inventory[1].getItem().setContainerItem(null);
                        this.inventory[getFilterSlot()].setItemDamage(inventory[getFilterSlot()].getItemDamage() + 1);
                        this.inventory[getNotFilterSlot()].stackSize--;
                        if (inventory[getFilterSlot()].getItemDamage() >= 10)
                                inventory[getFilterSlot()].stackSize--;
                        
                        if (this.inventory[0].stackSize == 0)
                        {
                                Item var2 = this.inventory[0].getItem().getContainerItem();
                                this.inventory[0] = var2 == null ? null : new ItemStack(var2);
                        }
                        
                        
                        if (this.inventory[1].stackSize == 0)
                        {
                                Item var2 = this.inventory[1].getItem().getContainerItem();
                                this.inventory[1] = var2 == null ? null : new ItemStack(var2);
                        }
                }

        }

        public boolean canPress()
        {
                if (inventory[0] == null || inventory[1] == null)
                {
                        abc = 0;
                        return false;
                }

                ItemStack itemstack = WasherRecipies.instance().getRecipeResult(inventory[0].getItem(), inventory[1].getItem());

                if (itemstack == null)
                {
                        return false;
                }

                if (inventory[2] == null)
                {

                        return true;
                }

                if (!inventory[2].isItemEqual(itemstack))
                {

                        return false;
                }

                if (inventory[2].stackSize < getInventoryStackLimit() && inventory[1].stackSize < inventory[1].getMaxStackSize())
                {

                        return true;
                }

                return inventory[2].stackSize < itemstack.getMaxStackSize();
        }

        @Override
        public void updateEntity()
        {
                if (canPress() && abc == 0)
                        abc = 1;
                
                if (abc >= 100)
                {
                        if (canPress())
                        {
                                pressItem();
                        }
                        abc = 0;
                }
                else if (abc > 0)
                {
                        abc++;
                }
                this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }

        public int getCookProgressScaled(int par1)
        {
                return this.abc * par1 / 50;
        }
        
        public int getFilterSlot()
        {
                return inventory[0].getItem() == ScorpMod.itemfluidFilter ? 0 : 1;
        }
        
        public int getNotFilterSlot()
        {
                return getFilterSlot() == 0 ? 1 : 0;
        }

		@Override
		public int[] getAccessibleSlotsFromSide(int var1) {
			return new int[]{0,1};}

		@Override
		public boolean canInsertItem(int var1, ItemStack var2, int var3) {
			return true;
		}

		@Override
		public boolean canExtractItem(int var1, ItemStack var2, int var3) {
			return true;
		}
        @Override
        public boolean isItemValidForSlot(int i, ItemStack itemstack)
        {
                if (i == 0 || i == 1)
                {
                	for (ArrayList<Item> a : BottlerRecipies.instance().bottlerList.keySet())
                	{
                		for (Item l : a)
                		{
                			if(itemstack.getItem() == l){
                				return true;
                			}
                		}
                	}
                }
				return false;
        }

}