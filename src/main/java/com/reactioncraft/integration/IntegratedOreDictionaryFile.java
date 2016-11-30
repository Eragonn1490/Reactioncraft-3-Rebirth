package com.reactioncraft.integration;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.integration.instances.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class IntegratedOreDictionaryFile
{
    public static void loadAll()
    {
        OreDictionary.registerOre("darkclay", new ItemStack(IntegratedItems.SandStonePaste));
        OreDictionary.registerOre("hammer", new ItemStack(IntegratedItems.Hammer, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("hammer", new ItemStack(IntegratedItems.bloodstoneHammer, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("hammer1", new ItemStack(IntegratedItems.bloodstoneHammer, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotRefinedgold", new ItemStack(IntegratedItems.ingotRefinedgold, 1, 0));
        OreDictionary.registerOre("ingotBronze", new ItemStack(IntegratedItems.ingotBronze, 1, 0));
        OreDictionary.registerOre("ingotSilver", new ItemStack(IntegratedItems.ingotSilver, 1, 0));
        OreDictionary.registerOre("ingotCopper", new ItemStack(IntegratedItems.ingotCopper, 1, 0));
        OreDictionary.registerOre("gemRuby", new ItemStack(IntegratedItems.ruby, 1, 0));
//        OreDictionary.registerOre("DarkCobble", new ItemStack(IntegratedBlocks.DesertBlockMulti, 1, 1));
//        OreDictionary.registerOre("DarkStone", new ItemStack(IntegratedBlocks.DesertBlockMulti, 1, 2));
//       OreDictionary.registerOre("oreDesertGold", new ItemStack(IntegratedBlocks.DesertBlockMulti, 1, 10));
//        OreDictionary.registerOre("BloodstoneBrick", new ItemStack(IntegratedBlocks.BloodstoneBrick));
//        OreDictionary.registerOre("carveddarkstone", new ItemStack(IntegratedBlocks.DesertBlockMulti, 1, 0));
//        OreDictionary.registerOre("darkstonebrick", new ItemStack(IntegratedBlocks.DesertBlockMulti, 1, 3));
        OreDictionary.registerOre("plankWood", new ItemStack(IntegratedBlocks.CherryPlanks));
        OreDictionary.registerOre("CherryWood", new ItemStack(IntegratedBlocks.Cherrywood));
        OreDictionary.registerOre("scroll", new ItemStack(IntegratedItems.scroll));
        OreDictionary.registerOre("chisel", new ItemStack(IntegratedItems.FlintChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel", new ItemStack(IntegratedItems.CopperChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel", new ItemStack(IntegratedItems.GoldChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel", new ItemStack(IntegratedItems.DiamondChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel", new ItemStack(IntegratedItems.BloodstoneChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel1", new ItemStack(IntegratedItems.GoldChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel1", new ItemStack(IntegratedItems.DiamondChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel1", new ItemStack(IntegratedItems.BloodstoneChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel2", new ItemStack(IntegratedItems.DiamondChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("chisel2", new ItemStack(IntegratedItems.BloodstoneChisel, 1, reactioncraft.WILDCARD_VALUE));
        OreDictionary.registerOre("rawCorn", new ItemStack(IntegratedItems.rawcorn));
        OreDictionary.registerOre("cheese", new ItemStack(IntegratedItems.cheese));
        OreDictionary.registerOre("goldRod", new ItemStack(IntegratedItems.goldrod));
        OreDictionary.registerOre("ingotObsidian", new ItemStack(IntegratedItems.obsidianingot));
        OreDictionary.registerOre("diamondBlack", new ItemStack(IntegratedItems.blackdiamond));
        OreDictionary.registerOre("ingotBloodstone", new ItemStack(IntegratedItems.ingotbloodstone));
        OreDictionary.registerOre("ingotSilver", new ItemStack(IntegratedItems.ingotsilver));
        OreDictionary.registerOre("ingotSuperheatediron", new ItemStack(IntegratedItems.superheatedironingot));
        OreDictionary.registerOre("ironDust", new ItemStack(IntegratedItems.irondust));
        OreDictionary.registerOre("shardDragonstone", new ItemStack(IntegratedItems.dragonstoneshard));
        OreDictionary.registerOre("gemDragonstone", new ItemStack(IntegratedItems.gemdragonstone));
        OreDictionary.registerOre("dyePurple", new ItemStack(IntegratedItems.dragonstoneshard));
        OreDictionary.registerOre("oreSilver", new ItemStack(IntegratedBlocks.surfaceOres, 1, 0));
        OreDictionary.registerOre("oreBloodstone", new ItemStack(IntegratedBlocks.netherOres, 1, 0));
        OreDictionary.registerOre("oreNetherBlackDiamond", new ItemStack(IntegratedBlocks.netherOres, 1, 1));
        OreDictionary.registerOre("oreNetherDragonstone", new ItemStack(IntegratedBlocks.netherOres, 1, 2));
        OreDictionary.registerOre("oreNetherDiamondOre", new ItemStack(IntegratedBlocks.netherOres, 1, 3));
        OreDictionary.registerOre("oreNetherGoldOre", new ItemStack(IntegratedBlocks.netherOres, 1, 4));
        OreDictionary.registerOre("bones", new ItemStack(IntegratedItems.bones));
        OreDictionary.registerOre("wrappedCorn", new ItemStack(IntegratedItems.Wrappedcorn));
    }
}
