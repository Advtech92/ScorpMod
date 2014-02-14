package com.scorpmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class HandScannerTile extends TileBaseScorpMod
{
	public String oName;
	public int power;
	public int status;

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		nbt.setString("oName", oName);
		nbt.setInteger("power", power);
		nbt.setInteger("status", status);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		nbt.getString("oName");
		nbt.getString("power");
		nbt.getString("status");
		System.out.println(oName);
	}
}