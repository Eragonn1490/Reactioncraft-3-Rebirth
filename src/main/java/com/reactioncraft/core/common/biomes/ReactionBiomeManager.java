package com.reactioncraft.core.common.biomes;


import java.util.ArrayList;
import java.util.Arrays;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.desert.common.BiomeGenReactionDesert;

import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.IForgeRegistry;

public class ReactionBiomeManager 
{	
	public static final BiomeGenReactionDesert ReactionDesert_BIOME = new BiomeGenReactionDesert(new Biome.BiomeProperties("Reaction Desert")
			.setBaseHeight(0.125F)
			.setHeightVariation(0.05F)
			.setTemperature(2.0F)
			.setRainfall(0.0F)
			.setRainDisabled()
			);

	public static void registerBiomes()
	{
		ReactionDesert_BIOME.setRegistryName("ReactionDesert_BIOME");
		GameRegistry.register(ReactionDesert_BIOME);
		
		BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(ReactionDesert_BIOME, 1000));
		
		BiomeManager.addSpawnBiome(ReactionDesert_BIOME);
		BiomeDictionary.registerBiomeType(ReactionDesert_BIOME, Type.DRY);
	    BiomeManager.addVillageBiome(ReactionDesert_BIOME, true);	    
	}
}