package com.scorpmod.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDrink extends Item
{
	public class potionType
	{
		public int id, length, level;

		public potionType(int id, int length, int level)
		{
			this.id = id;
			this.length = length;
			this.level = level;
		}
	}
	
	public ItemDrink()
	{
		super();
		pots = new potionType[1];
	}

	public potionType[] pots;

	public ItemDrink(String unlocName, potionType... pot)
	{
		super();
		setUnlocalizedName(unlocName);
		setCreativeTab(ScorpMod.tabscorpItems);
		setMaxStackSize(1);
		pots = pot;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg)
	{
		this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	@Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par3EntityPlayer.capabilities.isCreativeMode)
		{
			--par1ItemStack.stackSize;
		}
		if (!par2World.isRemote)
		{
			for (potionType p : pots)
				par3EntityPlayer.addPotionEffect(new PotionEffect(p.id, p.length, p.level, true));
		}
		return par1ItemStack.stackSize <= 0 ? new ItemStack(ScorpMod.itememptyBottle) : par1ItemStack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool)
	{
		dataList.add("\u00a7bNice and Clean");
	}
}