package com.marras.objects.blocks.machines.sinterer.slot;

import com.marras.objects.blocks.machines.sinterer.TileEntitySinteringFurnace;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotSinteringFurnaceFule extends Slot {
	
	public SlotSinteringFurnaceFule(IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return TileEntitySinteringFurnace.isItemFuel(stack);
	}
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return super.getItemStackLimit(stack);
	}

}
