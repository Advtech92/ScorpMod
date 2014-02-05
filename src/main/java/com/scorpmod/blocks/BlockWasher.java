package com.scorpmod.blocks;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;
import com.scorpmod.tileentity.TileMixer;
import com.scorpmod.tileentity.TileWasher;

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

public class BlockWasher extends BlockContainer{

        public BlockWasher(){
            super(Material.iron);
            setBlockName("washer");
            setCreativeTab(CreativeTabs.tabBlock);
            setHardness(3);
        }
        @SideOnly(Side.CLIENT)
        private IIcon side, bottom, top, front;
        
        @Override
        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(IIconRegister reg){
            this.side = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "side");
            this.bottom = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "top");
            this.top = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "top");
            this.front = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)) + "front");
        }
        
        @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata){
              if (side == 1) return this.top;
              else if (side == 0) return this.top;
              else if (metadata == 2 && side == 2) return this.front;
              else if (metadata == 3 && side == 5) return this.front;
              else if (metadata == 0 && side == 3) return this.front;
              else if (metadata == 1 && side == 4) return this.front;
              else return this.side;
        
                
        }
        
        @Override
        public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int whichDirectionFacing = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
    }
        
        @Override
        public TileEntity createNewTileEntity(World world, int i) {
                return new TileWasher();
        }
    @Override
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
         TileWasher tEntity = (TileWasher)par1World.getTileEntity(x,y,z);
         if(tEntity != null){
                 player.openGui(ScorpMod.instance, 2, par1World, x, y, z);
 //        }
         return true;
 }
         return false;
    }
    
}