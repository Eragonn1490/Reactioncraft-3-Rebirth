package com.reactioncraft.net.common;

import java.util.List;

import com.reactioncraft.core.common.items.ItemBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;


public class ItemPieceHilt extends ItemBase
{
    public ItemPieceHilt(String string)
    {
        super(string);
        this.setCreativeTab((CreativeTabs)null);
        this.setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4)
    {
        if (itemStack.getTagCompound() != null)
        {
            list.add("Level: " + itemStack.getTagCompound().getInteger("str1"));
        }
        else
        {
            list.add("Please craft to see results");
        }

        super.addInformation(itemStack, player, list, par4);
    }
}
