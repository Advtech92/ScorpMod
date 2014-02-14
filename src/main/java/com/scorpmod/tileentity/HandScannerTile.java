package com.scorpmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class HandScannerTile extends TileBaseScorpMod
{
	public String oName;
	public int power;
	public int status;
	
	public HandScannerTile()
	{
		oName = "null";
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		nbt.setString("oName", oName);
		nbt.setInteger("power", power);
		nbt.setInteger("status", status);
		super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		oName = nbt.getString("oName");
		power = nbt.getInteger("power");
		status = nbt.getInteger("status");
		System.out.println(oName);
	}
}