package com.scorpmod.handler;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class BucketHandler {

    public static BucketHandler INSTANCE = new BucketHandler();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();

    private BucketHandler() {
    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {

            ItemStack result = fillCustomBucket(event.world, event.target);

            if (result == null)
                    return;

            event.result = result;
            event.setResult(Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {

            Block block = world.func_147439_a(pos.blockX, pos.blockY, pos.blockZ);

            Item bucket = buckets.get(block);
            if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
                    world.func_147449_b(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
                    return new ItemStack(bucket);
            } else
                    return null;

    }
}