package com.marras.world.biome;

import net.minecraft.world.biome.Biome;

public class BiomeLibrary extends Biome {

	public BiomeLibrary() {
		super (new BiomeProperties("Library").setBaseHeight(1.5f).setHeightVariation(1.2f).setTemperature(0.6f).setRainDisabled().setWaterColor(16711680));

	}

}
