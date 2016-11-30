package com.reactioncraft.mobs.common;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;

public class EntityBee extends EntityAnimal
{
    public EntityBee(World world)
    {
        super(world);
        this.setSize(0.4F, 0.4F);
        float f = 0.25F;
        this.tasks.addTask(0, new EntityAIPanic(this, 1.5D));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityPlayer.class, 1.0F, 0.8D, 1.33D));
        this.tasks.addTask(2, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIPanic(this, 1.5D));
        this.tasks.addTask(4, new EntityAITempt(this, 0.25D, Items.WHEAT, false));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 0.2800000011920929D));
        this.tasks.addTask(6, new EntityAIWander(this, (double)f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3000000029802322D);
    }

    public void entityInit()
    {
        super.entityInit();
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    public ItemStack getDropItemId()
    {
        if (Loader.isModLoaded("Forestry"))
        {
            //ItemStack pollen = ItemInterface.getItem("pollen");
        	ItemStack pollen = new ItemStack(Items.APPLE);
            System.out.println("[Foresty] mod loaded");
            return pollen;
        }
        else
        {
            return null;
        }
    }

    /**
     * Called when a lightning bolt hits the entity.
     */
    public void onStruckByLightning(EntityLightningBolt entitylightningbolt)
    {
        if (!this.worldObj.isRemote)
        {
            //EntityTJ entitybee = new EntityTJ(this.worldObj);
            //entitybee.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            //this.worldObj.spawnEntityInWorld(entitybee);
            this.setDead();
        }
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal entityanimal)
    {
        return new EntityBee(this.worldObj);
    }

    public EntityAgeable createChild(EntityAgeable entityageable)
    {
        return null;
    }

    public int isCollided()
    {
        return 0;
    }
}
