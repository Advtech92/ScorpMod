package com.scorpmod.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.scorpmod.ScorpMod;
import com.scorpmod.container.ContainerMixer;
import com.scorpmod.gui.GuiMixer;
import com.scorpmod.tileentity.TileMixer;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy implements IGuiHandler
{

	public void registerRenderings()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(ScorpMod.instance, this);
	}
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z)
	{
		TileEntity t = world.func_147438_o(x, y, z);
		if (t instanceof TileMixer)
		{
			TileMixer mixer = (TileMixer) world.func_147438_o(x, y, z);
			return new ContainerMixer(player.inventory, mixer);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z)
	{
		TileEntity t = world.func_147438_o(x, y, z);
		if (t instanceof TileMixer)
		{
			TileMixer tileMixer = (TileMixer) world.func_147438_o(x, y, z);
			return new GuiMixer(player.inventory, tileMixer);
		}
		return null;
	}

}
