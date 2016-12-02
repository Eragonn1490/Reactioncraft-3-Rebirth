package com.reactioncraft.desert.common;

import java.util.List;
import java.util.Random;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.bookcase.common.EnumBookshelf;
import com.reactioncraft.core.common.blocks.BlockBase;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDesertMulti extends BlockBase
{
    public static final PropertyEnum<EnumDesertBlocks> TYPE = PropertyEnum.<EnumDesertBlocks>create("type", EnumDesertBlocks.class);

    public BlockDesertMulti(String name, Material materialIn)
    {
        super(materialIn, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumDesertBlocks.one1));
        this.setCreativeTab(reactioncraft.Reactioncraft);
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return ((EnumDesertBlocks)state.getValue(TYPE)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumDesertBlocks types : EnumDesertBlocks.values())
        {
            list.add(new ItemStack(itemIn, 1, types.getMetadata()));
        }
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, EnumDesertBlocks.byMetadata(meta));
    }
    
    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumDesertBlocks)state.getValue(TYPE)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }
}