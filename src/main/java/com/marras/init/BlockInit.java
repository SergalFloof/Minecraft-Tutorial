package com.marras.init;

import java.util.ArrayList;
import java.util.List;

import com.marras.objects.blocks.BlockBase;
import com.marras.objects.blocks.BlockCopperChest;
import com.marras.objects.blocks.BlockDirts;
import com.marras.objects.blocks.BlockSantaHat;
import com.marras.objects.blocks.BlockSinteringFurnace;
import com.marras.objects.blocks.BlockTeleporter;
import com.marras.objects.blocks.trees.BlockLeave;
import com.marras.objects.blocks.trees.BlockLogs;
import com.marras.objects.blocks.trees.BlockPlank;
import com.marras.objects.blocks.trees.BlockSaplings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	//Blocks
	public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.IRON);
	//Ores
	public static final Block ORE_END_COPPER = new BlockBase("ore_end_copper", Material.ROCK);
	public static final Block ORE_NETHER_COPPER = new BlockBase("ore_nether_copper", Material.ROCK);
	public static final Block ORE_OVERWORLD_COPPER = new BlockBase("ore_overworld_copper", Material.ROCK);
	
	public static final Block ORE_END_ALUMINUM = new BlockBase("ore_end_aluminum", Material.ROCK);
	public static final Block ORE_NETHER_ALUMINUM = new BlockBase("ore_nether_aluminum", Material.ROCK);
	public static final Block ORE_OVERWORLD_ALUMINUM = new BlockBase("ore_overworld_aluminum", Material.ROCK);
	//Trees
	public static final Block PLANKS = new BlockPlank("planks");
	public static final Block LOGS = new BlockLogs("logs");
	public static final Block LEAVES = new BlockLeave("leaves");
	public static final Block SAPLINGS = new BlockSaplings("saplings");
	
	public static final Block DIRT = new BlockDirts("dirt");
	
	public static final Block SANTA_HAT = new BlockSantaHat("santa_hat");
	
	public static final Block SINTERING_FURNACE = new BlockSinteringFurnace("sintering_furnace");
	public static final Block TELEPORT_BLOCK = new BlockTeleporter("teleport_block", Material.ROCK);
	
	public static final Block COPPER_CHEST = new BlockCopperChest("copper_chest");
	

}
