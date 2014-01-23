package com.scorpmod.blocks;

import com.scorpmod.libs.Reference;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMixer extends BlockContainer{

        public BlockMixer(){
            super(Material.field_151576_e);
            func_149663_c("handScanner");
            func_149647_a(CreativeTabs.tabBlock);
            func_149711_c(3);
        }
        @SideOnly(Side.CLIENT)
        private IIcon side, bottom, top, front;
        
        @Override
        @SideOnly(Side.CLIENT)
        public void func_149651_a(IIconRegister reg){
            this.side = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)) + "sides");
            this.bottom = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.func_149739_a().substring(5)) + "top");
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
        
        @Override
        public TileEntity func_149915_a(World world, int i) {
                return new TileMixer();
        }
    @Override
    public boolean func_149727_a(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
         TileMixer tEntity = (TileMixer)par1World.getBlockTileEntity(x,y,z);
         if(tEntity != null){
                 player.openGui(CommanderAdz.instance, 0, par1World, x, y, z);
 //        }
         return true;
 }
         return false;
    }
    
}