package com.scorpmod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileBaseScorpMod extends TileEntity implements IInventory
{
	protected ItemStack[] inventory = new ItemStack[0];

	public int getSizeInventory()
	{
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1)
	{
		return var1 < inventory.length ? inventory[var1] : null;
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public String getInventoryName()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasCustomInventoryName()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1)
	{
		return true;
	}

	@Override
	public void openInventory()
	{}

	@Override
	public void closeInventory()
	{}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2)
	{
		return false;
	}
}
