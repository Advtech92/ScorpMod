package com.scorpmod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.scorpmod.container.ContainerMixer;
import com.scorpmod.container.ContainerWasher;
import com.scorpmod.libs.GuiReferences;
import com.scorpmod.tileentity.TileMixer;
import com.scorpmod.tileentity.TileWasher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiWasher extends GuiContainer
{
        private TileWasher washerTile;
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

        public GuiWasher(InventoryPlayer inventory, TileWasher tile)
        {
                super(new ContainerWasher(tile, inventory));
                washerTile = tile;
        }

        @Override
        protected void func_146979_b(int par1, int par2)
        {
        		this.field_146289_q.drawString(StatCollector.translateToLocal("container.inventory"), 8, (field_147000_g - 96) + 2, 4210752);
                this.field_146289_q.drawString("Distillery", 66, 6, 4210752);
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
                this.field_146297_k.renderEngine.bindTexture(GuiReferences.MIXER_GUI);
                var5 = (this.field_146294_l - this.field_146999_f) / 2;
                var6 = (this.field_146295_m - this.field_147000_g) / 2;

                this.drawTexturedModalRect(var5, var6, 0, 0, this.field_146999_f, this.field_147000_g);
                int var7 = 0;
                if (this.washerTile.canPress())
                {
                        x = (this.field_146294_l - this.field_146999_f) / 2 + 61;
                        y = (this.field_146295_m - this.field_147000_g) / 2 + 19;
                        progress = (int) (0.59 * this.washerTile.abc);
                        this.drawTexturedModalRect(this.x, this.y, 177, 2, this.progress, 46);
                }
        }

}