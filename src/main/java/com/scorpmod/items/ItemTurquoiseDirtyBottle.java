package com.scorpmod.items;

import java.util.List;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemTurquoiseDirtyBottle extends Item {
	public ItemTurquoiseDirtyBottle() {
		super();
		setUnlocalizedName("turquoisedirtybottle");
		setCreativeTab(ScorpMod.tabscorpItems);
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
		this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH
				+ ":"
				+ this.getUnlocalizedName().substring(
						this.getUnlocalizedName().indexOf(".") + 1));
	}


	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player,
			List dataList, boolean bool) {
		dataList.add("\u00a7bUn-Drinkable try washing it");
	}

}