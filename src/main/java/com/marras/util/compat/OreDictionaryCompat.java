package com.marras.util.compat;

import com.marras.init.BlockInit;
import com.marras.init.ItemInit;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryCompat {
	
	public static void registerOres() {
		
		OreDictionary.registerOre("oreCopper", BlockInit.ORE_OVERWORLD_COPPER);
		OreDictionary.registerOre("ingotCopper", ItemInit.INGOT_COPPER);
		
	}

}
