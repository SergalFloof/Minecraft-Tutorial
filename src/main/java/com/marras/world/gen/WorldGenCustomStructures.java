package com.marras.world.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.marras.init.BlockInit;
import com.marras.world.biome.BiomeCopper;
import com.marras.world.gen.generators.WorldGenStructure;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.tools.nsc.doc.doclet.Generator;

public class WorldGenCustomStructures implements IWorldGenerator{
	
	public static final WorldGenStructure ARMORY = new WorldGenStructure("armory");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		
		case 1:
			break;
		case 0:
			generateStructure(ARMORY, world, random, chunkX, chunkZ, 25, BlockInit.DIRT, BiomeCopper.class);
			
			break;
		case -1:
			break;
		
		
		}
		
	}
	
	private void generateStructure(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) {
		
		ArrayList<Class<?>> classList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = calGenHeight(world, x, z, topBlock);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT) {
			
			if(classList.contains(biome)) {
				if(rand.nextInt(chance) == 0) {
					gen.generate(world, rand, pos);
				}
			}
		}
		
	}
	
	private static int calGenHeight(World world, int x, int z, Block topBlock) {
		
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 0) {
			
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == topBlock;
			
		}
		return y;
		
	}

}
