package com.marras.world.dimension.library;

import com.marras.init.BiomeInit;
import com.marras.init.DimensionInit;
import com.marras.world.gen.generators.chunk.ChunkGeneratorLibrary;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionGreatLibrary extends WorldProvider{
	
	public DimensionGreatLibrary() {
		this.biomeProvider = new BiomeProviderSingle(BiomeInit.LIBRARY_DIMENSION);
		
	}

	@Override
	public DimensionType getDimensionType() {
		return DimensionInit.LIBRARY;
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorLibrary(world, true, world.getSeed());
	}
	
	@Override
	public boolean canRespawnHere() {
		return false;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

}
