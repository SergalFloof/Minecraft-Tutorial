package com.marras.objects.armour;

import com.marras.Main;
import com.marras.init.ItemInit;
import com.marras.util.interfaces.IHasModel;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

public class ArmourBase extends ItemArmor implements IHasModel {

	public ArmourBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.maintab);
		
		ItemInit.ITEMS.add(this);
		
	}

	@Override
	public void registerModels() {
		
		registerItemRenderer(this, 0, "inventory");
		
	}
	
	public void registerItemRenderer(Item item, int meta, String id) {
		Main.proxy.registerItemRenderer(this, 0, "Inventory");
	}


}
