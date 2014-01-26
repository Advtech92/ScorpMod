package com.scorpmod.items;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemEmptyBottle extends Item {
    public ItemEmptyBottle(){
        super();
        setUnlocalizedName("emptybottle");
        setCreativeTab(ScorpMod.tabscorpItems);
    }
    
@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister reg){
        this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
}
}