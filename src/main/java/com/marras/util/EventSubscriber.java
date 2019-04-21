package com.marras.util;

import com.google.common.base.Preconditions;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReport;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

/**
 * Subscribe to events that should be handled on both PHYSICAL sides in this class
 *
 * @author Cadiboo
 */
@Mod.EventBusSubscriber(modid = Reference.MODID)
public final class EventSubscriber {

	private static final Logger LOGGER = LogManager.getLogger(Reference.MODID + " Event Subscriber");

	private static int entityId = 0;

	/**
	 * This method will be called by Forge when it is time for the mod to register its blocks.
	 * This method will always be called before the item registry method.
	 */
	@SubscribeEvent
	public static void onRegisterBlocksEvent(@Nonnull final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
			setup(new Block(Material.ROCK), "example_block")
		);

		LOGGER.debug("Registered blocks");

		// registerTileEntity(TileEntityExampleTileEntity.class, "example_tile_entity");

		LOGGER.debug("Registered tile entities");

	}

	/**
	 * Helper method to setup and register a TileEntity with the specified registry name. Makes a nice crash report if something goes wrong.
	 */
	private static void registerTileEntity(@Nonnull final Class<? extends TileEntity> clazz, @Nonnull final String name) {
		try {
			GameRegistry.registerTileEntity(clazz, new ResourceLocation(Reference.MODID, name));
		} catch (final Exception exception) {
			CrashReport crashReport = new CrashReport("Error registering Tile Entity " + clazz.getSimpleName() + " with name " + name, exception);
			crashReport.makeCategory("Registering Tile Entity");
			throw new ReportedException(crashReport);
		}
	}

	/**
	 * This method will be called by Forge when it is time for the mod to register its items.
	 * This method will always be called after the block registry method.
	 * Normal = setup(new Item(), "example_item")
	 * Normal with tab = setup(new Item().setCreativeTab(tab), "registry_name")
	 * Custom = setup(new ItemCustomItem(), "custom_item")
	 */
	@SubscribeEvent
	public static void onRegisterItemsEvent(@Nonnull final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		registry.registerAll(
			setup(new Item(), "ingot_copper")
			
		);

		ForgeRegistries.BLOCKS.getValuesCollection().stream()
		.filter(block -> block.getRegistryName().getResourceDomain().equals(Reference.MODID))
		.filter(EventSubscriber::hasItemBlock)
		.forEach(block -> {
				registry.register(setup(new ItemBlock(block), block.getRegistryName()));
		});

		LOGGER.debug("Registered items");

	}

	/**
	 * Helper method to determine if a block has an ItemBlock
	 */
	private static boolean hasItemBlock(@Nonnull final Block block) {
		return true; //change this to return false if the block doesn't have an ItemBlock
	}

	/**
	 * This method will be called by Forge when it is time for the mod to register its entity entries.
	 */
	@SubscribeEvent
	public static void onRegisterEntitiesEvent(@Nonnull final RegistryEvent.Register<EntityEntry> event) {

//		final ResourceLocation exampleEntity1RegistryName = new ResourceLocation(ModReference.MOD_ID, "example_entity_1");
//		final ResourceLocation exampleEntity2RegistryName = new ResourceLocation(ModReference.MOD_ID, "example_entity_2");
//
//		event.getRegistry().registerAll(
//			EntityEntryBuilder.create()
//				.entity(EntityExampleEntity1.class)
//				.id(exampleEntity1RegistryName, entityId++)
//				.name(exampleEntity1RegistryName.getPath())
//				.tracker(maxUpdateDistanceInBlocks, timeBetweenUpdatePackets, shouldSendVelocityUpdates)
//				.egg(primaryColor, secondaryColor)
//				.build(),
//			EntityEntryBuilder.create()
//				.entity(EntityExampleEntity2.class)
//				.id(exampleEntity2RegistryName, entityId++)
//				.name(exampleEntity2RegistryName.getPath())
//				.tracker(maxUpdateDistanceInBlocks, timeBetweenUpdatePackets, shouldSendVelocityUpdates)
//				.egg(primaryColor, secondaryColor)
//				.build()
//		);

//		LOGGER.debug("Registered entities");

	}

	/**
	 * Helper method to correctly setup a registry entry.
	 * Calls setRegistryName with the appropriate parameters
	 * If applicable also calls setTranslationKey with the appropriate parameters
	 * @return Returns the entry passed in
	 */
	@Nonnull
	public static <T extends IForgeRegistryEntry<?>> T setup(@Nonnull final T entry, @Nonnull final String resourceLocation) {
		return setup(entry, new ResourceLocation(resourceLocation));
	}

	/**
	 * Helper method to correctly setup a registry entry.
	 * Calls setRegistryName with the appropriate parameters
	 * If applicable also calls setTranslationKey with the appropriate parameters
	 * @return Returns the entry passed in
	 */
	@Nonnull
	public static <V extends IForgeRegistryEntry<?>> V setup(@Nonnull final V entry, @Nonnull final ResourceLocation registryName) {

		Preconditions.checkNotNull(entry, "entry to setup must not be null!");
		Preconditions.checkNotNull(registryName, "registryName to assign must not be null!");

		entry.setRegistryName(registryName);
		if (entry instanceof Block) {
			((Block) entry).setUnlocalizedName(registryName.getResourceDomain() + "." + registryName.getResourcePath());
		}
		if (entry instanceof Item) {
			((Item) entry).setUnlocalizedName(registryName.getResourceDomain() + "." + registryName.getResourcePath());
		}
		return entry;
	}

}