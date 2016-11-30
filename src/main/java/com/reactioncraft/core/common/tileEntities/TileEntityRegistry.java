package com.reactioncraft.core.common.tileEntities;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityRegistry 
{

	public static void registerTileEntities()
	{
		//GameRegistry.registerTileEntity(TileEntityBookcaseChest.class, "Bookcasechest");
        GameRegistry.registerTileEntity(TileEntityFreezer.class,    "Reactioncraft-Freezer");
        GameRegistry.registerTileEntity(TileEntityBrickOven.class,  "Reactioncraft-BrickOven");
        GameRegistry.registerTileEntity(TileEntityClayalizer.class, "Reactioncraft-Clayalizer");
	}
}