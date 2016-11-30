package com.reactioncraft.net.common;

import java.util.List;
import javax.annotation.Nullable;

import com.reactioncraft.core.common.items.ItemBase;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class ItemCaughtEntity extends ItemBase
{
    public ItemCaughtEntity(String name)
    {
        super(name);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        String name = this.getEntityName(stack);

        if (name != null)
        {
            return super.getItemStackDisplayName(stack) + ": " + name;
        }

        return super.getItemStackDisplayName(stack);
        //return itemStack.getTagCompound().getCompoundTag("EntityData").getString("id") == "player" ? "Caught " + itemStack.getTagCompound().getString("playerUser") + " DNA" : "Caught " + itemStack.getTagCompound().getString("entity");
    }

    private @Nullable String getEntityName(ItemStack stack)
    {
        NBTTagCompound tag = this.getEntityTag(stack);

        if (tag != null)
        {
            String name = tag.getString("CustomName");

            if (tag.hasKey("id", Constants.NBT.TAG_STRING))
            {
                String id = tag.getString("id");
                String translated = I18n.format("entity." + id + ".name");

                if (id.equals(translated) == false)
                {
                    id = translated;
                }

                name = name.length() > 0 ? name : id;
            }

            return name;
        }

        return null;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos,
            EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (this.spawnCreature(worldIn, stack, pos.getX() + hitX, pos.getY() + hitY, pos.getZ() + hitZ) != null)
        {
            --stack.stackSize;
            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.PASS;
    }

    private @Nullable NBTTagCompound getEntityTag(ItemStack stack)
    {
        NBTTagCompound tag = stack.getTagCompound();
        return tag != null && tag.hasKey("EntityData", Constants.NBT.TAG_COMPOUND) ? tag.getCompoundTag("EntityData") : null;
    }

    @Nullable
    public Entity spawnCreature(World worldIn, ItemStack stack, double x, double y, double z)
    {
        if (worldIn.isRemote)
        {
            return null;
        }

        NBTTagCompound tag = this.getEntityTag(stack);

        if (tag != null)
        {
            Entity entity = EntityList.createEntityFromNBT(tag, worldIn);

            if (entity instanceof EntityLiving)
            {
                EntityLiving entityliving = (EntityLiving)entity;
                entity.setLocationAndAngles(x, y, z, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
                entityliving.rotationYawHead = entityliving.rotationYaw;
                entityliving.renderYawOffset = entityliving.rotationYaw;
                entityliving.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
                worldIn.spawnEntityInWorld(entity);
                entityliving.playLivingSound();
            }

            return entity;
        }
        else
        {
            return null;
        }
    }

    public static NBTTagList newDoubleNBTList(double ... par1ArrayOfDouble)
    {
        NBTTagList var2 = new NBTTagList();
        double[] var3 = par1ArrayOfDouble;
        int var4 = par1ArrayOfDouble.length;

        for (int var5 = 0; var5 < var4; ++var5)
        {
            double var6 = var3[var5];
            var2.appendTag(new NBTTagDouble(var6));
        }

        return var2;
    }

    public static NBTTagList newFloatNBTList(float ... par1ArrayOfFloat)
    {
        NBTTagList var2 = new NBTTagList();
        float[] var3 = par1ArrayOfFloat;
        int var4 = par1ArrayOfFloat.length;

        for (int var5 = 0; var5 < var4; ++var5)
        {
            float var6 = var3[var5];
            var2.appendTag(new NBTTagFloat(var6));
        }

        return var2;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean par4)
    {
        String name = this.getEntityName(stack);

        if (name != null)
        {
            list.add("Caught: " + name);
        }
        else
        {
            list.add("Please craft to see results");
        }

        super.addInformation(stack, player, list, par4);
    }
}
