package com.reactioncraft.core;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.reactioncraft.reactioncraft;

public class GenericTileRenderer extends TileEntitySpecialRenderer 
{
    private static final ResourceLocation resourceloc = new ResourceLocation(reactioncraft.MODID + ":" + "textures/tileentity/computer.png");
}