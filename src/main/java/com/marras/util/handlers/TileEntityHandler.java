package com.marras.util.handlers;

import com.marras.objects.blocks.tileentity.TECopperChest;
import com.marras.objects.blocks.tileentity.TEElectricSinteringFurnace;
import com.marras.objects.blocks.tileentity.TEGlowstoneGenerator;
import com.marras.objects.blocks.tileentity.TESinteringFurnace;
import com.marras.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	@SuppressWarnings("deprecation")
	public static void registerTileEntitys() {
		
		GameRegistry.registerTileEntity(TESinteringFurnace.class, new ResourceLocation(Reference.MODID + ":sintering_furnace"));
		GameRegistry.registerTileEntity(TECopperChest.class, new ResourceLocation(Reference.MODID + ":copper_chest"));
		GameRegistry.registerTileEntity(TEGlowstoneGenerator.class, new ResourceLocation(Reference.MODID + ":glowstone_generator"));
		GameRegistry.registerTileEntity(TEElectricSinteringFurnace.class, new ResourceLocation(Reference.MODID + ":electric_sintering_furnace"));


	}

}
