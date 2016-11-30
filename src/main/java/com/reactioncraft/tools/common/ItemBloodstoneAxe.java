package com.reactioncraft.tools.common;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.items.ItemBaseAxe;
import com.reactioncraft.integration.*;
import com.reactioncraft.integration.instances.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;


public class ItemBloodstoneAxe extends ItemBaseAxe
{
	public ItemBloodstoneAxe(String var1, ToolMaterial var2)
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

	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state)
	{
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
	}
}