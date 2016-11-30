package com.reactioncraft.core.common.items;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;
import com.reactioncraft.core.common.entity.EntityMap;
import com.reactioncraft.integration.instances.IntegratedItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemTossable extends Item implements ItemModelProvider
{
	protected String name;
	
    public ItemTossable(String name)
    {
        this.maxStackSize = 16;
        this.name = name;
		this.setRegistryName(new ResourceLocation(reactioncraft.MODID, this.name));
		this.setUnlocalizedName(reactioncraft.MODID + "." + this.name);
		this.setCreativeTab(reactioncraft.ReactioncraftItems);
    }

    @Override
	public void registerItemModel() 
	{
		reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
	}
    
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
        	ItemStack map = new ItemStack(IntegratedItems.Mapinabottle);
        	ItemStack ship = new ItemStack(IntegratedItems.Shipinabottle);
        	
        	if(itemStackIn == map)
        	{
        		EntityMap entityegg = new EntityMap(worldIn, playerIn);
                entityegg.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
                worldIn.spawnEntityInWorld(entityegg);
        	}
            //EntityEgg entityegg = new EntityEgg(worldIn, playerIn);
            //entityegg.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            //worldIn.spawnEntityInWorld(entityegg);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}