package com.reactioncraft.mobs.common;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityCreeper;

public class EntityAISeaCreeperSwell extends EntityAIBase
{
    EntityCreeper swellingSeaCreeper;
    EntityLivingBase creeperAttackTarget;

    public EntityAISeaCreeperSwell(EntityCreeper par1EntityCreeper)
    {
        this.swellingSeaCreeper = par1EntityCreeper;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.swellingSeaCreeper.getAttackTarget();
        return this.swellingSeaCreeper.getCreeperState() > 0 || entitylivingbase != null && this.swellingSeaCreeper.getDistanceSqToEntity(entitylivingbase) < 9.0D;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.swellingSeaCreeper.getNavigator().clearPathEntity();
        this.creeperAttackTarget = this.swellingSeaCreeper.getAttackTarget();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.creeperAttackTarget = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.creeperAttackTarget == null)
        {
            this.swellingSeaCreeper.setCreeperState(-1);
        }
        else if (this.swellingSeaCreeper.getDistanceSqToEntity(this.creeperAttackTarget) > 49.0D)
        {
            this.swellingSeaCreeper.setCreeperState(-1);
        }
        else if (!this.swellingSeaCreeper.getEntitySenses().canSee(this.creeperAttackTarget))
        {
            this.swellingSeaCreeper.setCreeperState(-1);
        }
        else
        {
            this.swellingSeaCreeper.setCreeperState(1);
        }
    }
}