package com.reactioncraft.core.common.events;

import java.util.Map;
import java.util.Random;
import com.google.common.collect.ImmutableMap;
import com.reactioncraft.integration.instances.IntegratedItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ButcherEventClass
{
    public static Random rnd = new Random();
    
    public static Map<Object, Object> dropMap = ImmutableMap.builder()
    		//Add new drops for mobs below
    		.put(EntityPig.class,     IntegratedItems.pork_chunk)
    		.put(EntityChicken.class, IntegratedItems.chicken_head)
    		.put(EntityCow.class,     IntegratedItems.beef_chunk)
    		.put(EntitySheep.class,   IntegratedItems.raw_lamb)
    		.put(EntityHorse.class,   IntegratedItems.raw_horse)
    		.put(EntityPlayer.class,  IntegratedItems.raw_human)
    		//End of adding new mob drops.
    		.build();
    
    @SubscribeEvent
    public void onEntityDrop(LivingDropsEvent event)
    {
        double rand = rnd.nextDouble();

        try
        {
        	if (event.getSource().getEntity() instanceof EntityPlayer)
            {
                ItemStack e = ((EntityLivingBase)event.getSource().getEntity()).getHeldItemMainhand();

                if (e.getItem() == IntegratedItems.meat_cleaver && rand < 1.0D)
                {
                    ItemStack drop = new ItemStack((Item)dropMap.get(event.getEntityLiving().getClass()));
                    event.getEntityLiving().entityDropItem(drop, 0.0F);
                }
            }
        }
        catch (NullPointerException var6) { ; } //This line is an empty exception dont change.
    }
}