package com.reactioncraft.desert.common;

import java.util.List;
import java.util.Random;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.blocks.BlockBase;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.*;

public class BlockColumnMulti extends BlockBase
{
    public static final PropertyEnum<EnumColumn> TYPE = PropertyEnum.<EnumColumn>create("type", EnumColumn.class);

    public BlockColumnMulti(String name, Material materialIn)
    {
        super(materialIn, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumColumn.one1));
        this.setCreativeTab(reactioncraft.Reactioncraft);
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return ((EnumColumn)state.getValue(TYPE)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumColumn types : EnumColumn.values())
        {
            list.add(new ItemStack(itemIn, 1, types.getMetadata()));
        }
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumColumn)state.getValue(TYPE)).getMetadata();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }
}