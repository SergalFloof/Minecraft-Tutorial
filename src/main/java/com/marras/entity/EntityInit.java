package com.marras.entity;

import com.marras.Main;
import com.marras.util.Reference;
import com.marras.util.handlers.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntity() {
		registerEntity("centaur", EntityCentaur.class, ConfigHandler.ENTITY_CENTAUR, 50, 11437146, 00000000);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	

}
