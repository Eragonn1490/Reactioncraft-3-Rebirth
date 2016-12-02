package com.reactioncraft.integration;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.relauncher.*;

public class IntegratedMaterials
{
	
	public static ToolMaterial  EnumToolMaterialNet;
	public static ToolMaterial  EnumToolMaterialMeatcleaver;
	public static ToolMaterial  EnumToolMaterialBat;
	public static ToolMaterial  EnumToolMaterialObby;
	public static ToolMaterial  EnumToolMaterialBloodstone;
	public static ToolMaterial  EnumToolMaterialBloodstone2;
	public static ArmorMaterial EnumArmorMaterialKing;
	public static ArmorMaterial EnumBloodstoneArmor;
	
	//Crowns here
	public static ArmorMaterial EnumArmorMaterialCrown1;
	public static ArmorMaterial EnumArmorMaterialCrown2;
	public static ArmorMaterial EnumArmorMaterialCrown3;
	public static ArmorMaterial EnumArmorMaterialCrown4;
	public static ArmorMaterial EnumArmorMaterialCrown5;
	//public static ArmorMaterial EnumArmorMaterialCrown6;
	
	@SideOnly(Side.CLIENT)
	@EventHandler
	public static void initMaterials()
	{
		EnumArmorMaterialKing       = EnumHelper.addArmorMaterial("kingly",     "reactioncraft:goldcrown" , 16, new int[] {1, 2, 3, 1}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
		EnumBloodstoneArmor         = EnumHelper.addArmorMaterial("bloodstone", "reactioncraft:bloodstone", 16, new int[] {4, 9, 7, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
		EnumToolMaterialNet         = EnumHelper.addToolMaterial("Net", 3, 1, 2.0F, 2.0F, 15);
		EnumToolMaterialMeatcleaver = EnumHelper.addToolMaterial("MeatCleaver", 2, 280, 6.0F, 2.0F, 14);
		EnumToolMaterialBat         = EnumHelper.addToolMaterial("Bat", 1, 79, 2.0F, 1.0F, 15);
		EnumToolMaterialObby        = EnumHelper.addToolMaterial("Obby", 3, 2024, 7.0F, 2.0F, 15);
		EnumToolMaterialBloodstone  = EnumHelper.addToolMaterial("Bloodstone", 3, 4200, 7.0F, 2.0F, 15);
		EnumToolMaterialBloodstone2 = EnumHelper.addToolMaterial("Bloodstone", 3, 4800, 7.0F, 3.0F, 15);
		
		//Crowns
		EnumArmorMaterialCrown1       = EnumHelper.addArmorMaterial("kingly",     "reactioncraft:diamondcrown"       , 16, new int[] {1, 2, 3, 1}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
		EnumArmorMaterialCrown2       = EnumHelper.addArmorMaterial("kingly",     "reactioncraft:emeraldcrown"       , 16, new int[] {1, 2, 3, 1}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
		EnumArmorMaterialCrown3       = EnumHelper.addArmorMaterial("kingly",     "reactioncraft:rubycrown"          , 16, new int[] {1, 2, 3, 1}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
		EnumArmorMaterialCrown4       = EnumHelper.addArmorMaterial("kingly",     "reactioncraft:darkbluecrown"      , 16, new int[] {1, 2, 3, 1}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
		EnumArmorMaterialCrown5       = EnumHelper.addArmorMaterial("kingly",     "reactioncraft:bloodstonecrown"    , 16, new int[] {4, 6, 6, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
		//EnumArmorMaterialCrown6       = EnumHelper.addArmorMaterial("kingly",     "reactioncraft:goldcrown"    , 16, new int[] {1, 2, 3, 1}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	}
}