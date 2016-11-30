package com.reactioncraft.integration;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;
import com.reactioncraft.core.common.entity.EntityMap;
import com.reactioncraft.core.common.items.*;
import com.reactioncraft.currency.common.*;
import com.reactioncraft.desert.common.*;
import com.reactioncraft.food.common.*;
import com.reactioncraft.integration.instances.IntegratedBlocks;
import com.reactioncraft.integration.instances.IntegratedItems;
import com.reactioncraft.net.common.*;
import com.reactioncraft.tools.common.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemDoor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class IntegratedItemRegistry 
{
    public static void init() 
    {
        //Food Related Weapons
        IntegratedItems.meat_cleaver = register(new ItemBase("meat_cleaver")  .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Knife        = (ItemKnife) register(new ItemKnife("Knife")         .setCreativeTab(reactioncraft.ReactioncraftItems));

        //Bone Drop
        IntegratedItems.bones         = register(new ItemBase("bones")        .setCreativeTab(reactioncraft.ReactioncraftItems));


        //Modified Food Drops
        IntegratedItems.raw_human       = register(new ItemFoodBase("raw_human",    3, 0.6f, true));
        IntegratedItems.cooked_human    = register(new ItemFoodBase("cooked_human", 4, 0.8f, true));
        IntegratedItems.raw_lamb        = register(new ItemFoodBase("raw_lamb",     3, 0.6f, true));
        IntegratedItems.cooked_lamb     = register(new ItemFoodBase("cooked_lamb",  8, 0.8f, true));
        IntegratedItems.raw_horse       = register(new ItemFoodBase("raw_horse",    3, 0.6f, true));
        IntegratedItems.cooked_horse    = register(new ItemFoodBase("cooked_horse", 4, 0.8f, true));
        IntegratedItems.chicken_head    = register(new ItemchickenHead("chicken_head", 3, 0.6f, true));
        IntegratedItems.beef_chunk      = register(new ItemFoodBase("beef_chunk",     3, 0.6f, true));
        IntegratedItems.pork_chunk      = register(new ItemFoodBase("raw_pork",     3, 0.6f, true));

        //Food Items
        IntegratedItems.AncientFruit       = register(new ItemFoodBase("AncientFruit", 3, 0.6f, true));
        IntegratedItems.EdibleFlesh        = register(new ItemFoodBase("EdibleFlesh", 3, 0.6f, true));
        IntegratedItems.cookedCorn         = register(new ItemFoodBase("cookedCorn", 3, 0.6f, true));
        IntegratedItems.popcornseeds       = register(new ItemBase("popcornseeds"));
        IntegratedItems.bagofpopcorn       = register(new ItemBase("bagofpopcorn"));
        IntegratedItems.poppedbagofpopcorn = register(new ItemFoodBase("poppedbagofpopcorn", 3, 0.6f, true));
        IntegratedItems.UnwrappedCorn      = register(new ItemFoodBase("UnwrappedCorn", 3, 0.6f, true));
        IntegratedItems.rawcorn            = register(new ItemFoodBase("rawcorn", 3, 0.6f, true));
        IntegratedItems.ChickenNuggets     = register(new ItemFoodBase("ChickenNuggets", 3, 0.6f, true));
        IntegratedItems.RawNuggets         = register(new ItemFoodBase("RawNuggets", 3, 0.6f, true));
        IntegratedItems.SlicedBread        = register(new ItemFoodBase("SlicedBread", 3, 0.6f, true));
        IntegratedItems.HamSandwich        = register(new ItemFoodBase("HamSandwich", 3, 0.6f, true));
        IntegratedItems.Hamburger          = register(new ItemFoodBase("Hamburger", 3, 0.6f, true));
        IntegratedItems.Cheeseburger       = register(new ItemFoodBase("Cheeseburger", 3, 0.6f, true));
        IntegratedItems.Bacon              = register(new ItemFoodBase("Bacon", 3, 0.6f, true));
        IntegratedItems.raw_bacon          = register(new ItemFoodBase("raw_bacon", 3, 0.6f, true));
        IntegratedItems.cheese             = register(new ItemFoodBase("cheese", 3, 0.6f, true));
        IntegratedItems.churn              = (ItemBase) register(new ItemBase("churn")).setMaxDamage(10);
        IntegratedItems.buns               = register(new ItemFoodBase("buns", 3, 0.6f, true));
        IntegratedItems.salmonRaw          = register(new ItemFoodBase("salmonRaw", 3, 0.6f, true));
        IntegratedItems.salmon             = register(new ItemFoodBase("salmon", 3, 0.6f, true));
        IntegratedItems.YellowTailRaw      = register(new ItemFoodBase("YellowTailRaw", 3, 0.6f, true));
        IntegratedItems.YellowTailCooked   = register(new ItemFoodBase("YellowTailCooked", 3, 0.6f, true));

        //Net Items
        IntegratedItems.hilt         = register(new ItemPieceHilt("piece_hilt")       .setCreativeTab(null));
        IntegratedItems.net          = register(new ItemPieceNet("piece_net")         .setCreativeTab(null));
        IntegratedItems.complete_net = register(new ItemCompleteNet("complete_net", IntegratedMaterials.EnumToolMaterialNet));
        IntegratedItems.creative_net = register(new ItemBase("creative_net")          .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.caught       = register(new ItemCaughtEntity("caught"))       .setCreativeTab(null);

        //Desert Items
        IntegratedItems.SandStonePaste  = register(new ItemBase("SandStonePaste")     .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.UncutLBGem      = register(new ItemBase("UncutLBGem")         .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.CutLBGem        = register(new ItemBase("CutLBGem")           .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.UncutDBGem      = register(new ItemBase("UncutDBGem")         .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.CutDBGem        = register(new ItemBase("CutDBGem")           .setCreativeTab(reactioncraft.ReactioncraftItems));
        //Make The Scroll Act as a Book...Eventually
        IntegratedItems.scroll          = register(new ItemBase("scroll")             .setCreativeTab(reactioncraft.ReactioncraftItems));

        //Special Tools
        IntegratedItems.Hammer            = (ItemBaseHammer) register(new ItemBaseHammer("Hammer", 10)                                 .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstoneHammer  = (ItemBaseHammer) register(new ItemBaseHammer("bloodstoneHammer", 100)                       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.FlintChisel       = (ItemBaseChisel) register(new ItemBaseChisel("FlintChisel")      .setRegistryName("FlintChisel")      .setUnlocalizedName("FlintChisel")      .setMaxDamage(10)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.CopperChisel      = (ItemBaseChisel) register(new ItemBaseChisel("CopperChisel")     .setRegistryName("CopperChisel")     .setUnlocalizedName("CopperChisel")     .setMaxDamage(35)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.GoldChisel        = (ItemBaseChisel) register(new ItemBaseChisel("GoldChisel")       .setRegistryName("GoldChisel")       .setUnlocalizedName("GoldChisel")       .setMaxDamage(70)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.DiamondChisel     = (ItemBaseChisel) register(new ItemChisel1("DiamondChisel")       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.BloodstoneChisel  = (ItemBaseChisel) register(new ItemChisel2("BloodstoneChisel")    .setCreativeTab(reactioncraft.ReactioncraftItems));

        //Misc Items
        IntegratedItems.ChainLoop             = register(new ItemBase("ChainLoop")           .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstoneclump       = register(new ItemBase("bloodstoneclump")     .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.goldrod               = register(new ItemBase("goldrod")             .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.obsidianingot         = register(new ItemBase("obsidianingot")       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ingotbloodstone       = register(new ItemBase("ingotbloodstone")     .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ingotsilver           = register(new ItemBase("ingotsilver")         .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstonedust        = register(new ItemBase("bloodstonedust")      .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.blackdiamond          = register(new ItemBase("blackdiamond")        .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.dragonstoneshard      = register(new ItemBase("dragonstoneshard")    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.irondust              = register(new ItemBase("irondust")            .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ironShavings          = register(new ItemBase("ironShavings")        .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.gemdragonstone        = register(new ItemBase("gemdragonstone")      .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.superheatedironingot  = register(new ItemBase("superheatedironingot").setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.goldDust              = register(new ItemBase("goldDust")            .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.moltenglass           = register(new ItemBase("moltenglass")         .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.IceBucket             = (ItemBase) register(new ItemBase("IceBucket")     .setMaxStackSize(1).setContainerItem(Items.BUCKET) .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ObsidianBucket        = (ItemBase) register(new ItemBase("ObsidianBucket").setMaxStackSize(1).setContainerItem(Items.BUCKET)  .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Mapinabottle          = (ItemTossable) register(new ItemTossable("Mapinabottle") .setMaxStackSize(1)       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Shipinabottle         = (ItemTossable) register(new ItemTossable("Shipinabottle").setMaxStackSize(1)       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.rcendereye            = register(new ItemBase("rcendereye")          .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.AncientFlower         = register(new ItemBase("AncientFlower")       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Wrappedcorn           = register(new ItemBase("Wrappedcorn")         .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.AncientSeeds          = register(new ItemBase("AncientSeeds")        .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.sugarcaneItemBase     = register(new ItemBase("sugarcaneItemBase")   .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.CornSeed              = register(new ItemBase("CornSeed")            .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.stalksItemBase        = register(new ItemBase("stalksItemBase")      .setCreativeTab(reactioncraft.ReactioncraftItems));

        //Door Items
        IntegratedItems.WoodenBookcasedoor    = (ItemBaseDoor) register(new ItemBaseDoor("WoodenBookcasedoor", IntegratedBlocks.WoodenBookcasedoorBlockBase));
        IntegratedItems.IronBookcasedoor      = (ItemBaseDoor) register(new ItemBaseDoor("IronBookcasedoor",   IntegratedBlocks.IronBookcasedoorBlockBase));
        IntegratedItems.cherry_door           = (ItemBaseDoor) register(new ItemBaseDoor("item_cherry_door",        IntegratedBlocks.cherrydoorBlockBase));

        //Currency Items
        IntegratedItems.Bag               = register(new ItemBase("Bag")             .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Sack              = register(new ItemBase("Sack")            .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Straw             = register(new ItemBase("Straw")           .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.CoinMould         = (ItemBase) register(new ItemBase("CoinMould")   .setMaxDamage(15)  .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.moltengold        = register(new ItemBase("moltengold")      .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.moltensilver      = register(new ItemBase("moltensilver")    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.moltencopper      = register(new ItemBase("moltencopper")    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.moltenbronze      = register(new ItemBase("moltenbronze")    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.copperbucket      = register(new ItemBase("copperbucket")    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.silverbucket      = register(new ItemBase("silverbucket")    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bronzebucket      = register(new ItemBase("bronzebucket")    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.goldbucket        = register(new ItemBase("goldbucket")      .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ingotRefinedgold  = register(new ItemBase("ingotRefinedgold").setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ingotSilver       = register(new ItemBase("ingotSilver")     .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ingotBronze       = register(new ItemBase("ingotBronze")     .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ingotCopper       = register(new ItemBase("ingotCopper")     .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ingotmould        = (ItemBase) register(new ItemBase("ingotmould")  .setMaxDamage(15)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ruby              = register(new ItemBase("ruby")            .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Metadatacoin      = register(new ItemBase("Metadatacoin")    .setCreativeTab(reactioncraft.ReactioncraftItems));

        
        //Armor Items
        IntegratedItems.Crown       = (ItemCurrencyArmor) register(new ItemCurrencyArmor("Crown",       IntegratedMaterials.EnumArmorMaterialKing, 0, EntityEquipmentSlot.HEAD))      .setCreativeTab(reactioncraft.ReactioncraftItems);
        IntegratedItems.KinglyChest = (ItemCurrencyArmor) register(new ItemCurrencyArmor("KinglyChest", IntegratedMaterials.EnumArmorMaterialKing, 0, EntityEquipmentSlot.CHEST))     .setCreativeTab(reactioncraft.ReactioncraftItems);
        IntegratedItems.KinglyLegs  = (ItemCurrencyArmor) register(new ItemCurrencyArmor("KinglyLegs",  IntegratedMaterials.EnumArmorMaterialKing, 0, EntityEquipmentSlot.LEGS))      .setCreativeTab(reactioncraft.ReactioncraftItems);
        IntegratedItems.KinglyBoots = (ItemCurrencyArmor) register(new ItemCurrencyArmor("KinglyBoots", IntegratedMaterials.EnumArmorMaterialKing, 0, EntityEquipmentSlot.FEET))      .setCreativeTab(reactioncraft.ReactioncraftItems);
        IntegratedItems.diamondcrown      = (ItemExtraCrowns) register(new ItemExtraCrowns("diamondcrown",       IntegratedMaterials.EnumArmorMaterialCrown1, 0, EntityEquipmentSlot.HEAD)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.emeraldcrown      = (ItemExtraCrowns) register(new ItemExtraCrowns("emeraldcrown",       IntegratedMaterials.EnumArmorMaterialCrown2, 0, EntityEquipmentSlot.HEAD)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.rubycrown         = (ItemExtraCrowns) register(new ItemExtraCrowns("rubycrown",          IntegratedMaterials.EnumArmorMaterialCrown3, 0, EntityEquipmentSlot.HEAD)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.darkbluecrown     = (ItemExtraCrowns) register(new ItemExtraCrowns("darkbluecrown",      IntegratedMaterials.EnumArmorMaterialCrown4, 0, EntityEquipmentSlot.HEAD)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstonecrown   = (ItemExtraCrowns) register(new ItemExtraCrowns("bloodstonecrown",    IntegratedMaterials.EnumArmorMaterialCrown5, 0, EntityEquipmentSlot.HEAD)    .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstonehelm    = register(new ItemBase("bloodstonehelm")  .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstonechest   = register(new ItemBase("bloodstonechest") .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstonelegs    = register(new ItemBase("bloodstonelegs")  .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstoneboots   = register(new ItemBase("bloodstoneboots") .setCreativeTab(reactioncraft.ReactioncraftItems));
        
        //registerItem(299, "leather_chestplate", (new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST)).setUnlocalizedName("KinglyChest"));
        //registerItem(300, "leather_leggings",   (new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.LEGS)) .setUnlocalizedName("KinglyLegs"));
        //registerItem(301, "leather_boots",      (new ItemArmor(ItemArmor.ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.FEET)) .setUnlocalizedName("KinglyBoots"));
        

        //Weapons
        IntegratedItems.Bat                    = register(new ItemBase("Bat")                   .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ObbySword              = (ItemObsidanSword) register(new ItemObsidanSword("ObbySword", IntegratedMaterials.EnumToolMaterialObby));
        IntegratedItems.ObbyPick               = (ItemObsidanPick)  register(new ItemObsidanPick("ObbyPick", IntegratedMaterials.EnumToolMaterialObby)                              .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ObbyShovel             = (ItemObsidianShovel) register(new ItemObsidianShovel("ObbyShovel", IntegratedMaterials.EnumToolMaterialObby)                       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ObbyAxe                = (ItemObsidianAxe) register(new ItemObsidianAxe("ObbyAxe", IntegratedMaterials.EnumToolMaterialObby)                                .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.ObbyHoe                = (ItemObsidianHoe) register(new ItemObsidianHoe("ObbyHoe", IntegratedMaterials.EnumToolMaterialObby)                                .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.BloodstoneSword        = (ItemBloodstoneSword) register(new ItemBloodstoneSword("BloodstoneSword", IntegratedMaterials.EnumToolMaterialBloodstone)          .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.BloodstonePick         = (ItemBloodstonePick) register(new ItemBloodstonePick("BloodstonePick", IntegratedMaterials.EnumToolMaterialBloodstone)             .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.BloodstoneShovel       = (ItemBloodstoneShovel) register(new ItemBloodstoneShovel("BloodstoneShovel", IntegratedMaterials.EnumToolMaterialBloodstone)       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.BloodstoneAxe          = (ItemBloodstoneAxe) register(new ItemBloodstoneAxe("BloodstoneAxe", IntegratedMaterials.EnumToolMaterialBloodstone)                .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.BloodstoneHoe          = (ItemBloodstoneHoe) register(new ItemBloodstoneHoe("BloodstoneHoe", IntegratedMaterials.EnumToolMaterialBloodstone)                .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.BloodstoneDiamondPick  = (ItemBlackdiamondPick) register(new ItemBlackdiamondPick("BloodstoneDiamondPick", IntegratedMaterials.EnumToolMaterialBloodstone2) .setCreativeTab(reactioncraft.ReactioncraftItems));
        
        //Weapon Parts
        IntegratedItems.BloodstoneBlade        = register(new ItemBase("BloodstoneBlade")       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.GoldenSwordFragment    = register(new ItemBase("GoldenSwordFragment")   .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.UnbindedSword          = register(new ItemBase("UnbindedSword")         .setCreativeTab(reactioncraft.ReactioncraftItems));


        //Ores
        IntegratedItems.meltedventinite  = register(new ItemBase("meltedventinite") .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.meltedwizimite   = register(new ItemBase("meltedwizimite")  .setCreativeTab(reactioncraft.ReactioncraftItems));

        //Made For Other Mod Items
        IntegratedItems.scoop            = register(new ItemBase("scoop")           .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.bloodstoneframe  = register(new ItemBase("bloodstoneframe") .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.honeycomb        = register(new ItemBase("honeycomb")       .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.pollencomb       = register(new ItemBase("pollencomb")      .setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Blackdiamondbore = register(new ItemBase("Blackdiamondbore").setCreativeTab(reactioncraft.ReactioncraftItems));
        IntegratedItems.Bloodstonebore   = register(new ItemBase("Bloodstonebore")  .setCreativeTab(reactioncraft.ReactioncraftItems));     
    }

    private static void registerRender(Item item) 
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(reactioncraft.MODID + ":" + item.getUnlocalizedName().substring(5),"inventory"));
    }

   
    private static <T extends Item> T register(T item) 
    {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) 
        {
            ((ItemModelProvider) item).registerItemModel();
        }

        return item;
    }
}