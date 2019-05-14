package com.marras.objects.blocks.gui;

import com.marras.objects.blocks.container.ContainerCopperChest;
import com.marras.objects.blocks.tileentity.TECopperChest;
import com.marras.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiCopperChest extends GuiContainer
{
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MODID + ":textures/gui/copper_chest.png");
	private final InventoryPlayer playerInventory;
	private final TECopperChest te;
	
	public GuiCopperChest(InventoryPlayer playerInventory, TECopperChest chestInventory, EntityPlayer player) 
	{
		super(new ContainerCopperChest(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 179;
		this.ySize = 256;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 16086784);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 16086784);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
