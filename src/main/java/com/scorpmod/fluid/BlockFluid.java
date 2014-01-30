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

public class BlockFluid extends BlockFluidClassic{

	@SideOnly(Side.CLIENT)
	public IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	public IIcon flowingIcon;
	
	public BlockFluid(Fluid fluid) {
		super(fluid, Material.field_151586_h);
        func_149647_a(CreativeTabs.tabBlock);
	}
	
	@Override
	public IIcon func_149691_a(int side, int meta){
		  return (side == 0 || side == 1)? stillIcon : flowingIcon;
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public void func_149651_a(IIconRegister reg){
        stillIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)));
        flowingIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)));
    }
	
}
