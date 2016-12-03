package com.reactioncraft.core.common.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import java.util.Random;
import com.reactioncraft.desert.common.*;
import com.reactioncraft.integration.instances.IntegratedBlocks;
import com.reactioncraft.ore.common.*;
import com.reactioncraft.ore.common.world.*;

public class worldgen implements IWorldGenerator 
{
	private static final IBlockState Ore = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE,  EnumSores.two2);//Ventinite
	private static final IBlockState Ore1 = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE, EnumSores.two3);//Silver 

	//Desert Blocks
	private static final IBlockState Ore2 = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE, EnumSores.one1);//Desert Coal
	private static final IBlockState Ore3 = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE, EnumSores.one2);//Dark Blue Gem
	private static final IBlockState Ore4 = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE, EnumSores.one3);//Light Blue Gem
	private static final IBlockState Ore5 = IntegratedBlocks.DesertBlocks.getDefaultState().withProperty(BlockDesertMulti.TYPE, EnumDesertBlocks.two1);//Granite
	private static final IBlockState Ore6 = IntegratedBlocks.surfaceOres.getDefaultState().withProperty(BlockSOMulti.TYPE, EnumSores.two1);//Desert Gold
	
	//Nether Blocks
	private static final IBlockState Ore7 = IntegratedBlocks.netherOres.getDefaultState() .withProperty(BlockNOMulti.TYPE, EnumNores.two2);//Bloodstone
	private static final IBlockState Ore8 = IntegratedBlocks.netherOres.getDefaultState() .withProperty(BlockNOMulti.TYPE, EnumNores.one1);//Black Diamond
	private static final IBlockState Ore9 = IntegratedBlocks.netherOres.getDefaultState() .withProperty(BlockNOMulti.TYPE, EnumNores.one2);//Diamond
	private static final IBlockState Ore10 = IntegratedBlocks.netherOres.getDefaultState().withProperty(BlockNOMulti.TYPE, EnumNores.one3);//Dragonstone
	private static final IBlockState Ore11 = IntegratedBlocks.netherOres.getDefaultState().withProperty(BlockNOMulti.TYPE, EnumNores.two1);//Gold Ore
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		if (world.provider.getDimension() == 0) 
		{ // the overworld
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		if (world.provider.getDimension() == -1) 
		{ // the Nether
			generateNether(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}

	private void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		generateBloodstone  (Ore7,  world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(125), 6);
		generateBlackdiamond(Ore8,  world, random, chunkX * 16, chunkZ * 16, 16, 64, 1 + random.nextInt(4), 6);
		generateDiamond     (Ore9,  world, random, chunkX * 16, chunkZ * 16, 16, 64, 1 + random.nextInt(3), 6);
		generateDragonstone (Ore10, world, random, chunkX * 16, chunkZ * 16, 16, 64, 2 + random.nextInt(10), 6);
		generateGold        (Ore11, world, random, chunkX * 16, chunkZ * 16, 16, 64, 1 + random.nextInt(5), 6);
	}
	
	private void generateGold(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate
			ReactionNetherGenMinable generator = new ReactionNetherGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore + " at " + pos);
		}
	}
	
	private void generateDragonstone(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate 
			ReactionNetherGenMinable generator = new ReactionNetherGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore10 + " at " + pos);
		}
	}
	
	private void generateBlackdiamond(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate
			ReactionNetherGenMinable generator = new ReactionNetherGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore9 + " at " + pos);
		}
	}
	
	private void generateDiamond(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate 
			ReactionNetherGenMinable generator = new ReactionNetherGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore8 + " at " + pos);
		}
	}
	
	private void generateBloodstone(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate Bloodstone
			BloodstoneGenMinable  generator = new BloodstoneGenMinable (ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore7 + " at " + pos);
		}
	}

	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		//Regular Stone Ores
		generateVentinite(Ore,  world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6);
		generateSilver   (Ore1  ,  world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(4), 6);
		
		//Desert Biome Generation
		generateDesertCoal   (Ore2, world, random, chunkX * 16, chunkZ * 16, 16, 64, 4 + random.nextInt(7),  6);
		generateDesertGem1   (Ore3, world, random, chunkX * 16, chunkZ * 16, 16, 64, 1 + random.nextInt(6),  6);
		generateDesertGem2   (Ore4, world, random, chunkX * 16, chunkZ * 16, 16, 64, 1 + random.nextInt(6),  6);
		generateDesertGranite(Ore5, world, random, chunkX * 16, chunkZ * 16, 16, 64, 1 + random.nextInt(10), 6);
		generateDesertGold   (Ore6, world, random, chunkX * 16, chunkZ * 16, 16, 64, 1 + random.nextInt(7),  6);
	}

	private void generateDesertGold(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate Gems 2
			ReactionSurfaceGenMinable generator = new ReactionSurfaceGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore6 + " at " + pos);
		}
	}

	private void generateDesertGranite(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate Gems 2
			ReactionSurfaceGenMinable generator = new ReactionSurfaceGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore4 + " at " + pos);
		}
	}

	private void generateDesertGem2(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate Gems 2
			ReactionSurfaceGenMinable generator = new ReactionSurfaceGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore4 + " at " + pos);
		}
	}

	private void generateDesertGem1(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) 
		{
			BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

			//Generate Gems 1
			ReactionSurfaceGenMinable generator = new ReactionSurfaceGenMinable(ore, size);
			generator.generate(world, random, pos);
			//System.out.println("Spawned " + Ore3 + " at " + pos);
		}
	}

	private void generateDesertCoal(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
			int deltaY = maxY - minY;
			for (int i = 0; i < chances; i++) 
			{
				BlockPos pos= new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

				//Generate Desert Coal
				ReactionSurfaceGenMinable generator = new ReactionSurfaceGenMinable(ore, size);
				generator.generate(world, random, pos);
				//System.out.println("Spawned " + Ore2 + " at " + pos);
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