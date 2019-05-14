package com.marras.objects.tools;

import com.marras.Main;
import com.marras.init.ItemInit;
import com.marras.util.interfaces.IHasModel;

import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe implements IHasModel {

	public ToolHoe(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.maintab);
		
		ItemInit.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerModel(this, 0);
		
	}
	
	

}
