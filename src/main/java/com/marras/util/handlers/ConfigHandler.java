package com.marras.util.handlers;

import java.io.File;

import com.marras.Main;
import com.marras.util.Reference;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler {
	
	public static Configuration config;
	
	public static int ENTITY_CENTAUR = 120;
	public static int GUI_SINTERING_FURNACE = 1;
	public static int GUI_COPPER_CHEST = 2;
	public static int GUI_GLOWSTONE_GENERATOR = 3;
	public static int GUI_ELECTRIC_SINTERING_FURNACE = 4;
	public static int GUI_ENERGY_STORAGE = 5;
	
	public static boolean spawnCopperBiomeOverworld;
	
	public static void init(File file) {
		
		config = new Configuration(file);
		
		String category;
		
		category = "IDs";
		config.addCustomCategoryComment(category, "Set IDs for each entity and gui");
		ENTITY_CENTAUR = config.getInt("Entity Centaur ID", category, 120, 120, 200, "ID for the Entity Centaur");
		GUI_SINTERING_FURNACE = config.getInt("Sintering Furnace GUI ID", category, 0, 0, 100, "ID for the Sintering Furnace GUI");
		
		category = "Biomes";
		config.addCustomCategoryComment(category, "Biomes to spawn in Overworld");
		spawnCopperBiomeOverworld = config.getBoolean("Spawn Copper Biome in Overworld", category, true, "If you want the copper biome or not");
		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event) {
		
		Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
		Main.config.mkdir();
		init(new File(Main.config.getPath(), Reference.MODID + ".cfg"));
	}

}
