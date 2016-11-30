package com.reactioncraft.core.common.biomes;


import java.util.ArrayList;
import java.util.Arrays;

import com.reactioncraft.desert.common.BiomeGenReactionDesert;

import net.minecraft.init.Biomes;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ReactionBiomeManager2 
{
	public static void registerBiomes()
	{
		Biome RcDesert = new BiomeGenReactionDesert((new Biome.BiomeProperties("Darksand Desert")).setBaseBiome("desert").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(2.0F).setRainfall(0.0F).setRainDisabled());
		BiomeDictionary.registerBiomeType(RcDesert, Type.DRY);
	    BiomeManager.addSpawnBiome(RcDesert);
	    BiomeManager.addVillageBiome(RcDesert, true);
        BiomeProvider.allowedBiomes.add(RcDesert);
	}
}