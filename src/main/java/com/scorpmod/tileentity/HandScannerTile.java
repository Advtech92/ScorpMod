package com.scorpmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class HandScannerTile extends TileEntity {
        
        public String oName;

        @Override
        public void func_145839_a(NBTTagCompound nbt){
                nbt.setString("oName", oName);
                System.out.println("Written NBT");
                super.func_145839_a(nbt);
        }
        
        @Override
        public void func_145841_b(NBTTagCompound nbt2){
                oName = nbt2.getString("oName");
                System.out.println("Read NBT");
                System.out.println(oName);
                super.func_145841_b(nbt2);
        }

}