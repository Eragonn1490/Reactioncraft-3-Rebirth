package com.reactioncraft.bookcase.common;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.blocks.BlockBase;
import com.reactioncraft.desert.common.EnumDesertBlocks;
import com.reactioncraft.desert.common.EnumHireoGlyphs;
import com.reactioncraft.integration.instances.IntegratedBlocks;

import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.*;

public class BlockBookcaseMulti extends BlockBase
{
	public static final PropertyEnum<EnumBookshelf> TYPE = PropertyEnum.<EnumBookshelf>create("type", EnumBookshelf.class);

	public BlockBookcaseMulti(String name, Material materialIn)
	{
		super(materialIn, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumBookshelf.one1));
		this.setCreativeTab(reactioncraft.Reactioncraft);
	}

	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
	 * returns the metadata of the dropped item based on the old metadata of the block.
	 */
	public int damageDropped(IBlockState state)
	{
		return ((EnumBookshelf)state.getValue(TYPE)).getMetadata();
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
	{
		for (EnumBookshelf types : EnumBookshelf.values())
		{
			list.add(new ItemStack(itemIn, 1, types.getMetadata()));
		}
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumBookshelf)state.getValue(TYPE)).getMetadata();
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(TYPE, EnumBookshelf.byMetadata(meta));
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {TYPE});
	}

	//Change Meta
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		ItemStack stacktosubtract = new ItemStack(Items.BOOK);
		ItemStack stacktoadd = new ItemStack(Items.BOOK);
		
		IBlockState iblockstate2 = IntegratedBlocks.bookcases.getDefaultState().withProperty(BlockBookcaseMulti.TYPE, EnumBookshelf.one1);
		
		//Change from empty to partially filled
		if (state.getBlock() == iblockstate2)
		{
			if(playerIn.getHeldItemMainhand() == stacktosubtract)
			{
				System.out.println("changed into 1");
				worldIn.setBlockState(pos, iblockstate2);
				--stacktosubtract.stackSize;
				return true;
			}
			else 
			{
				return false;
			}
		}

		//Change from 1/3 to 2/3 filled
		//if (IntegratedBlocks.bookcases.getDefaultState().getValue(BlockBookcaseMulti.TYPE) == EnumBookshelf.two2)
		if (((IBlockState) IntegratedBlocks.bookcases.getBlockState()).getValue(BlockBookcaseMulti.TYPE) == EnumBookshelf.two2)
		{
			if(playerIn.getHeldItemMainhand() == stacktosubtract)
			{
				System.out.println("changed into 2");
				worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(TYPE, EnumBookshelf.two3));
				--stacktosubtract.stackSize;
				return true;
			}
			else 
			{
				return false;
			}
		}

		//Change from 2/3 to filled
		if (IntegratedBlocks.bookcases.getDefaultState().getValue(BlockBookcaseMulti.TYPE) == EnumBookshelf.two3)
		{
			if(heldItem.getItem() == Items.BOOK)
			{
				System.out.println("changed into 3");
				worldIn.setBlockState(pos, this.blockState.getBaseState().withProperty(TYPE, EnumBookshelf.three1));
				--stacktosubtract.stackSize;
				return true;
			}
			else 
			{
				return false;
			}
		}
		
		else
		{
			return false;
		}
	}
}