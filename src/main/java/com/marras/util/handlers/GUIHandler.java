package com.marras.util.handlers;

import com.marras.objects.blocks.container.ContainerCopperChest;
import com.marras.objects.blocks.container.ContainerElectricSinteringFurnace;
import com.marras.objects.blocks.container.ContainerEnergyStorage;
import com.marras.objects.blocks.container.ContainerGlowstoneGenerator;
import com.marras.objects.blocks.container.ContainerSinteringFurnace;
import com.marras.objects.blocks.gui.GuiCopperChest;
import com.marras.objects.blocks.gui.GuiElectricSinteringFurnace;
import com.marras.objects.blocks.gui.GuiEnergyStorage;
import com.marras.objects.blocks.gui.GuiGlowstoneGenerator;
import com.marras.objects.blocks.gui.GuiSinteringFurnace;
import com.marras.objects.blocks.tileentity.TECopperChest;
import com.marras.objects.blocks.tileentity.TEElectricSinteringFurnace;
import com.marras.objects.blocks.tileentity.TEEnergyStorage;
import com.marras.objects.blocks.tileentity.TEGlowstoneGenerator;
import com.marras.objects.blocks.tileentity.TESinteringFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ConfigHandler.GUI_SINTERING_FURNACE) return new ContainerSinteringFurnace(player.inventory, (TESinteringFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == ConfigHandler.GUI_COPPER_CHEST) return new ContainerCopperChest(player.inventory, (TECopperChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == ConfigHandler.GUI_GLOWSTONE_GENERATOR) return new ContainerGlowstoneGenerator(player.inventory, (TEGlowstoneGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == ConfigHandler.GUI_ELECTRIC_SINTERING_FURNACE) return new ContainerElectricSinteringFurnace(player.inventory, (TEElectricSinteringFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == ConfigHandler.GUI_ENERGY_STORAGE) return new ContainerEnergyStorage(player.inventory, (TEEnergyStorage)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == ConfigHandler.GUI_SINTERING_FURNACE) return new GuiSinteringFurnace(player.inventory, (TESinteringFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == ConfigHandler.GUI_COPPER_CHEST) return new GuiCopperChest(player.inventory, (TECopperChest)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == ConfigHandler.GUI_GLOWSTONE_GENERATOR) return new GuiGlowstoneGenerator(player.inventory, (TEGlowstoneGenerator)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == ConfigHandler.GUI_ELECTRIC_SINTERING_FURNACE) return new GuiElectricSinteringFurnace(player.inventory, (TEElectricSinteringFurnace)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == ConfigHandler.GUI_ENERGY_STORAGE) return new GuiEnergyStorage(player.inventory, (TEEnergyStorage)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

}
