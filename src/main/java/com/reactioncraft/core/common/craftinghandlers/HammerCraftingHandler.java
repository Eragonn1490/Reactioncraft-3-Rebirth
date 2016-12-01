package com.reactioncraft.core.common.craftinghandlers;

import java.util.Random;
import com.reactioncraft.integration.instances.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.*;
import net.minecraftforge.oredict.*;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

/**
 * @author Ordinastie && Eragonn1490
 *
 */
public class HammerCraftingHandler
{
	Random random = new Random();
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event)
	{
		if (event.crafting.getItem() != Items.IRON_AXE)
			return;
		
		for (int i = 0; i < event.player.inventory.getSizeInventory(); i++)
		{
			ItemStack slotStack = event.player.inventory.getStackInSlot(i);

			if (slotStack != null && (slotStack.getItem() == IntegratedItems.Hammer || slotStack.getItem() == IntegratedItems.bloodstoneHammer))
			{
				slotStack.damageItem(1, event.player);
				
				if (slotStack.getItemDamage() == slotStack.getMaxDamage()) 
				{
					System.out.println("Deleted Item");
					event.player.inventory.setInventorySlotContents(i, null);
				}
			}
		}
	}
}