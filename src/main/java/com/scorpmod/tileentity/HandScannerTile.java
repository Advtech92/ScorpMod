package com.scorpmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class HandScannerTile extends TileEntity {
        
        public String oName;

        @Override
        public void func_145841_b(NBTTagCompound nbt){
        		System.out.println("Written NBT");
        		super.func_145839_a(nbt);
        		System.out.println(oName);
                nbt.setString("oName", oName);
                
        }
        
        @Override
        public void func_145839_a(NBTTagCompound nbt){
        		System.out.println("Read NBT");
        		super.func_145841_b(nbt);
                oName = nbt.getString("oName");
                System.out.println(oName);
                

        }

}