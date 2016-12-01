package com.reactioncraft.ore.common.world;

import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import com.reactioncraft.integration.instances.IntegratedBlocks;
import com.reactioncraft.ore.common.BlockSOMulti;
import com.reactioncraft.ore.common.EnumSores;

public class worldgen implements IWorldGenerator 
{
	private static final IBlockState Ore = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE,  EnumSores.two2);//Silver 
	private static final IBlockState Ore1 = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE, EnumSores.two3);//Ventinite
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0) { // the overworld
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}

	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		generateOre(Ore,  world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6);
		generateOre(Ore1, world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6);
	}

	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;

		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore + " at " + pos);
		}
	}
}