package com.reactioncraft.core.common.blocks;

import java.util.*;
import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.blocks.BlockBase;
import com.reactioncraft.desert.common.EnumSands;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.*;

public class BlockBaseSand extends BlockFalling
{
    public static final PropertyEnum<EnumSands> TYPE = PropertyEnum.<EnumSands>create("type", EnumSands.class);
    protected String name;
    
    public BlockBaseSand(Material materialIn, String name)
    {
        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumSands.one1));
        setUnlocalizedName(name);
		setRegistryName(name);
        this.setCreativeTab(reactioncraft.Reactioncraft);
    }
    
    public void registerItemModel(ItemBlock itemBlock) 
	{
		reactioncraft.proxy.registerItemRenderer(itemBlock, 0, name);
	}
    
    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return ((EnumSands)state.getValue(TYPE)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumSands types : EnumSands.values())
        {
            list.add(new ItemStack(itemIn, 1, types.getMetadata()));
        }
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, EnumSands.byMetadata(meta));
    }

    /*
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumSands)state.getValue(TYPE)).getMetadata();
    }
    
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE});
    }
}