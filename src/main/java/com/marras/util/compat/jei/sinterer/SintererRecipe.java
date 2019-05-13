package com.marras.util.compat.jei.sinterer;

import java.awt.Color;
import java.util.List;

import com.marras.objects.blocks.machines.sinterer.SinteringFurnaceRecipes;
import com.marras.util.compat.jei.JEICompat;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;

public class SintererRecipe implements IRecipeWrapper{
	
	private final List<ItemStack> inputs;
	private final ItemStack output;
	
	public SintererRecipe(List<ItemStack> inputs, ItemStack output) {
		this.inputs = inputs;
		this.output = output;
	}
	
	@Override
	public void getIngredients(IIngredients ingredients) {
		
		ingredients.setInput(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
		
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		SinteringFurnaceRecipes recipes = SinteringFurnaceRecipes.getInstance();
		float experience = recipes.getSinteringExperience(output);
		
		if(experience > 0) {
			
			String experiencesString = JEICompat.translateToLocalFormatted("gui.jei.category.smelting.experience", experience);
			FontRenderer renderer = minecraft.fontRenderer;
			int stringWidth = renderer.getStringWidth(experiencesString);
			renderer.drawString(experiencesString, recipeWidth - stringWidth, 0, Color.GRAY.getRGB());
		}
	}

}
