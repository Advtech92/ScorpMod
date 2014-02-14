package com.scorpmod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.scorpmod.ScorpMod;
import com.scorpmod.tileentity.HandScannerTile;

public class BlockHandScanner extends BlockContainerBaseScorpMod<HandScannerTile>
{
	private String name;
	private String nbtname;

	public BlockHandScanner()
	{
		super("handScanner", Material.iron, HandScannerTile.class, 0);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack par6ItemStack)
	{
		world.setBlock(x, y, z, ScorpMod.blockhandScanner);
		int whichDirectionFacing = MathHelper.floor_double(entity.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
		HandScannerTile tileEntity = (HandScannerTile) world.getTileEntity(x, y, z);
		EntityPlayer player = (EntityPlayer) entity;
		if (!world.isRemote) player.addChatComponentMessage(new ChatComponentText("Hand print set"));
		if (entity instanceof EntityPlayer)
		{
			name = player.getCommandSenderName();
		}
		tileEntity.oName = name;
		System.out.println(tileEntity.oName);
	}

	@Override
	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		HandScannerTile tileEntity = (HandScannerTile) par1World.getTileEntity(x, y, z);
		par1World.notifyBlockChange(x, y, z, ScorpMod.blockhandScanner);
		nbtname = tileEntity.oName;
		name = player.getCommandSenderName();
		// This is never called when the world is restarted
		if (!par1World.isRemote)
		{
			if (nbtname.equals(name))
			{
				if (tileEntity.status == 0)
				{
					tileEntity.power = 15;
					tileEntity.status = 1;
					par1World.notifyBlockChange(x, y, z, ScorpMod.blockhandScanner);
				}
				else if (tileEntity.status == 1)
				{
					tileEntity.power = 0;
					tileEntity.status = 0;
					par1World.notifyBlockChange(x, y, z, ScorpMod.blockhandScanner);
				}
				else
				{
					System.out.println("Error");
				}
				return true;
			}
			else if (!nbtname.equals(name))
			{
				player.addChatComponentMessage(new ChatComponentText("Hand print not recognised"));
			}
		}
		else if (!par1World.isRemote && (!nbtname.equals(name)))
		{
			player.addChatComponentMessage(new ChatComponentText("Hand print not recognised"));
			return true;
		}
		return true;
	}

	@Override
	public boolean canProvidePower()
	{
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int x, int y, int z, int par5)
	{
		HandScannerTile tileentity = (HandScannerTile) par1IBlockAccess.getTileEntity(x, y, z);
		return tileentity.power;
	}
}
