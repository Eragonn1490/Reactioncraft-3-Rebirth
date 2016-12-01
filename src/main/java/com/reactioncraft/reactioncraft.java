package com.reactioncraft;

//Reactioncraft Imports
import com.reactioncraft.api.*;
import com.reactioncraft.core.*;
import com.reactioncraft.core.common.*;
//import com.reactioncraft.core.Remapper;
import com.reactioncraft.core.common.biomes.*;
import com.reactioncraft.core.common.creativeTab.*;
import com.reactioncraft.core.common.tileEntities.*;
import com.reactioncraft.core.common.world.*;
import com.reactioncraft.integration.*;
//Minecraft Imports
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = reactioncraft.MODID, name = reactioncraft.name, version = reactioncraft.version, acceptedMinecraftVersions = "[1.10.2]")

public class reactioncraft
{
	public static final String name = "Reactioncraft 3: Rebirth";
    public static final String MODID = "reactioncraft";
    public static final String version = "Alpha-1.0.0";
    
    //Proxies
    @SidedProxy(serverSide = "com.reactioncraft.core.CommonProxy", clientSide = "com.reactioncraft.core.ClientProxy")
    public static CommonProxy proxy;
    
    //Instance
    @Mod.Instance(MODID)
	public static reactioncraft instance;
    
    //Creative Tabs
    public static CreativeTabs ReactioncraftItems = new RCTAB ("ReactioncraftItems");
    public static CreativeTabs Reactioncraft      = new RCTAB1("Reactioncraft");
    public static CreativeTabs Reactioncraftfood  = new RCTAB2("Reactioncraftfood");
    
    //Exclusion List for Mobs
    public static ExclusionList exclusionList;
    
    //For Wild_Card Values #updated from OreDict (Replace as it pops up)
    public static final int WILDCARD_VALUE = Short.MAX_VALUE;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        System.out.println("[REACTIONCRAFT] Pre Initialization Started");
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new CommonProxy());
        proxy.registerRenderInformation();
        IntegratedMaterials.initMaterials();
        IntegratedBlocksRegistry.init();
        IntegratedItemRegistry.init();
        ReactionBiomeManager.registerBiomes();//Methods will be updated with new version of forge
        WorldGenManager.registerOreInit();
        TileEntityRegistry.registerTileEntities();
        OreDictionaryRegistry.loadAll();//Loads Ore Dictionary Registration , needs to be update to 1.10.2
        IntegratedBlockOverrides.loadAll();
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    	IntegratedEventRegistry.eventInit();
    	RecipesManager.registerRecipes();//Needs to be fixed for 1.10.2
    }
    
    @Mod.EventHandler
    public void modsLoaded(FMLPostInitializationEvent evt)
    {
    	FMLLog.info("[REACTIONCRAFT] Has Fully Loaded!", new Object[0]);
    }
    
    @EventHandler
	public void missingMappings(FMLMissingMappingsEvent event) 
    {
		//Remapper.remap(event.get());
	}
}