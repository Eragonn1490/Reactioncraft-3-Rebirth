package com.reactioncraft.core.common.items;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;

import net.minecraft.item.ItemHoe;
import net.minecraft.util.ResourceLocation;

public class ItemBasicHoe extends ItemHoe implements ItemModelProvider
{
	protected String name;
    public ItemBasicHoe(String var1, ToolMaterial var2)
    {
        super(var2);
        this.name = var1;
		this.setRegistryName(new ResourceLocation(reactioncraft.MODID, name));
        this.setUnlocalizedName(name);
        this.setCreativeTab(reactioncraft.ReactioncraftItems);
    }
    
    @Override
    public void registerItemModel() 
    {
        reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
    }
}