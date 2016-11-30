package com.reactioncraft.tools.common;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.items.ItemBaseSpade;
import com.reactioncraft.integration.instances.IntegratedItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemObsidianShovel extends ItemBaseSpade
{
    public ItemObsidianShovel(String var1, ToolMaterial var2)
    {
        super(var1, var2);
        this.setCreativeTab(reactioncraft.ReactioncraftItems);
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
    	 ItemStack obsidianingot = new ItemStack(IntegratedItems.obsidianingot);
         return obsidianingot == par2ItemStack ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}