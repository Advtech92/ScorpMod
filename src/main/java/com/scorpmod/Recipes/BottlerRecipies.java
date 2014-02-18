package com.scorpmod.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.scorpmod.ScorpMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BottlerRecipies
{
	public Map<ArrayList<Item>, ItemStack> bottlerList = new HashMap<ArrayList<Item>, ItemStack>();
	private Map<Item, Float> bottlerExperience = new HashMap<Item, Float>();
	private static final BottlerRecipies bottlerBase = new BottlerRecipies();

	public static final BottlerRecipies instance()
	{
		return bottlerBase;
	}

	public ItemStack getRecipeResult(Item item, Item item2)
	{
		ArrayList<Item> array1 = new ArrayList<Item>(), array2 = new ArrayList<Item>();
		array1.add(item);
		array1.add(item2);
		array2.add(item2);
		array2.add(item);
		return bottlerList.get(array1) == null ? bottlerList.get(array2) : bottlerList.get(array1);
	}

	public void addMixerRecipe(Item item1, Item item2, ItemStack itemStack, float experience)
	{
		ArrayList<Item> array = new ArrayList<Item>();
		array.add(item1);
		array.add(item2);
		bottlerList.put(array, itemStack);
		this.bottlerExperience.put(itemStack.getItem(), Float.valueOf(experience));
	}

	public float getExperience(int par1)
	{
		return this.bottlerExperience.containsKey(Integer.valueOf(par1)) ? this.bottlerExperience.get(Integer.valueOf(par1)).floatValue() : 0.0F;
	}

	private BottlerRecipies()
	{
		addMixerRecipe(ScorpMod.itememptyBottle, ScorpMod.itemwhiteBucket, new ItemStack(ScorpMod.itemwhitedirtyBottle, 1, 0), 0.7F);
		addMixerRecipe(ScorpMod.itememptyBottle, ScorpMod.itemgreenBucket, new ItemStack(ScorpMod.itemgreendirtyBottle, 1, 0), 0.7F);
		addMixerRecipe(ScorpMod.itememptyBottle, ScorpMod.itempurpleBucket, new ItemStack(ScorpMod.itempurpledirtyBottle, 1, 0), 0.7F);
		addMixerRecipe(ScorpMod.itememptyBottle, ScorpMod.itemyellowBucket, new ItemStack(ScorpMod.itemyellowdirtyBottle, 1, 0), 0.7F);
		addMixerRecipe(ScorpMod.itememptyBottle, ScorpMod.itemredBucket, new ItemStack(ScorpMod.itemreddirtyBottle, 1, 0), 0.7F);
		addMixerRecipe(ScorpMod.itememptyBottle, ScorpMod.itemturquoiseBucket, new ItemStack(ScorpMod.itemturquoisedirtyBottle, 1, 0), 0.7F);
	}
}
