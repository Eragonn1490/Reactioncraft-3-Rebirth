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
    	IntegratedRecipesRegistry.weaponsRecipesInit();
    	IntegratedRecipesRegistry.foodRecipesInit();
    	//IntegratedRecipesRegistry.loadDesertRecipes();
    	IntegratedRecipesRegistry.desertRecipesInit();
    	IntegratedRecipesRegistry.loadPlants();
    	IntegratedRecipesRegistry.loadORES();
    	//IntegratedRecipesRegistry.loadCurrency();
    	IntegratedRecipesRegistry.currencyRecipesInit();
    	IntegratedRecipesRegistry.loadCore();
    	IntegratedRecipesRegistry.miscRecipesInit();
	}
}