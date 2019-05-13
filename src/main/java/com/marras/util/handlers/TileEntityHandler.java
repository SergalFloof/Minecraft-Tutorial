package com.marras.util.handlers;

import com.marras.objects.blocks.machines.sinterer.TileEntitySinteringFurnace;
import com.marras.objects.blocks.tileentity.TileEntityCopperChest;
import com.marras.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	@SuppressWarnings("deprecation")
	public static void registerTileEntitys() {
		
		GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, "sintering_furnace");
		GameRegistry.registerTileEntity(TileEntityCopperChest.class, new ResourceLocation(Reference.MODID + ":copper_chest"));
	}

}
