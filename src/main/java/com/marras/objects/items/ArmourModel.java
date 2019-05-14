package com.marras.objects.items;

import com.marras.Main;
import com.marras.init.ItemInit;
import com.marras.objects.ModelCustomArmour;
import com.marras.util.interfaces.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ArmourModel extends ItemArmor implements IHasModel{

	public ArmourModel(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, 1, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.maintab);
		setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		
		Main.proxy.registerModel(this, 0);
		
	}
	
	@Override
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
		if(itemStack != itemStack.EMPTY) {
			if(itemStack.getItem() instanceof ItemArmor) {
				ModelCustomArmour model = new ModelCustomArmour();
				
				model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				
				model.isChild = _default.isChild;
				model.isRiding = _default.isRiding;
				model.isSneak = _default.isSneak;
				model.rightArmPose = _default.rightArmPose;
				model.leftArmPose = _default.leftArmPose;
				
				return model;
			}
		}
		
		return null;
	}

}
