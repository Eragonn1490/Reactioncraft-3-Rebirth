package com.reactioncraft.tools.common;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.items.ItemBasicHoe;
import com.reactioncraft.integration.instances.IntegratedItems;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemBloodstoneHoe extends ItemBasicHoe
{
    public ItemBloodstoneHoe(String var1, ToolMaterial var2)
    {
        super(var1, var2);
        this.setCreativeTab(reactioncraft.ReactioncraftItems);
    }

    @Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		ItemStack ingotbloodstone = new ItemStack(IntegratedItems.ingotbloodstone);
		return ingotbloodstone == par2ItemStack ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}