package com.reactioncraft.core.common.items;

import java.util.Set;

import com.google.common.collect.Sets;
import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;

public class ItemBaseAxe extends ItemTool implements ItemModelProvider
{
	protected String name;
    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE});
    private static final float[] ATTACK_DAMAGES = new float[] {6.0F, 8.0F, 8.0F, 8.0F, 6.0F};
    private static final float[] ATTACK_SPEEDS = new float[] { -3.2F, -3.2F, -3.1F, -3.0F, -3.0F};

    protected ItemBaseAxe(String var1, Item.ToolMaterial material)
    {
        super(material, EFFECTIVE_ON);
        this.name = var1;
		this.setRegistryName(new ResourceLocation(reactioncraft.MODID, name));
        this.setUnlocalizedName(name);
        this.setCreativeTab(reactioncraft.ReactioncraftItems);
    }

    protected ItemBaseAxe(String var1, Item.ToolMaterial material, float damage, float speed)
    {
        super(speed, speed, material, EFFECTIVE_ON);
        this.damageVsEntity = damage;
        this.attackSpeed = speed;
    }

    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.WOOD && material != Material.PLANTS && material != Material.VINE ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
    }
    
    @Override
    public void registerItemModel() 
    {
        reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
    }
}