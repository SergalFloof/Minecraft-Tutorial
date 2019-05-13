package com.marras.world.gen;

import java.util.Random;

import com.marras.init.BlockInit;
import com.marras.util.handlers.EnumHandler;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator{
	
	private WorldGenerator ore_nether_copper, ore_overworld_copper, ore_end_copper;
	private WorldGenerator ore_nether_aluminum, ore_overworld_aluminum, ore_end_aluminum;

	
	
	public WorldGenCustomOres() {
		ore_nether_copper = new WorldGenMinable(BlockInit.ORE_NETHER_COPPER.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_overworld_copper = new WorldGenMinable(BlockInit.ORE_OVERWORLD_COPPER.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
		ore_end_copper = new WorldGenMinable(BlockInit.ORE_END_COPPER.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.END_STONE));

		ore_nether_aluminum = new WorldGenMinable(BlockInit.ORE_NETHER_ALUMINUM.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.NETHERRACK));
		ore_overworld_aluminum = new WorldGenMinable(BlockInit.ORE_OVERWORLD_ALUMINUM.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.STONE));
		ore_end_aluminum = new WorldGenMinable(BlockInit.ORE_END_ALUMINUM.getDefaultState(), 9, BlockMatcher.forBlock(Blocks.END_STONE));

		
		
		
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		
		switch(world.provider.getDimension()) {
		
		case -1:
			runWorldGen(ore_nether_copper, world, random, chunkX, chunkZ, 50, 0, 100);
			runWorldGen(ore_nether_aluminum, world, random, chunkX, chunkZ, 50, 0, 100);
			break;
		
		case 0:
			runWorldGen(ore_overworld_copper, world, random, chunkX, chunkZ, 50, 0, 100);
			runWorldGen(ore_overworld_aluminum, world, random, chunkX, chunkZ, 50, 0, 100);

			break;
			
		case 1:
			runWorldGen(ore_end_copper, world, random, chunkX, chunkZ, 50, 0, 256);
			runWorldGen(ore_end_aluminum, world, random, chunkX, chunkZ, 50, 0, 256);

		
		}
		
	}
	
	
	private void runWorldGen(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
		
		if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");
		
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance; i++) {
			
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);

			gen.generate(world, rand, new BlockPos(x,y,z));
		}
		
		
		
	}
	

}
