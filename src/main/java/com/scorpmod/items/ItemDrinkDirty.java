package com.scorpmod.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDrinkDirty extends ItemBaseScorpMod
{
	public ItemDrinkDirty(String unlocName)
	{
		super(unlocName, 1);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool)
	{
		dataList.add("\u00a7bUn-Drinkable try washing it");
	}
}