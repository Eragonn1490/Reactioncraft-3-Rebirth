package com.reactioncraft.core.common;

import com.reactioncraft.integration.IntegratedRecipesRegistry;

public class RecipesManager 
{
	public static void registerRecipes() 
	{
		IntegratedRecipesRegistry.netrecipyInit();
    	IntegratedRecipesRegistry.machinerecipiesInit();
    	IntegratedRecipesRegistry.glassRecipesInit();
    	IntegratedRecipesRegistry.mobsRecipesInit();
    	IntegratedRecipesRegistry.loadRecipesforVanilla();
    	IntegratedRecipesRegistry.loadWeapons();
    	IntegratedRecipesRegistry.loadFood();
    	IntegratedRecipesRegistry.loadDesertRecipes();
    	IntegratedRecipesRegistry.loadPlants();
    	IntegratedRecipesRegistry.loadORES();
    	IntegratedRecipesRegistry.loadCurrency();
    	IntegratedRecipesRegistry.loadBookcases();
    	IntegratedRecipesRegistry.loadCore();
	}
}