package com.scorpmod.blocks;

import com.scorpmod.ScorpMod;
import com.scorpmod.libs.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockLightScorpMod extends Block
{
	public BlockLightScorpMod(String name)
	{
		super(Material.iron);
		setBlockName(name);
		setCreativeTab(ScorpMod.tabscorpBlocks);
		setLightLevel(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg)
	{
		this.blockIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
