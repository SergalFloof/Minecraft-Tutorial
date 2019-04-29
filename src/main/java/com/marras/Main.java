package com.marras;

import com.marras.proxy.CommonProxy;
import com.marras.tabs.TutorialTab;
import com.marras.util.Reference;
import com.marras.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
{
	
	public static final CreativeTabs maintab = new TutorialTab("maintab");
	
	@Instance
	public static Main instance;
	
	
	@SidedProxy (clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY )
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries();
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		RegistryHandler.postInitRegistries();
	
		
	}

}
