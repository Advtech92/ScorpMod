package com.scorpmod.blocks;

import net.minecraft.block.Block;

import com.scorpmod.tileentity.HandScannerTile;
import com.scorpmod.tileentity.TileMixer;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{

	public static Block scorpBlock;
	public static Block blockcommanderAdz;
	public static Block blockhandScanner;
	public static Block blockliquidMixer;
	public static Block blockliquidWasher;
	public static Block blockliquidBottler;
	
	public static Block blockwhiteFluid;
	public static Block blockgreenFluid;
	public static Block blockpurpleFluid;
	public static Block blockredFluid;
	public static Block blockturquoiseFluid;
	public static Block blockyellowFluid;
	
	
	public static void init()
	{
		scorpBlock = new BlockScorp();
		blockhandScanner = new BlockHandScanner();
		blockliquidMixer = new BlockMixer();
		
		//BlockRegistry
		GameRegistry.registerBlock(scorpBlock, "Scorp Block");
		GameRegistry.registerBlock(blockhandScanner, "Hand Scanner");
		GameRegistry.registerBlock(blockliquidMixer, "Mixer");
		
		//TileEntity Registry
		GameRegistry.registerTileEntity(HandScannerTile.class, "HandScannerTile");
		GameRegistry.registerTileEntity(TileMixer.class, "MixrTile");
	}
}
