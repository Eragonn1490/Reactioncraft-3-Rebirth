package com.reactioncraft.core.common.items;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemBaseSword extends ItemSword implements ItemModelProvider
{
	protected String name;
	public ItemBaseSword(String unlocalizedName, ToolMaterial material)
	{
        super(material);
        this.name = unlocalizedName;
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(new ResourceLocation(reactioncraft.MODID, unlocalizedName));
	}
	
	@Override
	public Set<String> getToolClasses(ItemStack stack) 
	{
		return ImmutableSet.of("sword");
	}
	
	@Override
    public void registerItemModel() 
    {
        reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
    }
}