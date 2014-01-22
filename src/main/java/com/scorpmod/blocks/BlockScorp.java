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

public class BlockScorp extends Block{
	
	public BlockScorp(){
		super(Material.field_151576_e);
		func_149647_a(CreativeTabs.tabBlock);
		func_149663_c("scorpBlock");
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon side, bottom, top, front;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void func_149651_a(IIconRegister reg){
            this.side = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)) + "front");
            this.bottom = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)) + "bottom");
            this.top = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)) + "top");
            this.front = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)) + "front");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon func_149691_a(int side, int metadata){
          if (side == 1) return this.top;
          else if (side == 0) return this.top;
          else if (metadata == 2 && side == 2) return this.front;
          else if (metadata == 3 && side == 5) return this.front;
          else if (metadata == 0 && side == 3) return this.front;
          else if (metadata == 1 && side == 4) return this.front;
          else return this.side;
    
            
    }
    
    @Override
	public void func_149689_a(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
{
    int whichDirectionFacing = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
    par1World.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
}

}
