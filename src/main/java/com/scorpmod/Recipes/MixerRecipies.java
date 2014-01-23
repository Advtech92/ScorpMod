package com.scorpmod.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MixerRecipies
{
        private Map<ArrayList<String>, ItemStack> mixerList = new HashMap<ArrayList<String>, ItemStack>();
        private Map<String, Float> mixerExperience = new HashMap<String, Float>();
        private static final MixerRecipies mixerBase = new MixerRecipies();

        public static final MixerRecipies instance()
        {
                return mixerBase;
        }

        public ItemStack getRecipeResult(int id1, int id2)
        {
                ArrayList<Integer> array1 = new ArrayList<Integer>(), array2 = new ArrayList<Integer>();
                
                array1.add(id1);
                array1.add(id2);
                
                array2.add(id2);
                array2.add(id1);
                
                return mixerList.get(array1) == null ? mixerList.get(array2) : mixerList.get(array1);
        }

        public void addMixerRecipe(String id1, String id2, ItemStack itemStack, float experience)
        {
                ArrayList<String> array = new ArrayList<String>();
                array.add(id1);
                array.add(id2);
                
                mixerList.put(array, itemStack);
                this.mixerExperience.put(String.valueOf(itemStack), Float.valueOf(experience));
        }

        public float getExperience(int par1)
        {
                return this.mixerExperience.containsKey(Integer.valueOf(par1)) ? this.mixerExperience.get(Integer.valueOf(par1)).floatValue() : 0.0F;
        }

        private MixerRecipies()
        {
                addMixerRecipe(Items.gold_ingot, Items.water_bucket, new ItemStack(CommanderAdz.itemyellowBucket, 1, 0), 0.7F);
                addMixerRecipe(Items.redstone, Items.water_bucket, new ItemStack(CommanderAdz.itemredBucket, 1, 0), 0.7F);
                addMixerRecipe(Items.emerald, Items.water_bucket, new ItemStack(CommanderAdz.itemgreenBucket, 1, 0), 0.7F);
                addMixerRecipe(Items.sugar, Items.water_bucket, new ItemStack(CommanderAdz.itemwhiteBucket, 1, 0), 0.7F);
                addMixerRecipe(Items.diamond, Items.water_bucket, new ItemStack(CommanderAdz.itemturquoiseBucket, 1, 0), 0.7F);
                addMixerRecipe(CommanderAdz.itempurplePowder.itemID, Item.bucketWater.itemID, new ItemStack(CommanderAdz.itempurpleBucket, 1, 0), 0.7F);
        }
}