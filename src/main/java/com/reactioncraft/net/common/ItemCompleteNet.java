package com.reactioncraft.net.common;

import java.util.List;
import java.util.Set;
import com.google.common.collect.ImmutableSet;
import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.ItemModelProvider;
import com.reactioncraft.integration.instances.IntegratedItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCompleteNet extends ItemSword implements ItemModelProvider
{
	public int retunedAmt;
	public int myReturnedAmt;
	protected final String name;

	public ItemCompleteNet(String name, ToolMaterial mat)
	{
		super(mat);
		//damageVsEntity = 0.0F;
		//attackSpeed = 0.0F;
		this.name = name;
		this.setRegistryName(new ResourceLocation(reactioncraft.MODID, name));
		this.setUnlocalizedName(reactioncraft.MODID + "." + name);
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}

	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("pickaxe", "axe", "shovel", "sword");
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
	{
		if (entity != null || !reactioncraft.exclusionList.isExcluded(entity) && entity instanceof EntityLiving)
		{
			if (entity instanceof EntityPlayer)
			{
				return false;
			}
			else
			{
				NBTTagCompound entityTag = new NBTTagCompound();
				entity.writeToNBTOptional(entityTag);
				entityTag.removeTag("Pos");
				entityTag.removeTag("Motion");
				entityTag.removeTag("Rotation");
				entityTag.removeTag("Dimension");
				entityTag.removeTag("PortalCooldown");
				entityTag.removeTag("InLove");
				entityTag.removeTag("HurtTime");
				entityTag.removeTag("DeathTime");
				entityTag.removeTag("AttackTime");

				ItemStack is = new ItemStack(IntegratedItems.caught);
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setTag("EntityData", entityTag);
				is.setTagCompound(nbt);
				 player.dropItem(is, false);
				stack.damageItem(1, player);
				entity.setDead();

				if (stack.getItemDamage() >= stack.getMaxDamage() - 1 && player instanceof EntityPlayer)
				{
					--stack.stackSize;
				}

				return true;
			}
		}
		else
		{
			return false;
		}
	}

	/**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
	
	@Override
	public int getMaxDamage(ItemStack stack)
	{
		NBTTagCompound compound = stack.getTagCompound();
		try
		{
			int e = compound.getInteger("hilt");
			int netLevel = compound.getInteger("net");
			retunedAmt = (e * 10 + netLevel * 10);
			myReturnedAmt = retunedAmt;
			return retunedAmt;
		}
		catch (NullPointerException var5)
		{
			retunedAmt = 20;
			return retunedAmt;
		}
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List<String> list, boolean par4)
	{
		if (itemStack.getTagCompound() != null)
		{
			list.add("Hilt Level: " + itemStack.getTagCompound().getInteger("hilt"));
			list.add("Net Level: "  + itemStack.getTagCompound().getInteger("net"));
			list.add("Uses: " + myReturnedAmt);
		}
		else
		{
			if(itemStack.getTagCompound() != null)
			{
				list.add("Hilt Level: " + itemStack.getTagCompound().getInteger("hilt"));
				list.add("Net Level: "  + itemStack.getTagCompound().getInteger("net"));
				list.add("Uses: " + myReturnedAmt);
			}
		}
		super.addInformation(itemStack, player, list, par4);
	}
	
    @Override
    public void registerItemModel()
    {
        reactioncraft.proxy.registerItemRenderer(this, 0, this.name);
    }
}