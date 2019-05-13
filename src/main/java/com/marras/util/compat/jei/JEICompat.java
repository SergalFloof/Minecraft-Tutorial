package com.marras.util.compat.jei;

import java.util.IllegalFormatException;

import com.marras.objects.blocks.container.ContainerSinteringFurnace;
import com.marras.objects.blocks.machines.sinterer.GuiSinteringFurnace;
import com.marras.util.compat.jei.sinterer.SintererRecipeCategory;
import com.marras.util.compat.jei.sinterer.SintererRecipeMaker;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.util.text.translation.I18n;

@JEIPlugin
public class JEICompat implements IModPlugin{
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		final IJeiHelpers helpers = registry.getJeiHelpers();
		final IGuiHelper gui = helpers.getGuiHelper();
		
		registry.addRecipeCategories(new SintererRecipeCategory(gui));
	}
	
	@Override
	public void register(IModRegistry registry) {
		final IIngredientRegistry ingReg = registry.getIngredientRegistry();
		final IJeiHelpers helpers = registry.getJeiHelpers();
		IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
		
		registry.addRecipes(SintererRecipeMaker.getRecipes(helpers), RecipeCategories.SINTERER);
		registry.addRecipeClickArea(GuiSinteringFurnace.class, 110, 0, 50, 50, RecipeCategories.SINTERER);
		recipeTransfer.addRecipeTransferHandler(ContainerSinteringFurnace.class, RecipeCategories.SINTERER, 0, 1, 3, 36);
		
	}
	
	public static String translateToLocal(String key) {
		if(I18n.canTranslate(key)) return I18n.translateToLocal(key);
		else return I18n.translateToFallback(key);
	}
	
	public static String translateToLocalFormatted(String key, Object... format) {
		String s = translateToLocal(key);
		try {
			return String.format(s, format);
		}catch(IllegalFormatException e) {
			return "Format error: " + s;
		}
		
	}

}
