package com.marras.init;

import java.util.ArrayList;
import java.util.List;

import com.marras.objects.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.IRON);
	
	public static final Block ORE_END = new BlockOres("ore_end", "end");
	public static final Block ORE_NETHER = new BlockOres("ore_nether", "nether");
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");

}
