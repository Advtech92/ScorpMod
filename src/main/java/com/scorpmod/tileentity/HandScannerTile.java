package com.scorpmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class HandScannerTile extends TileEntity {
        
        public String oName;

        @Override
        public void writeToNBT(NBTTagCompound nbt){
        		super.writeToNBT(nbt);
                nbt.setString("oName", oName);
                
        }
        
        @Override
        public void readFromNBT(NBTTagCompound nbt){
        		super.readFromNBT(nbt);
                System.out.println(oName);
                

        }

}