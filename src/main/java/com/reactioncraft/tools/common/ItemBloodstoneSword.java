package com.reactioncraft.tools.common;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.items.ItemBasicSword;
import com.reactioncraft.integration.instances.IntegratedItems;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


public class ItemBloodstoneSword extends ItemBasicSword
{
    public ItemBloodstoneSword(String var1, ToolMaterial var2)
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
		ItemStack ingotbloodstone = new ItemStack(IntegratedItems.ingotbloodstone);
		return ingotbloodstone == par2ItemStack ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}