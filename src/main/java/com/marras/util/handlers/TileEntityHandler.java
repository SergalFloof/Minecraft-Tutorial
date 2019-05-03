package com.marras.util.handlers;

import com.marras.objects.blocks.machines.sinterer.TileEntitySinteringFurnace;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	public static void registerTileEntitys() {
		
		GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, "sintering_furnace");
	}

}
