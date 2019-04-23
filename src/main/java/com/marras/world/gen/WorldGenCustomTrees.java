package com.marras.world.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.marras.world.biome.BiomeCopper;
import com.marras.world.gen.generators.WorldGenAluminumTree;
import com.marras.world.gen.generators.WorldGenCopperTree;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomTrees implements IWorldGenerator{
	
	private final WorldGenerator ALUMINUM = new WorldGenAluminumTree();
	private final WorldGenerator COPPER = new WorldGenCopperTree();
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		case -1:
			break;
		case 0:
			runGenerator(ALUMINUM, world, random, chunkX, chunkZ, 3d, -1, 0, BiomeForest.class);
			runGenerator(COPPER, world, random, chunkX, chunkZ, 3d, -1, 0, BiomeCopper.class);
			break;
		case 1:
			
		}
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, double spawn, int minHeight, int maxHeight, Class<?>... biomes){
		if(spawn < 1){
			if(rand.nextDouble() < spawn) spawn = 1;
			else spawn = 0;
		}
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(biomes));
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < spawn; i++){
			BlockPos pos = new BlockPos(chunkX * 16 + 10 + rand.nextInt(15), minHeight + rand.nextInt(heightDiff), chunkZ * 16 + 10 + rand.nextInt(15));
			if(minHeight < 0) pos = world.getHeight(pos);
			Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
			if(classesList.contains(biome) || biomes.length == 0) gen.generate(world, rand, pos);
		}
	}
		
}
