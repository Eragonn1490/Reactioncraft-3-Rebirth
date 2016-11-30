package com.reactioncraft.core.common.items;

import java.util.List;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.ItemModelProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemBaseHammer extends ItemSword implements ItemModelProvider
{
	protected String name;
	public int myReturnedAmt;
	
    public ItemBaseHammer(String name, int myReturnedAmt)
    {
        super(ToolMaterial.WOOD);
        this.name = name;
        this.setMaxStackSize(1);
        this.myReturnedAmt = myReturnedAmt;
        this.setMaxDamage(myReturnedAmt);
        this.setCreativeTab(reactioncraft.ReactioncraftItems);
        this.setRegistryName(new ResourceLocation(reactioncraft.MODID, name));
		this.setUnlocalizedName(reactioncraft.MODID + "." + name);
    }
    
    @Override
    public void registerItemModel() 
    {
        reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
    }

    @Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4)
	{	
    	list.add("Uses: " + myReturnedAmt);
		super.addInformation(itemStack, player, list, par4);
	}
}