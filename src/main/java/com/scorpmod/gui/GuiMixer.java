package com.scorpmod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.scorpmod.container.ContainerMixer;
import com.scorpmod.libs.GuiReferences;
import com.scorpmod.tileentity.TileMixer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiMixer extends GuiContainer
{
	private TileMixer mixerTile;
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

	public GuiMixer(InventoryPlayer inventory, TileMixer tile)
	{
		super(new ContainerMixer(tile, inventory));
		mixerTile = tile;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 4210752);
		fontRendererObj.drawString("Infused", 66, 6, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("unused")
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(GuiReferences.MIXER_GUI);
		var5 = (this.width - this.xSize) / 2;
		var6 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
		int var7 = 0;
		if (this.mixerTile.canPress())
		{
			x = (this.width - this.xSize) / 2 + 61;
			y = (this.height - this.ySize) / 2 + 19;
			progress = (int) (0.59 * this.mixerTile.abc);
			this.drawTexturedModalRect(this.x, this.y, 177, 2, this.progress, 46);
		}
	}
}