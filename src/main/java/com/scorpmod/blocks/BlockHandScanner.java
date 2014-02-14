package com.scorpmod.blocks;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;
import com.scorpmod.tileentity.HandScannerTile;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHandScanner extends BlockContainer
{
	private String name;
	public int power;
	public int status;
	private String nbtname;

	public BlockHandScanner()
	{
		super(Material.iron);
		setBlockName("handScanner");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(3);
	}

	@SideOnly(Side.CLIENT)
	private IIcon side, bottom, top, front;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg)
	{
		this.side = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "sides");
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
		System.out.println("Right Click");
		System.out.println(name);
		System.out.println(nbtname);
		// This is never called when the world is restarted
		// l
		// V
		if (!par1World.isRemote)
		{
			if (nbtname.equals(name))
			{
				if (status == 0)
				{
					power = 15;
					status = 1;
					par1World.notifyBlockChange(x, y, z, ScorpMod.blockhandScanner);
				}
				else if (status == 1)
				{
					power = 0;
					status = 0;
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
	public TileEntity createNewTileEntity(World world, int i)
	{
		HandScannerTile tile = new HandScannerTile();
		return tile;
	}

	@Override
	public boolean canProvidePower()
	{
		return true;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return power;
	}
}
