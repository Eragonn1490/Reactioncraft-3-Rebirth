package com.reactioncraft.core.common.items;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.ItemModelProvider;
import com.reactioncraft.core.common.OreDictionaryInterface;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class ItemFoodBase extends ItemFood implements ItemModelProvider, OreDictionaryInterface
{
    protected final String name;

    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood)
    {
        super(amount, saturation, isWolfFood);

        this.name = name;
        this.setRegistryName(new ResourceLocation(reactioncraft.MODID, this.name));
        this.setUnlocalizedName(reactioncraft.MODID + "." + this.name);
        this.setCreativeTab(reactioncraft.Reactioncraftfood);
    }

    @Override
    public void initOreDict(String key, Item item) 
    {
        OreDictionary.registerOre(key, item);
    }

    @Override
    public void registerItemModel() 
    {
        reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
    }
}