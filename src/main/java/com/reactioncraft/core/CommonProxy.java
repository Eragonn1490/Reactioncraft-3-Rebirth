package com.reactioncraft.core;

import javax.annotation.Nullable;

import com.reactioncraft.reactioncraft;
import com.reactioncraft.core.common.tileEntities.*;
import com.reactioncraft.machines.common.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.*;

public class CommonProxy implements IGuiHandler
{
	public void registerItemRenderer(Item item, int meta, String id) 
	{
	}

	public void registerRenderInformation() 
	{
	}

    public int addArmor(String armorName)
    {
        return 0;
    }

    public enum GuiIDs
    {
        brick_oven;
    }

    @Override
	@Nullable
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
    	final TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
    	
    	switch(GuiIDs.values()[ID])
    	{
            case brick_oven:
                return new ContainerBrickOven(player.inventory, (TileEntityBrickOven) tileEntity);
        }
        throw new IllegalArgumentException("No gui with id " + ID);
    }

	@Override
	@Nullable
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		final TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

		switch (GuiIDs.values()[ID]) 
		{
			case brick_oven:
				if (tileEntity != null) 
				{
					return new GuiBrickoven(player.inventory, (TileEntityBrickOven) tileEntity);
				}

//			case MOD_CHEST:
//				if (tileEntity != null) {
//					return new GuiModChest(((TileEntityModChest) tileEntity).createContainer(player));
//				}

			default:
				return null;
		}
	}
}