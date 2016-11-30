package com.reactioncraft.food.common;

import com.reactioncraft.core.common.items.ItemFoodBase;

public class ItemchickenHead extends ItemFoodBase 
{
	public ItemchickenHead(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(name, amount, saturation, isWolfFood);
		{
			this.setMaxStackSize(1);
		}
	}
}