package com.reactioncraft.desert.common;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;
import com.reactioncraft.core.common.items.ItemBaseChisel;

import net.minecraft.util.ResourceLocation;


public class ItemChisel1 extends ItemBaseChisel implements ItemModelProvider
{
    public ItemChisel1(String unlocalizedName)
    {
        super(unlocalizedName);
        this.setMaxStackSize(1);
        this.setMaxDamage(200);
        this.setUnlocalizedName("Chisel");
        this.setCreativeTab(reactioncraft.ReactioncraftItems);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(reactioncraft.MODID, unlocalizedName));
    }
    
    @Override
	public void registerItemModel() 
	{
		reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
	}
}