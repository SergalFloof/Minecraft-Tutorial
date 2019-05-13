package com.marras.util.compat.jei.sinterer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.marras.objects.blocks.machines.sinterer.SinteringFurnaceRecipes;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

public class SintererRecipeMaker {
	@SuppressWarnings("unused")
	public static List<SintererRecipe> getRecipes(IJeiHelpers helper){
		
		IStackHelper stackHelper = helper.getStackHelper();
		SinteringFurnaceRecipes instance = SinteringFurnaceRecipes.getInstance();
		Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
		List<SintererRecipe> jeiRecipes = Lists.newArrayList();
		
		for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet()) {
			
			for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
				
				ItemStack input1 = entry.getKey();
				ItemStack input2 = ent.getKey();
				ItemStack output = ent.getValue();
				List<ItemStack> inputs = Lists.newArrayList(input1, input2);
				SintererRecipe recipe = new SintererRecipe(inputs, output);
				jeiRecipes.add(recipe);
				
				
			}
			
		}
		return jeiRecipes;
	}

}
