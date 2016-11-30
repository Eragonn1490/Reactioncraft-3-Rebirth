package com.reactioncraft.core;

import java.util.ArrayList;
import java.util.List;
import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.*;
import com.reactioncraft.core.common.tileEntities.*;
import com.reactioncraft.desert.common.*;
import com.reactioncraft.integration.instances.IntegratedBlocks;
import com.reactioncraft.machines.common.GuiFreezer;
import com.reactioncraft.mobs.common.models.*;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
    public static String BORE_TEXTURE = "/mods/reactioncraft/textures/railcraft/";

    @Override
    public void registerItemRenderer(Item item, int meta, String id) 
    {
    	if (item instanceof ItemMulti) 
    	{
    		this.registerItemBlockRenderer(item, meta, id);
		}
    	else
    	{
    		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(reactioncraft.MODID + ":" + id, "inventory"));
    	}
    }
    
    public void registerItemBlockRenderer(Item item, int meta, String id) 
    {
    	ModelResourceLocation mrl;
    	ModelLoader.setCustomModelResourceLocation(item, 0,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=one1"));   // meta 0
    	ModelLoader.setCustomModelResourceLocation(item, 1,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=one2"));   // meta 1
    	ModelLoader.setCustomModelResourceLocation(item, 2,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=one3"));   // meta 2
    	ModelLoader.setCustomModelResourceLocation(item, 3,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=two1"));   // meta 3
    	ModelLoader.setCustomModelResourceLocation(item, 4,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=two2"));   // meta 4
    	ModelLoader.setCustomModelResourceLocation(item, 5,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=two3"));   // meta 5
    	ModelLoader.setCustomModelResourceLocation(item, 6,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=three1")); // meta 6
    	ModelLoader.setCustomModelResourceLocation(item, 7,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=three2")); // meta 7
    	ModelLoader.setCustomModelResourceLocation(item, 8,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=three3")); // meta 8
    	ModelLoader.setCustomModelResourceLocation(item, 9,  mrl = new ModelResourceLocation(item.getRegistryName(), "type=four1"));  // meta 9
    	ModelLoader.setCustomModelResourceLocation(item, 10, mrl = new ModelResourceLocation(item.getRegistryName(), "type=four2"));  // meta 10
    	ModelLoader.setCustomModelResourceLocation(item, 11, mrl = new ModelResourceLocation(item.getRegistryName(), "type=four3"));  // meta 11
    	ModelLoader.setCustomModelResourceLocation(item, 12, mrl = new ModelResourceLocation(item.getRegistryName(), "type=five1"));  // meta 12
    	ModelLoader.setCustomModelResourceLocation(item, 13, mrl = new ModelResourceLocation(item.getRegistryName(), "type=five2"));  // meta 13
    	ModelLoader.setCustomModelResourceLocation(item, 14, mrl = new ModelResourceLocation(item.getRegistryName(), "type=five3"));  // meta 14
    	ModelLoader.setCustomModelResourceLocation(item, 15, mrl = new ModelResourceLocation(item.getRegistryName(), "type=six1" ));  // meta 15
    }


	@Override
    public void registerRenderInformation()
    {
		//EntityRegistry.registerEgg(EntityJellyfish.class, primary, secondary);
        //RenderingRegistry.registerEntityRenderingHandler(EntityBee.class, new RenderBee(new ModelBee(0.2F), 0.2F, 0.2F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, new RenderJellyfish(new ModelJellyfish(), 0.5F));
        //RenderingRegistry.registerEntityRenderingHandler(EntitySeaCreeper.class, new RenderSeaCreeper(new ModelSeaCreeper(), 0.5F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityStalker.class, new RenderStalker(new ModelCreeper(), 0.5F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityZombieCrawling.class, new RenderZombieCrawling(new ModelZombieCrawling(), 0.5F));
        //RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonCrawling.class, new RenderSkeletonCrawling(new ModelZombieCrawling(), 0.5F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityHydrolisc.class, new RenderHydrolisc(new ModelHydrolisc(0.65F), 0.65F, 0.65F));
        //RenderingRegistry.registerEntityRenderingHandler(EntityTJ.class, new RenderTJ(new ModelTJ(0.2F), 0.2F, 0.2F));
    }

    public int addArmor(String armorName)
    {
    	//when i get to armor uncomment and delete extra line of return 0;
        //return RenderingRegistry.addNewArmourRendererPrefix("Emerald");
        return 0;
    }
}