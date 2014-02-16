package com.scorpmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;
import com.scorpmod.tileentity.TileBaseScorpMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockContainerBaseScorpMod<T extends TileBaseScorpMod> extends BlockContainer
{
	private final Random random = new Random();
	private Class<? extends TileEntity> clazz;
	private int guiID;

	public BlockContainerBaseScorpMod(String unlocName, Material mat, Class<? extends TileEntity> clazz, int guiID)
	{
		super(mat);
		this.clazz = clazz;
		this.guiID = guiID;
		setBlockName(unlocName);
		setCreativeTab(ScorpMod.tabscorpBlocks);
		setHardness(3);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon side, bottom, top, front;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg)
	{
		this.side = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "side");
		this.bottom = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "top");
		this.top = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "top");
		this.front = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "front");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (side == 1) return this.top;
		else if (side == 0) return this.top;
		else if (metadata == 2 && side == 2) return this.front;
		else if (metadata == 3 && side == 5) return this.front;
		else if (metadata == 0 && side == 3) return this.front;
		else if (metadata == 1 && side == 4) return this.front;
		else return this.side;
	}

	@SuppressWarnings("unchecked")
	public void breakBlock(World world, int x, int y, int z, Block block, int side)
	{
		T te = (T) world.getTileEntity(x, y, z);
		if (te != null)
		{
			for (int i1 = 0; i1 < te.getSizeInventory(); ++i1)
			{
				ItemStack itemstack = te.getStackInSlot(i1);
				if (itemstack != null)
				{
					float f = this.random.nextFloat() * 0.8F + 0.1F;
					float f1 = this.random.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;
					for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
					{
						int j1 = this.random.nextInt(21) + 10;
						if (j1 > itemstack.stackSize)
						{
							j1 = itemstack.stackSize;
						}
						itemstack.stackSize -= j1;
						entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
						if (itemstack.hasTagCompound())
						{
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}
			world.func_147453_f(x, y, z, block);
		}
		super.breakBlock(world, x, y, z, block, side);
	}

	@Override
	public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int whichDirectionFacing = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
		par1World.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		try
		{
			return clazz.newInstance();
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		T tEntity = (T) par1World.getTileEntity(x, y, z);
		if (tEntity != null)
		{
			player.openGui(ScorpMod.instance, this.guiID, par1World, x, y, z);
			return true;
		}
		return false;
	}
}
