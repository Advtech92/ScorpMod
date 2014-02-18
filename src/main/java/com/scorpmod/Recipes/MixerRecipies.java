package com.scorpmod.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.scorpmod.ScorpMod;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MixerRecipies
{
	private Map<ArrayList<Item>, ItemStack> mixerList = new HashMap<ArrayList<Item>, ItemStack>();
	private Map<Item, Float> mixerExperience = new HashMap<Item, Float>();
	private static final MixerRecipies mixerBase = new MixerRecipies();

	public static final MixerRecipies instance()
	{
		return mixerBase;
	}

	public ItemStack getRecipeResult(Item item, Item item2)
	{
		ArrayList<Item> array1 = new ArrayList<Item>(), array2 = new ArrayList<Item>();
		array1.add(item);
		array1.add(item2);
		array2.add(item2);
		array2.add(item);
		return mixerList.get(array1) == null ? mixerList.get(array2) : mixerList.get(array1);
	}

	public void addMixerRecipe(Item item1, Item item2, ItemStack itemStack, float experience)
	{
		ArrayList<Item> array = new ArrayList<Item>();
		array.add(item1);
		array.add(item2);
		mixerList.put(array, itemStack);
		this.mixerExperience.put(itemStack.getItem(), Float.valueOf(experience));
	}

	public float getExperience(int par1)
	{
		return this.mixerExperience.containsKey(Integer.valueOf(par1)) ? this.mixerExperience.get(Integer.valueOf(par1)).floatValue() : 0.0F;
	}

	private MixerRecipies()
	{
		addMixerRecipe(Items.gold_ingot, Items.water_bucket, new ItemStack(ScorpMod.itemyellowBucket, 1, 0), 0.7F);
		addMixerRecipe(Items.redstone, Items.water_bucket, new ItemStack(ScorpMod.itemredBucket, 1, 0), 0.7F);
		addMixerRecipe(Items.emerald, Items.water_bucket, new ItemStack(ScorpMod.itemgreenBucket, 1, 0), 0.7F);
		addMixerRecipe(Items.sugar, Items.water_bucket, new ItemStack(ScorpMod.itemwhiteBucket, 1, 0), 0.7F);
		addMixerRecipe(Items.diamond, Items.water_bucket, new ItemStack(ScorpMod.itemturquoiseBucket, 1, 0), 0.7F);
		addMixerRecipe(ScorpMod.itempurpleDust, Items.water_bucket, new ItemStack(ScorpMod.itempurpleBucket, 1, 0), 0.7F);
	}
}