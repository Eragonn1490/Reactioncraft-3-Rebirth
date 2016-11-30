package com.reactioncraft.core.common.world;

import com.reactioncraft.ore.common.world.*;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenManager 
{

	public static void registerOreInit() 
	{
		GameRegistry.registerWorldGenerator(new worldgen(), 3);
	}	
}