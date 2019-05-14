package com.marras.util.handlers;

import com.marras.Main;
import com.marras.commands.CommandDimensionTeleport;
import com.marras.entity.EntityInit;
import com.marras.init.BiomeInit;
import com.marras.init.BlockInit;
import com.marras.init.DimensionInit;
import com.marras.init.ItemInit;
import com.marras.objects.blocks.animation.RenderCopperChest;
import com.marras.objects.blocks.tileentity.TECopperChest;
import com.marras.util.compat.OreDictionaryCompat;
import com.marras.util.interfaces.IHasModel;
import com.marras.world.gen.WorldGenCustomOres;
import com.marras.world.gen.WorldGenCustomStructures;
import com.marras.world.gen.WorldGenCustomTrees;
import com.marras.world.types.WorldTypeCopper;
import com.marras.world.types.WorldTypeCustom;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
		
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntitys();
		ClientRegistry.bindTileEntitySpecialRenderer(TECopperChest.class, new RenderCopperChest());
		
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		Main.proxy.registerModel(Item.getItemFromBlock(BlockInit.COPPER_CHEST), 0);
		
		
		for (Item item : ItemInit.ITEMS) {
			
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		
		for (Block block : BlockInit.BLOCKS) {
			
			if(block instanceof IHasModel) {
				
				((IHasModel)block).registerModels();
				
			}
		}
		
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event) {
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		
		BiomeInit.registerBiomes();
		DimensionInit.registerDimension();
		EntityInit.registerEntity();
		RenderHandler.registerEntityRenders();
		
		ConfigHandler.registerConfig(event);

		
	}
	
	public static void initRegistries(FMLInitializationEvent event) {
		RecipeHandler.registerSmelting();
		SoundsHandler.registerSounds();
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GUIHandler());
		OreDictionaryCompat.registerOres();
	}
	
	@SuppressWarnings("unused")
	public static void postInitRegistries(FMLPostInitializationEvent event) {
		
		WorldType COPPER = new WorldTypeCopper();
		WorldType CUSTOM = new WorldTypeCustom();
		
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
		
		event.registerServerCommand(new CommandDimensionTeleport());
		
	}
	

}
