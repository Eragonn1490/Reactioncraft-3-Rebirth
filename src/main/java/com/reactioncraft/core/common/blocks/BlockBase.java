package com.reactioncraft.core.common.blocks;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.integration.instances.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;

public class BlockBase extends Block 
{

	protected String name;

	public BlockBase(Material material, String name) 
	{
		super(material);

		this.name = name;

		setUnlocalizedName(name);
		setRegistryName(name);
	}

	public void registerItemModel(ItemBlock itemBlock) 
	{
		reactioncraft.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	/**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return true;
    }
	
	@Override
	public BlockBase setCreativeTab(CreativeTabs tab) 
	{
		super.setCreativeTab(tab);
		return this;
	}
}