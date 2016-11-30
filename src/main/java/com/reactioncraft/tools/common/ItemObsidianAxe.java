package com.reactioncraft.tools.common;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.items.ItemBaseAxe;
import com.reactioncraft.integration.instances.IntegratedItems;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


public class ItemObsidianAxe extends ItemBaseAxe
{
    public ItemObsidianAxe(String var1, ToolMaterial var2)
    {
        super(var1, var2);
        this.setCreativeTab(reactioncraft.ReactioncraftItems);
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
    	ItemStack obsidianingot = new ItemStack(IntegratedItems.obsidianingot);
		return obsidianingot == par2ItemStack ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}