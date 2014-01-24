package com.scorpmod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.scorpmod.container.ContainerBottler;
import com.scorpmod.libs.DefaultProps;
import com.scorpmod.tileentity.TileBottler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiBottler extends GuiContainer
{
        private TileBottler BottlerTile;
        public int var9 = 0;
        World world;
        int xx;
        int yy;
        int var5;
        int var6;
        int x;
        int y;
        int zz;
        int progress;

        public GuiBottler(InventoryPlayer inventory, TileBottler tile)
        {
                super(new ContainerBottler(tile, inventory));
                BottlerTile = tile;
        }

        @Override
        protected void func_146979_b(int par1, int par2)
        {
        	this.field_146289_q.drawString(StatCollector.translateToLocal("container.inventory"), 8, (field_147000_g - 96) + 2, 4210752);
                this.field_146289_q.drawString("Liquid Bottler", 66, 6, 4210752);
        }

        /**
         * Draw the background layer for the GuiContainer (everything behind the
         * items)
         */
        @Override
        @SideOnly(Side.CLIENT)
        @SuppressWarnings("unused")
        protected void func_146976_a(float par1, int par2, int par3)
        {
                int k = (this.field_146294_l - this.field_146999_f) / 2;
                int l = (this.field_146295_m - this.field_147000_g) / 2;
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                this.field_146297_k.renderEngine.bindTexture(DefaultProps.MIXER_GUI);
                var5 = (this.field_146294_l - this.field_146999_f) / 2;
                var6 = (this.field_146295_m - this.field_147000_g) / 2;

                this.drawTexturedModalRect(var5, var6, 0, 0, this.field_146999_f, this.field_147000_g);
                int var7 = 0;
                if (this.BottlerTile.canPress())
                {
                        System.out.println(this.BottlerTile.abc);
                        x = (this.field_146294_l - this.field_146999_f) / 2 + 61;
                        y = (this.field_146295_m - this.field_147000_g) / 2 + 19;
                        progress = (int) (0.59 * this.BottlerTile.abc);
                        this.drawTexturedModalRect(this.x, this.y, 177, 2, this.progress, 46);
                }
        }

}