package com.reactioncraft.core.common.creativeTab;

import com.reactioncraft.integration.instances.IntegratedItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RCTAB extends CreativeTabs
{	
    public RCTAB(String texture)
    {
        super(texture);
    }
    
    @SideOnly(Side.CLIENT)
    public String getBackgroundImageName()
    {
        return "item_search.png";
    }
    
    @Override
    public boolean hasSearchBar()
    {
        return true;
    }

	@Override
	public Item getTabIconItem() 
	{
		return IntegratedItems.meat_cleaver;
	}
}