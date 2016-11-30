package com.reactioncraft.core.common.craftinghandlers;

import com.reactioncraft.integration.instances.IntegratedItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.oredict.OreDictionary;

public class MachinesCraftingHandler 
{
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event)
	{
		ItemStack irondust = new ItemStack(IntegratedItems.ironShavings);
		
		if (event.crafting.getItem() != Items.IRON_AXE)
			return;
		
		if(event.crafting.getItem() == Items.IRON_AXE)
		{
			for (int i = 0; i < event.player.inventory.getSizeInventory(); i++)
			{
				ItemStack slotStack = event.player.inventory.getStackInSlot(i);
				if (slotStack != null && (slotStack.getItem() == IntegratedItems.Hammer || slotStack.getItem() == IntegratedItems.bloodstoneHammer))
				{
					event.player.dropItem(irondust, true);
				}
			}
		}
	}
}