package com.reactioncraft.mobs.common.renders;

import org.lwjgl.opengl.GL11;

import com.reactioncraft.mobs.common.EntitySkeletonCrawling;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.*;

@SideOnly(Side.CLIENT)
public class RenderSkeletonCrawling extends RenderLiving
{
    public RenderSkeletonCrawling(RenderManager renderManager, ModelBase modelbase, float f)
    {
        super(renderManager, modelbase, f);
    }

    public void renderSkeletonCrawling(EntitySkeletonCrawling EntitySkeletonCrawling, double d, double d1, double d2, float f, float f1)
    {
        super.doRender(EntitySkeletonCrawling, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        this.renderSkeletonCrawling((EntitySkeletonCrawling)entityliving, d, d1, d2, f, f1);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        this.renderSkeletonCrawling((EntitySkeletonCrawling)entity, d, d1, d2, f, f1);
    }

    public void preRenderScale(EntitySkeletonCrawling EntitySkeletonCrawling, float f)
    {
        GL11.glScalef(1.0F, 1.0F, 1.0F);
    }

    public void preRenderCallback(EntityLiving entityliving, float f)
    {
        this.preRenderScale((EntitySkeletonCrawling)entityliving, f);
    }

    public void rotateAnimal(EntityLiving entityliving)
    {
        GL11.glRotatef(90.0F, -1.0F, 0.0F, 0.0F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return new ResourceLocation("reactioncraft:textures/entity/skeleton1.png");
    }
}
