package com.reactioncraft.core.common.creativeTab;

import com.reactioncraft.integration.instances.IntegratedItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RCTAB2 extends CreativeTabs
{
    public RCTAB2(String x0)
    {
        super(x0);
        this.setBackgroundImageName("item_search.png");
    }
    
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