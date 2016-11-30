package com.reactioncraft.core.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemMulti extends ItemBlock
{
    public ItemMulti(Block par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }

    /**
     * Returns the unlocalized of this item. This version accepts an ItemStack so different stacks can have
     * differents based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        String[] types = new String[] {"Block", "Block1", "Block2", "Block3", "Block4", "Block5", "Block6", "Block7", "Block8", "Block9", "Block10", "Block11", "Block12", "Block13", "Block14", "Block15"};
        return super.getUnlocalizedName() + "." + types[par1ItemStack.getItemDamage()];
    }
}
