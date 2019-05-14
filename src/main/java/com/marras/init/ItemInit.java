package com.marras.init;

import java.util.ArrayList;
import java.util.List;

import com.marras.objects.armour.ArmourBase;
import com.marras.objects.items.ArmourModel;
import com.marras.objects.items.ItemBase;
import com.marras.objects.tools.StaffFire;
import com.marras.objects.tools.ToolAxe;
import com.marras.objects.tools.ToolHoe;
import com.marras.objects.tools.ToolPickaxe;
import com.marras.objects.tools.ToolShovel;
import com.marras.objects.tools.ToolSword;
import com.marras.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Material
	public static final ToolMaterial TOOL_COPPER = EnumHelper.addToolMaterial("tool_copper", 2, 180, 5.0F, 1.5F, 5);
	public static final ArmorMaterial ARMOUR_COPPER = EnumHelper.addArmorMaterial("armour_copper", Reference.MODID + ":copper", 13, new int[]{2, 5, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial CUSTOM_ARMOR = EnumHelper.addArmorMaterial("cutom_armor", Reference.MODID + ":custom_armor", 13, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	
	//Items
	public static final Item INGOT_COPPER = new ItemBase("ingot_copper");
	
	//Tools
	public static final Item AXE_COPPER = new ToolAxe("axe_copper", TOOL_COPPER);
	public static final Item HOE_COPPER = new ToolHoe("hoe_copper", TOOL_COPPER);
	public static final Item PICKAXE_COPPER = new ToolPickaxe("pickaxe_copper", TOOL_COPPER);
	public static final Item SHOVEL_COPPER = new ToolShovel("shovel_copper", TOOL_COPPER);
	public static final Item SWORD_COPPER = new ToolSword("sword_copper", TOOL_COPPER);
	public static final Item STAFF_FIRE = new StaffFire("staff_fire");
	
	//Armour
	public static final Item HELMET_COPPER = new ArmourBase("helmet_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_COPPER = new ArmourBase("chestplate_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_COPPER = new ArmourBase("leggings_copper", ARMOUR_COPPER, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_COPPER = new ArmourBase("boots_copper", ARMOUR_COPPER, 1, EntityEquipmentSlot.FEET);
	
	public static final Item CUSTOM_HELMET = new ArmourModel("custom_helmet", CUSTOM_ARMOR, EntityEquipmentSlot.HEAD);
	public static final Item CUSTOM_CHESTPLATE = new ArmourModel("custom_chestplate", CUSTOM_ARMOR, EntityEquipmentSlot.CHEST);
	public static final Item CUSTOM_LEGGINGS = new ArmourModel("custom_leggings", CUSTOM_ARMOR, EntityEquipmentSlot.LEGS);
	public static final Item CUSTOM_BOOTS = new ArmourModel("custom_boots", CUSTOM_ARMOR, EntityEquipmentSlot.FEET);

}
