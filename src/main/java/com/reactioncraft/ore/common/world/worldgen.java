package com.reactioncraft.ore.common.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import java.util.Random;

import com.reactioncraft.core.common.biomes.ReactionGenMinable;
import com.reactioncraft.desert.common.*;
import com.reactioncraft.desert.common.biome.BiomeGenReactionDesert;
import com.reactioncraft.integration.instances.IntegratedBlocks;
import com.reactioncraft.ore.common.*;

public class worldgen implements IWorldGenerator 
{
	private static final IBlockState Ore = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE,  EnumSores.two2);//Ventinite
	private static final IBlockState Ore1 = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE, EnumSores.two3);//Silver 

	//Desert Blocks
	private static final IBlockState Ore2 = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE, EnumSores.one1);//Desert Coal

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0) { // the overworld
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}

	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		generateVentinite(Ore,  world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6);
		generateSilver(Ore1  ,  world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6);
		
		//Desert Biome Generation
		generateDesertCoal(Ore2, world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(20), 6);
		
	}

	private void generateDesertCoal(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
			int deltaY = maxY - minY;

			for (int i = 0; i < chances; i++) 
			{
				BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

				//Generate Silver
				ReactionGenMinable generator = new ReactionGenMinable(ore, size);
				generator.generate(world, random, pos);
				System.out.println("Spawned " + Ore + " at " + pos);
			}
	}

	private void generateVentinite(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
			int deltaY = maxY - minY;

			for (int i = 0; i < chances; i++) 
			{
				BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

				//Generate Silver
				WorldGenMinable generator = new WorldGenMinable(ore, size);
				generator.generate(world, random, pos);
				//System.out.println("Spawned " + Ore + " at " + pos);
			}
	}

	private void generateSilver(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;

		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate Silver
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore + " at " + pos);
		}
	}
}