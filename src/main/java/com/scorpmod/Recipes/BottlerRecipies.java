package com.scorpmod.Recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BottlerRecipies
{
        private Map<ArrayList<Item>, ItemStack> bottlerList = new HashMap<ArrayList<Item>, ItemStack>();
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
                addMixerRecipe(Items.gold_ingot, Items.water_bucket, new ItemStack(Items.apple, 1, 0), 0.7F);
                
        }
}