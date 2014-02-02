package com.scorpmod.blocks;

import com.scorpmod.libs.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockElipsicalLamp extends Block{
	
	public BlockElipsicalLamp(){
		super(Material.field_151576_e);
		func_149647_a(CreativeTabs.tabBlock);
		func_149663_c("elipsicallampBlock");
		func_149715_a(1);
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void func_149651_a(IIconRegister reg){
		this.field_149761_L = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)));
    }
    

}
