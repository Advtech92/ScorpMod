package com.scorpmod.items;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemBaseScorpMod extends Item
{
	public ItemBaseScorpMod(String unlocName, int stackSize)
	{
		super();
		setUnlocalizedName(unlocName);
		setCreativeTab(ScorpMod.tabscorpItems);
		maxStackSize = stackSize;
	}

	public ItemBaseScorpMod(String unlocName)
	{
		this(unlocName, 64);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg)
	{
		this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
