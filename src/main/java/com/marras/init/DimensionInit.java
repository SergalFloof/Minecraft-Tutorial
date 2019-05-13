package com.marras.init;

import com.marras.world.dimension.library.DimensionGreatLibrary;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit {
	
	public static final DimensionType LIBRARY = DimensionType.register("Library", "_library", 2, DimensionGreatLibrary.class, false);
	
	public static void registerDimension() {
		DimensionManager.registerDimension(2, LIBRARY);
		
	}

}
