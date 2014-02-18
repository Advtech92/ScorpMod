package com.scorpmod.items;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

public class ItemFoodScorpMod extends ItemFood{
	public ItemFoodScorpMod(int hunger, float saturation, boolean wolf, String name)
	{
		super(hunger, saturation, wolf);
		setUnlocalizedName(name);
		setCreativeTab(ScorpMod.tabscorpItems);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg)
	{
		this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	//effect scorpianz1525 17 5 100
}