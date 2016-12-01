package com.reactioncraft.core.common.items;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.ItemModelProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemBase extends Item implements ItemModelProvider
{
	protected String name;

	public ItemBase(String name) 
	{
		this.name = name;
		this.setRegistryName(new ResourceLocation(reactioncraft.MODID, this.name));
		this.setUnlocalizedName(reactioncraft.MODID + "." + this.name);
		this.setCreativeTab(reactioncraft.ReactioncraftItems);
	}

	@Override
	public void registerItemModel() 
	{
		reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
	}

	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) 
	{
		super.setCreativeTab(tab);
		return this;
	}
}