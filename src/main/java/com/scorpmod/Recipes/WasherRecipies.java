package com.scorpmod.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.scorpmod.ScorpMod;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WasherRecipies
{
        private Map<ArrayList<Item>, ItemStack> washerList = new HashMap<ArrayList<Item>, ItemStack>();
        private Map<Item, Float> washerExperience = new HashMap<Item, Float>();
        private static final WasherRecipies washerBase = new WasherRecipies();

        public static final WasherRecipies instance()
        {
                return washerBase;
        }

        public ItemStack getRecipeResult(Item item, Item item2)
        {
                ArrayList<Item> array1 = new ArrayList<Item>(), array2 = new ArrayList<Item>();
                
                array1.add(item);
                array1.add(item2);
                
                array2.add(item2);
                array2.add(item);
                
                return washerList.get(array1) == null ? washerList.get(array2) : washerList.get(array1);
        }

        public void addMixerRecipe(Item item1, Item item2, ItemStack itemStack, float experience)
        {
                ArrayList<Item> array = new ArrayList<Item>();
                array.add(item1);
                array.add(item2);
                
                washerList.put(array, itemStack);
                this.washerExperience.put(itemStack.getItem(), Float.valueOf(experience));
        }

        public float getExperience(int par1)
        {
                return this.washerExperience.containsKey(Integer.valueOf(par1)) ? this.washerExperience.get(Integer.valueOf(par1)).floatValue() : 0.0F;
        }

        private WasherRecipies()
        {
                addMixerRecipe(ScorpMod.itemfluidFilter, ScorpMod.itemreddirtyBottle, new ItemStack(ScorpMod.itemredBottle, 1, 0), 0.7F);
                addMixerRecipe(ScorpMod.itemfluidFilter, ScorpMod.itemyellowdirtyBottle, new ItemStack(ScorpMod.itemyellowBottle, 1, 0), 0.7F);
                addMixerRecipe(ScorpMod.itemfluidFilter, ScorpMod.itemwhitedirtyBottle, new ItemStack(ScorpMod.itemwhiteBottle, 1, 0), 0.7F);
                addMixerRecipe(ScorpMod.itemfluidFilter, ScorpMod.itemturquoisedirtyBottle, new ItemStack(ScorpMod.itemturquoiseBottle, 1, 0), 0.7F);
                addMixerRecipe(ScorpMod.itemfluidFilter, ScorpMod.itempurpledirtyBottle, new ItemStack(ScorpMod.itempurpleBottle, 1, 0), 0.7F);
                addMixerRecipe(ScorpMod.itemfluidFilter, ScorpMod.itemgreendirtyBottle, new ItemStack(ScorpMod.itemgreenBottle, 1, 0), 0.7F);
                
        }
}