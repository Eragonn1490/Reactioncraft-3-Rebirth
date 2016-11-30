package com.reactioncraft.currency.common;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;
import com.reactioncraft.integration.instances.IntegratedItems;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemExtraCrowns extends ItemArmor implements ItemModelProvider
{
    protected int enchantability;
    protected String name;
    
    /** The EnumArmorMaterial used for this ItemArmor */
    private final ArmorMaterial material;

    public ItemExtraCrowns(String name, ArmorMaterial par2EnumArmorMaterial, int par3, EntityEquipmentSlot par4)
    {
        super(par2EnumArmorMaterial, par3, par4);
        this.material = par2EnumArmorMaterial;
        this.enchantability = 30;
        this.name = name;
		this.setRegistryName(new ResourceLocation(reactioncraft.MODID, this.name));
		this.setUnlocalizedName(reactioncraft.MODID + "." + this.name);
    }
    
    @Override
	public void registerItemModel() 
	{
		reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
	}

//    public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, int layer)
//    {
//    	ItemStack Crown = new ItemStack(IntegratedItems.diamondcrown);
//    	ItemStack KinglyChest = new ItemStack(IntegratedItems.KinglyChest);
//    	ItemStack KinglyBoots = new ItemStack(IntegratedItems.KinglyBoots);
//    	ItemStack KinglyLegs = new ItemStack(IntegratedItems.KinglyLegs);
//    	
//        return itemstack != Crown && itemstack != KinglyChest && itemstack != KinglyBoots ? (itemstack == KinglyLegs ? "reactioncraft:textures/models/armor/diamondcrown_layer_2.png" : null) : "reactioncraft:textures/models/armor/diamondcrown_layer_1.png";
//    }
    
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.enchantability;
    }
}