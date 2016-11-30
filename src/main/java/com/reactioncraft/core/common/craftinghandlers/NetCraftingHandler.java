package com.reactioncraft.core.common.craftinghandlers;

import com.reactioncraft.integration.instances.IntegratedItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NetCraftingHandler 
{
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event)
	{
		if (event.crafting.getItem().equals(IntegratedItems.complete_net))
		{
			event.crafting.setTagCompound(new NBTTagCompound());
			ItemStack hilt = null;
			ItemStack net = null;

			for (int i = 0; i < event.craftMatrix.getSizeInventory(); ++i)
			{
				ItemStack is = event.craftMatrix.getStackInSlot(i);

				if (is != null)
				{
					if (is.getItem() == IntegratedItems.hilt)
					{
						hilt = is;
					}
					else
					{
						net = is;
					}
				}
			}

			if (hilt != null && net != null)
			{
				event.crafting.getTagCompound().setInteger("hilt", hilt.getTagCompound().getInteger("str1"));
				event.crafting.getTagCompound().setInteger("net",  net.getTagCompound() .getInteger("str2"));
			}
		}
	}
}