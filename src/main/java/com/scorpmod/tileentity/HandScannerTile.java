package com.scorpmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class HandScannerTile extends TileBaseScorpMod
{
	public String oName;

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setString("oName", oName);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		System.out.println(oName);
	}
}