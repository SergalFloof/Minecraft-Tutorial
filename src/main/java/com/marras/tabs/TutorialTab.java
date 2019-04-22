package com.marras.tabs;

import com.marras.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TutorialTab extends CreativeTabs{
	
	public TutorialTab(String label) {
		
		super("maintab");
		
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.INGOT_COPPER);
	}

}
