package com.marras.world.biome;

import java.util.Random;

import com.marras.init.BlockInit;
import com.marras.objects.blocks.BlockDirts;
import com.marras.objects.blocks.trees.BlockPlank;
import com.marras.util.handlers.EnumHandler;
import com.marras.world.gen.generators.WorldGenCopperTree;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class BiomeCopper extends Biome {
	
	protected static final WorldGenAbstractTree TREE = new WorldGenCopperTree();
	
	public BiomeCopper() {
		super (new BiomeProperties("Copper").setBaseHeight(1.5f).setHeightVariation(1.2f).setTemperature(0.6f).setRainDisabled().setWaterColor(16711680));
		
		topBlock = BlockInit.DIRT.getDefaultState().withProperty(BlockDirts.VARIANT, EnumHandler.EnumType.COPPER);
		fillerBlock = BlockInit.ORE_OVERWORLD_COPPER.getDefaultState();
		
		this.decorator.coalGen = new WorldGenMinable(BlockInit.PLANKS.getDefaultState().withProperty(BlockPlank.VARIANT, EnumHandler.EnumType.COPPER), 10);
		
		this.decorator.treesPerChunk = 2;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 10, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 5, 1, 2));
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return TREE;
	}
	
}
