package mymod.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class MyWorldGenerator implements IWorldGenerator 
{
 public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
 {
  switch (world.provider.dimensionId)
  {
   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
  }
 }

  

  private void generateSurface(World world, Random random, int blockX, int blockZ) 
 {
	  if (0 + random.nextInt(100) == 22) {
		  int Xcoord1 = blockX + random.nextInt(16);
		  int Ycoord1 = random.nextInt(256);
		  int Zcoord1 = blockZ + random.nextInt(16);
   
		  (new MyWorldGen()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
	  }
	  if (0 + random.nextInt(100) == 22) {
		  int Xcoord1 = blockX + random.nextInt(16);
		  int Ycoord1 = random.nextInt(256);
		  int Zcoord1 = blockZ + random.nextInt(16);
   
		  (new MyBigHole()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
	  }
 }
 
 private void generateNether(World world, Random random, int blockX, int blockZ) 
 {
	 if (0 + random.nextInt(12) == 2) {
		int Xcoord1 = blockX + random.nextInt(16);
  		int Ycoord1 = random.nextInt(256);
  		int Zcoord1 = blockZ + random.nextInt(16);
  
  		(new MyNetherWorldGen()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
	 }
 }

}