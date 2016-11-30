package com.reactioncraft.integration;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.Generator;
import com.reactioncraft.core.common.ItemMulti;
import com.reactioncraft.core.common.blocks.*;
import com.reactioncraft.integration.instances.IntegratedBlocks;
import com.reactioncraft.machines.common.*;
import com.reactioncraft.desert.common.*;
import com.reactioncraft.bookcase.common.*;
import com.reactioncraft.ore.common.*;
import com.reactioncraft.glass.common.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IntegratedBlocksRegistry 
{
	public static void init() 
	{		
		/** Metadata Blocks **/
		//Generator.createJson("D://GitHub Repo/Reactioncraft-3/src/main/resources", reactioncraft.MODID, "hireoglyph", IntegratedBlocks.hireoglyph);
		//IntegratedBlocks.ColumnMulti    = (BlockColumnMulti)  register(new BlockColumnMulti("columnReg",   Material.ROCK)).setHardness(3.0F);
		//IntegratedBlocks.ColumnMulti2  = (BlockColumnMulti2) register(new BlockColumnMulti2("ColumnMini", Material.ROCK)).setHardness(3.0F);
		//Turn Desert Plants Into Metadata Blocks ^^

		//Sand Blocks
		IntegratedBlocks.DarkSand     = (BlockBaseSand) register(new BlockBaseSand(Material.SAND, "sands")).setCreativeTab(reactioncraft.Reactioncraft);
		
		//Desert Blocks
		IntegratedBlocks.DesertBlocks     = (BlockDesertMulti) register(new BlockDesertMulti("desertblocks", Material.ROCK)).setHardness(0.3F);
		IntegratedBlocks.hireoglyph     = (BlockHireoMulti) register(new BlockHireoMulti(Material.ROCK, "hireoglyph")).setHardness(0.3F);
		
		//Bookshelf Blocks
		IntegratedBlocks.bookcases = (BlockBookcaseMulti) register(new BlockBookcaseMulti("bookcases", Material.WOOD)).setHardness(3.0F);
		
		//Glass Blocks
		IntegratedBlocks.GlowingGlass = (BlockGlowingGlassMulti) register(new BlockGlowingGlassMulti(Material.GLASS, true, "glowingglass")).setLightLevel(1).setHardness(0.0F);
		
		//Ore Blocks
		IntegratedBlocks.surfaceOres = (BlockSOMulti) register(new BlockSOMulti("surfaceOres", Material.ROCK)).setHardness(3.0F);
		IntegratedBlocks.netherOres  = (BlockNOMulti) register(new BlockNOMulti("netherOres" , Material.ROCK)).setHardness(3.0F);
		IntegratedBlocks.endOres     = (BlockEOMulti) register(new BlockEOMulti("endOres"    , Material.ROCK)).setHardness(3.0F);
		
		//Wooden Blocks
		IntegratedBlocks.CherryPlanks = register(new BlockBase(Material.WOOD, "CherryPlanks").setCreativeTab(reactioncraft.Reactioncraft));
	
		//Wall Blocks
		
		/** Regular Blocks **/
		//Brick Blocks
		IntegratedBlocks.bloodstonebricks = register(new BlockBase(Material.ROCK, "bloodstonebricks").setCreativeTab(reactioncraft.Reactioncraft));
		
		//Doors
		IntegratedBlocks.WoodenBookcasedoorBlockBase = (BlockBaseDoor) register(new BlockBaseDoor("doorWbookcase", Material.WOOD)).setHardness(3.0F);
		IntegratedBlocks.IronBookcasedoorBlockBase   = (BlockBaseDoor) register(new BlockBaseDoor("doorIbookcase", Material.IRON)).setHardness(3.0F);
		IntegratedBlocks.cherrydoorBlockBase         = (BlockBaseDoor) register(new BlockBaseDoor("cherry_door",   Material.WOOD)).setHardness(3.0F);
		
		/** Special Regular Blocks **/
		//Machine Blocks
		//IntegratedBlocks.FreezerIdle = (BlockFreezer)         (new BlockFreezer("freezerIdle",      false))  .setHardness(3.5F).setUnlocalizedName("FreezerIdle").setCreativeTab(reactioncraft.Reactioncraft);
        //IntegratedBlocks.FreezerActive = (BlockFreezer)       (new BlockFreezer("freezerActive",     true))  .setHardness(3.5F).setLightLevel(0.875F).setUnlocalizedName("FreezerActive");
        //IntegratedBlocks.BrickOvenIdle = (BlockBrickOven)     (new BlockBrickOven("BrickOvenIdle",  false))  .setHardness(3.5F).setUnlocalizedName("BrickOvenIdle").setCreativeTab(reactioncraft.Reactioncraft);
        //IntegratedBlocks.BrickOvenActive = (BlockBrickOven)   (new BlockBrickOven("BrickOvenActive", true))  .setHardness(3.5F).setLightLevel(0.875F).setUnlocalizedName("BrickOvenActive");
        //IntegratedBlocks.ClayalizerIdle = (BlockClayalizer)   (new BlockClayalizer(false)).setHardness(3.5F).setUnlocalizedName("ClayalizerIdle").setCreativeTab(reactioncraft.Reactioncraft);
        //IntegratedBlocks.ClayalizerActive = (BlockClayalizer) (new BlockClayalizer(true)) .setHardness(3.5F).setLightLevel(0.875F).setUnlocalizedName("ClayalizerActive");
	}
	
	private static <T extends Block> T register(T block, ItemBlock itemBlock)
	{
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);

		if (block instanceof BlockBase) {
			((BlockBase)block).registerItemModel(itemBlock);
		}
		if (block instanceof BlockHireoMulti) {
			((BlockHireoMulti)block).registerItemModel(itemBlock);
		}
		if (block instanceof BlockColumnMulti) {
			((BlockColumnMulti)block).registerItemModel(itemBlock);
		}
		
		if (block instanceof BlockBaseSand) {
			((BlockBaseSand)block).registerItemModel(itemBlock);
		}
		
		if (block instanceof BlockBookcaseMulti) {
			((BlockBookcaseMulti)block).registerItemModel(itemBlock);
		}
		
		if (block instanceof BlockGlowingGlassMulti) {
			((BlockGlowingGlassMulti)block).registerItemModel(itemBlock);
		}
		
		if (block instanceof BlockDesertMulti) {
			((BlockDesertMulti)block).registerItemModel(itemBlock);
		}
		
		if (block instanceof BlockBaseDoor) {
			((BlockBaseDoor)block).registerItemModel(itemBlock);
		}
		
		return block;
	}

	private static <T extends Block> T register(T block) 
	{
		if (block instanceof BlockHireoMulti || block instanceof BlockBaseDoor || block instanceof BlockColumnMulti || block instanceof BlockSOMulti 
		 || block instanceof BlockEOMulti    || block instanceof BlockNOMulti     || block instanceof BlockBaseSand
		 || block instanceof BlockGlowingGlassMulti || block instanceof BlockBookcaseMulti || block instanceof BlockDesertMulti) { 
			ItemMulti itemBlock = new ItemMulti(block);
			itemBlock.setRegistryName(block.getRegistryName());
			return register(block, itemBlock);
		}
		else
		{
			ItemBlock itemBlock = new ItemBlock(block);
			itemBlock.setRegistryName(block.getRegistryName());
			return register(block, itemBlock);
		}
	}
}