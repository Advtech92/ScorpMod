package com.scorpmod;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

import com.scorpmod.blocks.BlockBottler;
import com.scorpmod.blocks.BlockHandScanner;
import com.scorpmod.blocks.BlockMixer;
import com.scorpmod.blocks.BlockScorp;
import com.scorpmod.blocks.BlockWasher;
import com.scorpmod.handler.GuiHandler;
import com.scorpmod.items.ItemEmptyBottle;
import com.scorpmod.items.ItemFluidFilter;
import com.scorpmod.items.ItemGreenBottle;
import com.scorpmod.items.ItemGreenBucket;
import com.scorpmod.items.ItemGreenDirtyBottle;
import com.scorpmod.items.ItemPurpleBottle;
import com.scorpmod.items.ItemPurpleBucket;
import com.scorpmod.items.ItemPurpleDirtyBottle;
import com.scorpmod.items.ItemPurpleDust;
import com.scorpmod.items.ItemRedBottle;
import com.scorpmod.items.ItemRedBucket;
import com.scorpmod.items.ItemRedDirtyBottle;
import com.scorpmod.items.ItemTurquoiseBottle;
import com.scorpmod.items.ItemTurquoiseBucket;
import com.scorpmod.items.ItemTurquoiseDirtyBottle;
import com.scorpmod.items.ItemWhiteBottle;
import com.scorpmod.items.ItemWhiteBucket;
import com.scorpmod.items.ItemWhiteDirtyBottle;
import com.scorpmod.items.ItemYellowBottle;
import com.scorpmod.items.ItemYellowBucket;
import com.scorpmod.items.ItemYellowDirtyBottle;
import com.scorpmod.libs.Reference;
import com.scorpmod.tileentity.HandScannerTile;
import com.scorpmod.tileentity.TileMixer;
import com.scorpmod.tileentity.TileWasher;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class ScorpMod
{
	
	@Instance(Reference.MOD_ID)
    public static ScorpMod instance;
    private GuiHandler guiHandler = new GuiHandler();

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
	
	public static Item itemfluidFilter;
	public static Item itempurpleDust;
	
	public static Item itemgreenBottle;
	public static Item itempurpleBottle;
	public static Item itemredBottle;
	public static Item itemturquoiseBottle;
	public static Item itemwhiteBottle;
	public static Item itemyellowBottle;
	
	public static Item itemgreendirtyBottle;
	public static Item itempurpledirtyBottle;
	public static Item itemreddirtyBottle;
	public static Item itemturquoisedirtyBottle;
	public static Item itemwhitedirtyBottle;
	public static Item itemyellowdirtyBottle;
	
	public static Item itememptyBottle;
	public static Item itemgreenBucket;
	public static Item itempurpleBucket;
	public static Item itemredBucket;
	public static Item itemturquoiseBucket;
	public static Item itemwhiteBucket;
	public static Item itemyellowBucket;

    public static CreativeTabs tabscorpItems = new CreativeTabs("tabscorpItems"){
         public Item getTabIconItem(){
                return ScorpMod.itemyellowBottle;
         }
        };
        
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	ModMetadata data = event.getModMetadata();
        data.name = Reference.MOD_NAME;
        data.version = Reference.MOD_VERSION;
        data.authorList = Arrays.asList(new String[] {"Scorp"});
        data.description = Reference.MOD_DESCRIPTION;
        data.autogenerated = false;
        
        scorpBlock = new BlockScorp();
		blockhandScanner = new BlockHandScanner();
		blockliquidMixer = new BlockMixer();
		blockliquidBottler = new BlockBottler();
		blockliquidWasher = new BlockWasher();
		
		itemfluidFilter = new ItemFluidFilter();
		itempurpleDust = new ItemPurpleDust();
		
		itemgreenBottle = new ItemGreenBottle();
		itempurpleBottle = new ItemPurpleBottle();
		itemredBottle = new ItemRedBottle();
		itemturquoiseBottle = new ItemTurquoiseBottle();
		itemwhiteBottle = new ItemWhiteBottle();
		itemyellowBottle = new ItemYellowBottle();
		
		itemgreendirtyBottle = new ItemGreenDirtyBottle();
		itempurpledirtyBottle = new ItemPurpleDirtyBottle();
		itemreddirtyBottle = new ItemRedDirtyBottle();
		itemturquoisedirtyBottle = new ItemTurquoiseDirtyBottle();
		itemwhitedirtyBottle = new ItemWhiteDirtyBottle();
		itemyellowdirtyBottle = new ItemYellowDirtyBottle();
		
		itememptyBottle = new ItemEmptyBottle();
		
		itemgreenBucket = new ItemGreenBucket();
		itempurpleBucket = new ItemPurpleBucket();
		itemredBucket = new ItemRedBucket();
		itemturquoiseBucket = new ItemTurquoiseBucket();
		itemwhiteBucket = new ItemWhiteBucket();
		itemyellowBucket = new ItemYellowBucket();

		registerBlock(scorpBlock, "Scorp Block");
		registerBlock(blockhandScanner, "Hand Scanner");
		registerBlock(blockliquidMixer, "Mixer");
		registerBlock(blockliquidBottler, "Bottler");
		registerBlock(blockliquidWasher, "Washer");
		
		registerItem(itemfluidFilter, "Filter");
		registerItem(itempurpleDust, "Purple Dust");
		
		registerItem(itemgreenBottle, "Green Bottle");
		registerItem(itempurpleBottle, "Purple Bottle");
		registerItem(itemredBottle, "Red Bottle");
		registerItem(itemturquoiseBottle, "Turquoise Bottle");
		registerItem(itemwhiteBottle, "White Bottle");
		registerItem(itemyellowBottle, "Yellow Bottle");
		
		registerItem(itemgreendirtyBottle, "Dirty Green Bottle");
		registerItem(itempurpledirtyBottle, "Dirty Purple Bottle");
		registerItem(itemreddirtyBottle, "Dirty Red Bottle");
		registerItem(itemturquoisedirtyBottle, "Dirty Turquoise Bottle");
		registerItem(itemwhitedirtyBottle, "Dirty White Bottle");
		registerItem(itemyellowdirtyBottle, "Dirty Yellow Bottle");
		
		registerItem(itememptyBottle, "Empty Bottle");
		
		registerItem(itemgreenBucket, "Green Bucket");
		registerItem(itempurpleBucket, "Purple Bucket");
		registerItem(itemredBucket, "Red Bucket");
		registerItem(itemturquoiseBucket, "Turquoise Bucket");
		registerItem(itemwhiteBucket, "White Bucket");
		registerItem(itemyellowBucket, "Yellow Bucket");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
		//TileEntity Registry
		GameRegistry.registerTileEntity(HandScannerTile.class, "HandScannerTile");
		GameRegistry.registerTileEntity(TileMixer.class, "MixerTile");
		GameRegistry.registerTileEntity(TileMixer.class, "BottlerTile");
		GameRegistry.registerTileEntity(TileWasher.class, "WasherTile");
		networkRegisters();
		
		GameRegistry.addRecipe(new ItemStack(ScorpMod.itemfluidFilter),
				new Object[]{
			"sss",
			"sgs",
			"sss",
			's', Items.stick,
			'g', Blocks.glass_pane,
		});
		
		GameRegistry.addRecipe(new ItemStack(ScorpMod.itememptyBottle),
				new Object[]{
			" c ",
			"g g",
			" g ",
			'c', Items.clay_ball,
			'g', Blocks.glass_pane,
		});
		
		GameRegistry.addRecipe(new ItemStack(ScorpMod.blockhandScanner),
				new Object[]{
			"cic",
			"iri",
			"cic",
			'c', Items.clay_ball,
			'i', Items.iron_ingot,
			'r', Items.redstone,
		});
		
		GameRegistry.addRecipe(new ItemStack(ScorpMod.blockliquidBottler),
				new Object[]{
			"ibi",
			"iBi",
			"ici",
			'i', Items.iron_ingot,
			'b', ScorpMod.itememptyBottle,
			'B', Items.bucket,
			'c', Items.clay_ball,
		});
		
		GameRegistry.addRecipe(new ItemStack(ScorpMod.blockliquidMixer),
				new Object[]{
			"iBi",
			"iri",
			"ici",
			'i', Items.iron_ingot,
			'B', Items.bucket,
			'r', Items.redstone,
			'c', Items.clay_ball,
		});
		
		GameRegistry.addRecipe(new ItemStack(ScorpMod.blockliquidWasher),
				new Object[]{
			"ifi",
			"iri",
			"ici",
			'i', Items.iron_ingot,
			'r', Items.redstone,
			'f', ScorpMod.itemfluidFilter,
			'c', Items.clay_ball,
		});
		ItemStack dyeStack = new ItemStack(Items.dye, 1, 5);
		GameRegistry.addShapelessRecipe(new ItemStack(ScorpMod.itempurpleDust, 1),
				dyeStack, Items.sugar);
    }
    
    public static void registerBlock(Block block, String name){
    	GameRegistry.registerBlock(block, name);
    }
    
    public static void registerItem(Item item, String name){
    	GameRegistry.registerItem(item, name);
    }
    public void networkRegisters(){
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, guiHandler);
}
}