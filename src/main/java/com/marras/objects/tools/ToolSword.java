package com.marras.objects.tools;

import com.marras.Main;
import com.marras.init.ItemInit;
import com.marras.util.IHasModel;

import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword implements IHasModel {

	public ToolSword(String name, ToolMaterial material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.maintab);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "Inventory");
		
	}

}
