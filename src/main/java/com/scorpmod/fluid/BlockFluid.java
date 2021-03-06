package com.scorpmod.fluid;

import com.scorpmod.libs.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluid extends BlockFluidClassic
{
	@SideOnly(Side.CLIENT)
	public IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	public IIcon flowingIcon;

	public BlockFluid(Fluid fluid, Material material)
	{
		super(fluid, material);
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}
	
	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z).getMaterial().isLiquid())
			return false;
		return super.displaceIfPossible(world, x, y, z);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg)
	{
		stillIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)));
		flowingIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
