package com.reactioncraft.core.common.items;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;

import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;

public class ItemBaseChisel extends ItemSword implements ItemModelProvider
{
	protected String name;
	
    public ItemBaseChisel(String name)
    {
        super(ToolMaterial.WOOD);
        this.name = name;
        this.setMaxStackSize(1);
        this.setMaxDamage(10);
        this.setCreativeTab(reactioncraft.ReactioncraftItems);
        this.setNoRepair();
    }

    /**
     * Returns true if players can use this item to affect the world (e.g. placing blocks, placing ender eyes in portal)
     * when not in creative
     */
    public boolean canItemEditBlocks()
    {
        return false;
    }

    @Override
    public void registerItemModel() 
    {
        reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
    }
}