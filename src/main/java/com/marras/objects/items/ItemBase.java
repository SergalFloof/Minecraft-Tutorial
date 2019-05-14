package com.marras.objects.items;

import com.marras.Main;
import com.marras.init.ItemInit;
import com.marras.util.interfaces.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item  implements IHasModel{

	public ItemBase(String name) {
		
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
