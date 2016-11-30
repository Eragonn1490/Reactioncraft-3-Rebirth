package com.reactioncraft.integration;

import com.reactioncraft.integration.instances.IntegratedBlocks;
import com.reactioncraft.integration.instances.IntegratedItems;

import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class IntegratedRecipesRegistry
{
	public static void netrecipyInit() 
	{
		//Below is the crafting Recipe's for making the multi-Level / extra use Nets.
		Object[] levels = new Object[] {Blocks.PLANKS, Items.LEATHER, Items.IRON_INGOT, Items.GOLD_INGOT, Items.DIAMOND};

		for (int i = 0; i < levels.length; ++i)
		{
			Object[] hiltRec = new Object[] {" XI", "XIX", "IX ", 'X', Items.STICK, 'I', levels[i]};
			Object[] netRec = new Object[] {"IXI", "XIX", "IXI", 'X', Items.STRING, 'I', levels[i]};
			ItemStack hiltIs = new ItemStack(IntegratedItems.hilt);
			ItemStack netIs = new ItemStack(IntegratedItems.net);

			hiltIs.setTagCompound(new NBTTagCompound());
			netIs.setTagCompound(new NBTTagCompound());

			hiltIs.getTagCompound().setInteger("str1", i + 1);
			netIs.getTagCompound() .setInteger("str2", i + 1);
			GameRegistry.addRecipe(hiltIs, hiltRec);
			GameRegistry.addRecipe(netIs, netRec);
		}
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.complete_net), new Object[] {IntegratedItems.hilt, IntegratedItems.net});
	}
	
	public static void mobsRecipesInit()
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(Items.DYE, 2, 15), new Object[] {Boolean.valueOf(true), new Object[]{"Y", 'Y', "bones"}}));
	}
	
	public static void loadRecipesforVanilla()
	{
		GameRegistry.addSmelting(IntegratedItems.IceBucket, new ItemStack(Items.WATER_BUCKET, 1), 0.5F);
	}
	
	
	//Not Fixed Below

	public static void machinerecipiesInit() 
	{
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.BrickOvenIdle, 1), new Object[] {"XXX", "X X", "XXX", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.ClayalizerIdle, 1), new Object[] {"XXX", "XGX", "XXX", 'G', Blocks.GLASS, 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.FreezerIdle, 1), new Object[] {"RSR", "LOW", "RSR", 'W', Items.WATER_BUCKET, 'L', Blocks.LEVER, 'S', Blocks.IRON_BLOCK, 'O', Blocks.FURNACE, 'R', Items.REDSTONE});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.ICE, 1), new Object[] {IntegratedItems.IceBucket});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.OBSIDIAN, 1), new Object[] {IntegratedItems.ObsidianBucket});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.irondust, 1), new Object[] {IntegratedItems.ironShavings, IntegratedItems.ironShavings, IntegratedItems.ironShavings, IntegratedItems.ironShavings});
	}

	public static void glassRecipesInit()
	{
		GameRegistry.addSmelting(Blocks.GLASS, new ItemStack(IntegratedItems.moltenglass, 1, 0), 0.5F);
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 2), new Object[]  {"dyeBlack", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 1), new Object[]  {"dyeRed", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 7), new Object[]  {"dyeGreen", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 4), new Object[]  {"dyeBrown", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 3), new Object[]  {"dyeBlue", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 14), new Object[] {"dyePurple", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 5), new Object[]  {"dyeCyan", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 9), new Object[]  {"dyeLightGray", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 6), new Object[]  {"dyeGray", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 13), new Object[] {"dyePink", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 10), new Object[] {"dyeLime", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 0), new Object[]  {"dyeYellow", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 8), new Object[]  {"dyeLightBlue", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 11), new Object[] {"dyeMagenta", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 12), new Object[] {"dyeOrange", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.GlowingGlass, 1, 15), new Object[] {"dyeWhite", IntegratedItems.moltenglass, Items.GLOWSTONE_DUST}));
	}
	
	public static void loadWeapons()
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.BloodstoneHoe, new Object[] {Boolean.valueOf(true), new Object[]{"III", "IXI", " I ", 'I', "plankWood", 'X', Items.STICK}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.ObbySword, new Object[] {Boolean.valueOf(true), new Object[]{"I", "I", "X", 'I', "ingotObsidian", 'X', "goldRod"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.ObbyPick, new Object[] {Boolean.valueOf(true), new Object[]{"III", " X ", " X ", 'I', "ingotObsidian", 'X', "goldRod"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.ObbyShovel, new Object[] {Boolean.valueOf(true), new Object[]{"I", "X", "X", 'I', "ingotObsidian", 'X', "goldRod"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.ObbyAxe, new Object[] {Boolean.valueOf(true), new Object[]{"II ", "IX ", " X ", 'I', "ingotObsidian", 'X', "goldRod"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.ObbyHoe, new Object[] {Boolean.valueOf(true), new Object[]{"II ", " X ", " X ", 'I', "ingotObsidian", 'X', "goldRod"}}));
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.BloodstoneSword, 1), new Object[] {"B", "F", 'B', IntegratedItems.BloodstoneBlade, 'F', IntegratedItems.GoldenSwordFragment});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.BloodstoneBlade, new Object[] {Boolean.valueOf(true), new Object[]{"X", "X", "X", 'X', "ingotBloodstone"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.GoldenSwordFragment, new Object[] {Boolean.valueOf(true), new Object[]{" I ", "XIX", " X ", 'I', "gemDragonstone", 'X', "goldRod"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.BloodstonePick, new Object[] {Boolean.valueOf(true), new Object[]{"III", " X ", " X ", 'I', "ingotBloodstone", 'X', "goldRod"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.BloodstoneDiamondPick, new Object[] {Boolean.valueOf(true), new Object[]{"IBI", " X ", " X ", 'I', "ingotBloodstone", 'X', "goldRod", 'B', "diamondBlack"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.BloodstoneShovel, new Object[] {Boolean.valueOf(true), new Object[]{" I ", " X ", " X ", 'I', "ingotBloodstone", 'X', "goldRod"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.BloodstoneAxe, new Object[] {Boolean.valueOf(true), new Object[]{"II ", "IX ", " X ", 'I', "ingotBloodstone", 'X', "goldRod"}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.BloodstoneHoe, new Object[] {Boolean.valueOf(true), new Object[]{"II ", " X ", " X ", 'I', "ingotBloodstone", 'X', "goldRod"}}));
	}

	public static void loadPlants()
	{
		GameRegistry.addRecipe(new ItemStack(Items.PAPER, 3), new Object[] {"###", '#', IntegratedItems.sugarcaneItemBase});
		GameRegistry.addRecipe(new ItemStack(Items.SUGAR, 1), new Object[] {"#", '#', IntegratedItems.sugarcaneItemBase});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.sugarcaneItemBase, 2), new Object[] {IntegratedItems.AncientFlower, Items.REEDS});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.AncientSeeds, 1), new Object[] {IntegratedItems.AncientFlower});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.AncientSeeds, 2), new Object[] {IntegratedItems.AncientFruit});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.CornSeed, 2), new Object[] {IntegratedItems.rawcorn});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.rawcorn, 1), new Object[] {IntegratedItems.Wrappedcorn});
	}

	public static void loadFood()
	{
		GameRegistry.addSmelting(IntegratedItems.salmonRaw, new ItemStack(IntegratedItems.salmon), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.YellowTailRaw, new ItemStack(IntegratedItems.YellowTailCooked), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.raw_bacon, new ItemStack(IntegratedItems.Bacon), 0.5F);
		//GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(IntegratedItems.EdibleFlesh), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.RawNuggets, new ItemStack(IntegratedItems.ChickenNuggets), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.bagofpopcorn, new ItemStack(IntegratedItems.poppedbagofpopcorn), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.rawcorn, new ItemStack(IntegratedItems.cookedCorn), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.raw_lamb, new ItemStack(IntegratedItems.cooked_lamb), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.raw_human, new ItemStack(IntegratedItems.cooked_human), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.raw_horse, new ItemStack(IntegratedItems.cooked_horse), 0.5F);
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.popcornseeds, 5), new Object[] {IntegratedItems.rawcorn});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.bagofpopcorn, 1), new Object[] {"AAA", "BBB", "AAA", 'A', Items.PAPER, 'B', IntegratedItems.popcornseeds});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.RawNuggets, 5), new Object[] {Items.CHICKEN, new ItemStack(IntegratedItems.Knife, 1, 32767)});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.SlicedBread, 6), new Object[] {Items.BREAD, new ItemStack(IntegratedItems.Knife, 1, 32767)});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.cheese, 6), new Object[] {Items.MILK_BUCKET, new ItemStack(IntegratedItems.churn, 1, 32767)});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.buns, 2), new Object[] {Items.BREAD, Items.BREAD, new ItemStack(IntegratedItems.Knife, 1, 32767)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.HamSandwich, 1), new Object[] {"A", "B", "A", 'A', IntegratedItems.SlicedBread, 'B', Items.PORKCHOP});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Hamburger, 1), new Object[] {"A", "B", "A", 'A', IntegratedItems.buns, 'B', Items.BEEF});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.Cheeseburger, new Object[] {Boolean.valueOf(true), new Object[]{" A ", " BC", " A ", 'C', "cheese", 'A', IntegratedItems.buns, 'B', Items.COOKED_BEEF}}));
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.churn, 1), new Object[] {"A", "B", 'A', Items.STICK, 'B', Items.BOWL});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Knife, 1), new Object[] {"B", "A", 'A', Items.STICK, 'B', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.meat_cleaver, 1), new Object[] {"BB ", "BB ", "A  ", 'A', Items.STICK, 'B', Items.IRON_INGOT});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.Bacon, 4), new Object[] {Items.PORKCHOP, new ItemStack(IntegratedItems.Knife, 1, 32767)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.PORKCHOP, 2), new Object[] {IntegratedItems.pork_chunk, new ItemStack(IntegratedItems.Knife, 1, 32767)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.BEEF, 2), new Object[] {IntegratedItems.beef_chunk, new ItemStack(IntegratedItems.Knife, 1, 32767)});
	}

	public static void loadDesertRecipes()
	{
		//FurnaceRecipes.smelting().addSmelting(IntegratedBlocks.DesertBlocks.blockID, 10, new ItemStack(Item.ingotGold.itemID, 1, 0), 0.5F);
		//FurnaceRecipes.smelting().addSmelting(IntegratedBlocks.Cherrywood.blockID, 0, new ItemStack(Item.coal, 1, 1), 0.15F);
		//FurnaceRecipes.smelting().addSmelting(IntegratedBlocks.Cactus1.blockID, 0, new ItemStack(Item.dyePowder, 1, 2), 0.15F);
		//FurnaceRecipes.smelting().addSmelting(IntegratedBlocks.Cactus2.blockID, 0, new ItemStack(Item.dyePowder, 1, 2), 0.15F);
		//FurnaceRecipes.smelting().addSmelting(IntegratedBlocks.DesertBlocks.blockID, 1, new ItemStack(IntegratedBlocks.DesertBlocks, 1, 2), 0.1F);
		//FurnaceRecipes.smelting().addSmelting(IntegratedBlocks.DesertBlocks.blockID, 10, new ItemStack(Item.ingotGold.itemID, 1, 0), 0.5F);
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.CherryPlanks, 4, 0), new Object[] {"CherryWood"}));
		GameRegistry.addSmelting(IntegratedBlocks.Cherrywood, new ItemStack(Items.COAL, 1, 1), 0.5F);
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.FlintChisel, 1), new Object[] {"G", "I", 'G', Items.FLINT, 'I', Items.STICK});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.CopperChisel, new Object[] {Boolean.valueOf(true), new Object[]{"I", "X", 'I', "ingotCopper", 'X', Items.STICK}}));
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.GoldChisel, 1), new Object[] {"G", "I", 'G', Items.GOLD_INGOT, 'I', Items.STICK});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.DiamondChisel, 1), new Object[] {"G", "I", 'G', Items.DIAMOND, 'I', Items.STICK});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(IntegratedItems.BloodstoneChisel, new Object[] {Boolean.valueOf(true), new Object[]{"I", "X", 'I', "ingotBloodstone", 'X', Items.STICK}}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 1, 2), new Object[] {"darkclay", "darkclay", "darkclay", "darkclay"}));
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 1, 3), new Object[] {"XX", "XX", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0)});
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.bloodstonebricks, 4, 0), new Object[] {"oreBloodstone", "oreBloodstone", "oreBloodstone", "oreBloodstone"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), new Object[] {new ItemStack(IntegratedBlocks.hireoglyph, 1, 11), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 1, 3), new Object[] {new ItemStack(IntegratedBlocks.DesertBlocks, 1, 4), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 1, 7), new Object[] {new ItemStack(IntegratedBlocks.DesertBlocks, 1, 6), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), new Object[] {new ItemStack(IntegratedBlocks.DesertBlocks, 1, 2), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), new Object[] {new ItemStack(IntegratedBlocks.DesertBlocks, 1, 1), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 9), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 0), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 3), 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 3), new Object[] {"X  ", "XY ", "X  ", 'X', Blocks.STONE, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 4), new Object[] {"X  ", "XY ", "X  ", 'X', Blocks.COBBLESTONE, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 7), new Object[] {"X  ", "XY ", "X  ", 'X', Blocks.STONEBRICK, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 8), new Object[] {"X  ", "XY ", "X  ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 7), 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 5), new Object[] {"X  ", "XY ", "X  ", 'X', Blocks.GOLD_BLOCK, 'Y', "chisel1"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 6), new Object[] {"X  ", "XY ", "X  ", 'X', Blocks.DIAMOND_BLOCK, 'Y', "chisel2"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti, 1, 2), new Object[] {"X  ", "XY ", "X  ", 'X', IntegratedBlocks.bloodstonebricks, 'Y', "chisel2"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 9), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 9), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 0), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 0), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 3), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 3), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 4), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 4), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 5), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 5), "chisel1"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 6), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 6), "chisel2"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 7), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 7), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 8), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 8), "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedBlocks.ColumnMulti2, 1, 2), new Object[] {new ItemStack(IntegratedBlocks.ColumnMulti, 1, 2), "chisel2"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 0), new Object[] {"YYY", " X ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 1), new Object[] {"YYY", "YX ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 2), new Object[] {"YYY", "YXY", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 3), new Object[] {"YYY", " X ", " @ ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', IntegratedItems.CutLBGem, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 4), new Object[] {"YYY", "YX ", "Y@ ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', IntegratedItems.CutLBGem, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 5), new Object[] {"YYY", "YXY", "Y@Y", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', IntegratedItems.CutLBGem, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 6), new Object[] {"YYY", " X ", " @ ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', IntegratedItems.CutDBGem, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 7), new Object[] {"YYY", "YX ", "Y@ ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', IntegratedItems.CutDBGem, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 8), new Object[] {"YYY", "YXY", "Y@Y", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', IntegratedItems.CutDBGem, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 13), new Object[] {"YYY", " X ", " @ ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', Items.GOLD_INGOT, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 14), new Object[] {"YYY", "YX ", "Y@ ", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', Items.GOLD_INGOT, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedBlocks.hireoglyph, 1, 15), new Object[] {"YYY", "YXY", "Y@Y", 'X', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), '@', Items.GOLD_INGOT, 'Y', "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedItems.CutLBGem, 1, 0), new Object[] {IntegratedItems.UncutLBGem, "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedItems.CutDBGem, 1, 0), new Object[] {IntegratedItems.UncutDBGem, "chisel"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedItems.gemdragonstone, 1, 0), new Object[] {new ItemStack(IntegratedItems.dragonstoneshard, 1, 0), "chisel"}));
	}

	public static void loadORES()
	{
		//FurnaceRecipes.addSmelting(IntegratedBlocks.endOres.blockID, 1, new ItemStack(IntegratedItems.meltedventinite.itemID, 1, 0), 0.5F);
		//FurnaceRecipes.addSmelting(IntegratedBlocks.endOres.blockID, 0, new ItemStack(IntegratedItems.meltedwizimite.itemID, 1, 0), 0.5F);
		//FurnaceRecipes.addSmelting(IntegratedBlocks.surfaceOres.blockID, 0, new ItemStack(IntegratedItems.ingotsilver.itemID, 1, 0), 0.5F);
		//FurnaceRecipes.addSmelting(IntegratedBlocks.netherOres.blockID, 0, new ItemStack(IntegratedItems.bloodstoneclump.itemID, 1, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.goldrod, new ItemStack(Items.GOLD_INGOT, 2, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.bloodstonedust, new ItemStack(IntegratedItems.ingotbloodstone, 1, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.bloodstoneclump, new ItemStack(IntegratedItems.ingotbloodstone, 1, 0), 0.5F);
		GameRegistry.addSmelting(Blocks.OBSIDIAN, new ItemStack(IntegratedItems.obsidianingot, 1, 0), 0.5F);
		//FurnaceRecipes.smelting().addSmelting(IntegratedBlocks.netherOres.blockID, 4, new ItemStack(Item.ingotGold.itemID, 1, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.irondust, new ItemStack(IntegratedItems.superheatedironingot, 2, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.goldDust, new ItemStack(Items.GOLD_INGOT, 1, 0), 0.1F);
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.goldrod, 1, 0), new Object[] {"D", "S", "D", 'S', Items.STICK, 'D', Items.GOLD_INGOT});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.goldrod, 1, 0), new Object[] {"DSD", 'S', Items.STICK, 'D', Items.GOLD_INGOT});
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedItems.goldDust, 1, 0), new Object[] {"oreNetherGoldOre", "hammer1"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedItems.blackdiamond, 1, 0), new Object[] {"oreNetherBlackDiamond", "hammer1"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(Items.DIAMOND, 1, 0), new Object[] {"oreNetherDiamondOre", "hammer1"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedItems.dragonstoneshard, 1, 0), new Object[] {"oreNetherDragonstone", "hammer1"}));
	}

	public static void loadCurrency()
	{
		GameRegistry.addSmelting(Blocks.TALLGRASS, new ItemStack(IntegratedItems.Straw), 0.5F);
		GameRegistry.addSmelting(Items.GOLD_INGOT, new ItemStack(IntegratedItems.ingotRefinedgold, 1, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.Crown, new ItemStack(IntegratedItems.ingotRefinedgold, 3, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.goldbucket, new ItemStack(IntegratedItems.moltengold, 1, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.silverbucket, new ItemStack(IntegratedItems.moltensilver, 1, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.bronzebucket, new ItemStack(IntegratedItems.moltenbronze, 1, 0), 0.5F);
		GameRegistry.addSmelting(IntegratedItems.copperbucket, new ItemStack(IntegratedItems.moltencopper, 1, 0), 0.5F);
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Bag, 1), new Object[] {"TTT", "T T", "TTT", 'T', IntegratedItems.Straw});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Sack, 1), new Object[] {"TTT", "TTT", 'T', IntegratedItems.Straw});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Crown, 1), new Object[] {"T T", "TTT", 'T', Items.GOLD_INGOT});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.KinglyChest, 1), new Object[] {"T T", "TTT", "TTT", 'T', Blocks.WOOL});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.KinglyLegs, 1), new Object[] {"TTT", "T T", "T T", 'T', Blocks.WOOL});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.KinglyBoots, 1), new Object[] {"T T", "T T", 'T', Blocks.WOOL});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.diamondcrown, 1), new Object[] {"TDT", "TTT", 'T', Items.GOLD_INGOT, 'D', Items.DIAMOND});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.emeraldcrown, 1), new Object[] {"TET", "TTT", 'T', Items.GOLD_INGOT, 'E', Items.EMERALD});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedItems.rubycrown, 1, 0), new Object[] {Boolean.valueOf(true), new Object[]{"TYT", "TTT", 'T', Items.GOLD_INGOT, 'Y', "gemRuby"}}));
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.bloodstonehelm, 1), new Object[] {"TTT", "T T", 'T', IntegratedItems.ingotbloodstone});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.bloodstonechest, 1), new Object[] {"T T", "TTT", "TTT", 'T', IntegratedItems.ingotbloodstone});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.bloodstonelegs, 1), new Object[] {"TTT", "T T", "T T", 'T', IntegratedItems.ingotbloodstone});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.bloodstoneboots, 1), new Object[] {"T T", "T T", 'T', IntegratedItems.ingotbloodstone});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedItems.goldbucket, 1, 0), new Object[] {Boolean.valueOf(true), new Object[]{"Y", "X", 'X', Items.BUCKET, 'Y', "ingotRefinedgold"}}));
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ingotRefinedgold, 1), new Object[] {IntegratedItems.goldbucket});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ingotRefinedgold, 1), new Object[] {IntegratedItems.moltengold, new ItemStack(IntegratedItems.ingotmould, 1, 32767)});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedItems.silverbucket, 1, 0), new Object[] {Boolean.valueOf(true), new Object[]{"Y", "X", 'X', Items.BUCKET, 'Y', "ingotSilver"}}));
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ingotSilver, 1), new Object[] {IntegratedItems.silverbucket});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ingotSilver, 1), new Object[] {IntegratedItems.moltensilver, new ItemStack(IntegratedItems.ingotmould, 1, 32767)});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedItems.bronzebucket, 1, 0), new Object[] {Boolean.valueOf(true), new Object[]{"Y", "X", 'X', Items.BUCKET, 'Y', "ingotBronze"}}));
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ingotBronze, 1), new Object[] {IntegratedItems.bronzebucket});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ingotBronze, 1), new Object[] {IntegratedItems.moltenbronze, new ItemStack(IntegratedItems.ingotmould, 1, 32767)});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedItems.copperbucket, 1, 0), new Object[] {Boolean.valueOf(true), new Object[]{"Y", "X", 'X', Items.BUCKET, 'Y', "ingotCopper"}}));
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ingotCopper, 1), new Object[] {IntegratedItems.copperbucket});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ingotCopper, 1), new Object[] {IntegratedItems.moltencopper, new ItemStack(IntegratedItems.ingotmould, 1, 32767)});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.Metadatacoin, 2, 0), new Object[] {new ItemStack(IntegratedItems.moltencopper), new ItemStack(IntegratedItems.CoinMould, 1, 32767)});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.Metadatacoin, 2, 1), new Object[] {new ItemStack(IntegratedItems.moltenbronze), new ItemStack(IntegratedItems.CoinMould, 1, 32767)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 2), new Object[] {"###", "###", "###", '#', new ItemStack(IntegratedItems.Metadatacoin, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 3), new Object[] {"DDD", 'D', new ItemStack(IntegratedItems.Metadatacoin, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 4), new Object[] {"###", "###", " D ", '#', new ItemStack(IntegratedItems.Metadatacoin, 1, 3), 'D', IntegratedItems.Sack});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 5), new Object[] {"###", " D ", '#', new ItemStack(IntegratedItems.Metadatacoin, 1, 4), 'D', IntegratedItems.Bag});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.Metadatacoin, 2, 6), new Object[] {new ItemStack(IntegratedItems.moltensilver), new ItemStack(IntegratedItems.CoinMould, 1, 32767)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 7), new Object[] {"###", "###", "###", '#', new ItemStack(IntegratedItems.Metadatacoin, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 8), new Object[] {"DDD", 'D', new ItemStack(IntegratedItems.Metadatacoin, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 9), new Object[] {"###", "###", " D ", '#', new ItemStack(IntegratedItems.Metadatacoin, 1, 8), 'D', IntegratedItems.Sack});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 10), new Object[] {"###", " D ", '#', new ItemStack(IntegratedItems.Metadatacoin, 1, 9), 'D', IntegratedItems.Bag});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.Metadatacoin, 2, 11), new Object[] {new ItemStack(IntegratedItems.moltengold), new ItemStack(IntegratedItems.CoinMould, 1, 32767)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 12), new Object[] {"###", "###", "###", '#', new ItemStack(IntegratedItems.Metadatacoin, 2, 11)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 13), new Object[] {"DDD", 'D', new ItemStack(IntegratedItems.Metadatacoin, 2, 12)});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 14), new Object[] {"###", "###", " D ", '#', new ItemStack(IntegratedItems.Metadatacoin, 2, 13), 'D', IntegratedItems.Sack});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Metadatacoin, 1, 15), new Object[] {"###", " D ", '#', new ItemStack(IntegratedItems.Metadatacoin, 2, 14), 'D', IntegratedItems.Bag});
	}

	public static void loadBookcases()
	{
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.bookcases, 1, 0), new Object[] {"###", "XXX", "###", 'X', Blocks.WOODEN_SLAB, '#', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.Bookcasechest, 1), new Object[] {"###", "BGB", "###", '#', Blocks.PLANKS, 'G', Blocks.CHEST, 'B', Items.BOOK});
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.leverbookcase, 1), new Object[] {"###", "BGB", "###", '#', Blocks.PLANKS, 'G', Blocks.LEVER, 'B', Items.BOOK});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.WoodenBookcasedoor, 1), new Object[] {"## ", "## ", "## ", '#', Blocks.BOOKSHELF});
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.IronBookcasedoor, 1), new Object[] {" # ", "III", '#', IntegratedItems.WoodenBookcasedoor, 'I', Items.IRON_INGOT});
		GameRegistry.addRecipe(new ItemStack(Blocks.BOOKSHELF, 1), new Object[] {"BBB", " # ", '#', new ItemStack(IntegratedBlocks.bookcases, 1, 0), 'B', Items.BOOK});
		GameRegistry.addRecipe(new ItemStack(Blocks.BOOKSHELF, 1), new Object[] {"#", '#', new ItemStack(IntegratedBlocks.bookcases, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.bookcases, 1, 0), new Object[] {"#", '#', new ItemStack(IntegratedBlocks.bookcases, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.bookcases, 1, 3), new Object[] {"###", "BBB", "###", '#', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 0), 'B', IntegratedItems.scroll});
	}

	public static void loadCore()
	{
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.enderportal, 1), new Object[] {"I I", "XXX", 'I', IntegratedItems.blackdiamond, 'X', new ItemStack(IntegratedBlocks.endOres, 1, 2)});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.rcendereye, 1, 0), new Object[] {Items.ENDER_EYE, Items.BLAZE_POWDER, IntegratedItems.meltedventinite});
		GameRegistry.addSmelting(Blocks.SPONGE, new ItemStack(IntegratedBlocks.newSponge), 0.1F);
		GameRegistry.addSmelting(IntegratedBlocks.DarkSand, new ItemStack(Blocks.GLASS, 1, 0), 0.5F);
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(IntegratedItems.ChainLoop, 3, 0), new Object[] {"ingotSuperheatediron", "hammer"}));
		GameRegistry.addRecipe(new ItemStack(IntegratedItems.Hammer, 1), new Object[] {"XXX", "XIX", " I ", 'I', Items.STICK, 'X', Items.IRON_INGOT});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(IntegratedItems.bloodstoneHammer, 1), new Object[] {"XXX", "XIX", " I ", 'I', "goldRod", 'X', "ingotBloodstone"}));
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.chainladder, 2), new Object[] {"Y", "Y", "Y", 'Y', IntegratedItems.ChainLoop});
		//GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.ChainLoop, 2), new Object[] {IntegratedBlocks.chainladder});
		//GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.snowblock, 1), new Object[] {"DD", "DD", 'D', Block.ice});
		GameRegistry.addShapelessRecipe(new ItemStack(IntegratedItems.SandStonePaste, 2, 0), new Object[] {IntegratedBlocks.DarkSand, Items.WATER_BUCKET});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.MAP, 1), new Object[] {IntegratedItems.Mapinabottle});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.BOAT, 1), new Object[] {IntegratedItems.Shipinabottle});
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 4, 5), new Object[] {"XYX", "YXY", "XYX", 'Y', new ItemStack(IntegratedBlocks.DesertBlocks, 1, 3), 'X', new ItemStack(IntegratedItems.SandStonePaste)});
		GameRegistry.addRecipe(new ItemStack(IntegratedBlocks.DesertBlocks, 1, 2), new Object[] {"GG", "GG", 'G', IntegratedItems.SandStonePaste});
	}
}