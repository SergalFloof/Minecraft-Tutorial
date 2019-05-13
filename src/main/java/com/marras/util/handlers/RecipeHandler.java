package com.marras.util.handlers;

import com.marras.init.BlockInit;
import com.marras.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerSmelting() {
		
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_OVERWORLD_COPPER ,1 ,0), new ItemStack(ItemInit.INGOT_COPPER, 1), 1.0f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_NETHER_COPPER ,1 ,0), new ItemStack(ItemInit.INGOT_COPPER, 2), 1.0f);
		GameRegistry.addSmelting(new ItemStack(BlockInit.ORE_END_COPPER ,1 ,0), new ItemStack(ItemInit.INGOT_COPPER, 3), 1.0f);
		
		
	}

}
