package mymod.blocks;

import java.util.Random;

import mymod.Main;
import mymod.worldgen.MyNetherWorldGen;
import mymod.worldgen.MyWorldGen;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class MyBlockGen2 implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId)
        {
        	case -1:
            	generateNether(world, random, chunkX*16, chunkZ*16);
            case 0: 
                generateSurface(world, random,chunkX*16,chunkZ*16);
        }
    }



    private void generateSurface(World world, Random random, int BlockX, int BlockZ) {
        for(int i =0; i<100; i++){ 
            int Xcoord = BlockX + random.nextInt(16);
            int Zcoord = BlockZ + random.nextInt(16);
            int Ycoord = random.nextInt(256); 
            (new WorldGenMinable(Main.MyBlock_4.blockID, 1, Block.grass.blockID)).generate(world, random, Xcoord, Ycoord, Zcoord);
        }
    }
    private void generateNether(World world, Random random, int blockX, int blockZ) 
    	{
    		for(int i =0; i<22; i++){
    			int Xcoord = blockX + random.nextInt(16);
    			int Ycoord = random.nextInt(256);
    			int Zcoord = blockZ + random.nextInt(16);
    			(new WorldGenMinable(Main.MyBlock_8.blockID, 64, Block.netherrack.blockID)).generate(world, random, Xcoord, Ycoord, Zcoord);
    			int Xcoord1 = blockX + random.nextInt(16);
    			int Ycoord1 = random.nextInt(256);
    			int Zcoord1 = blockZ + random.nextInt(16);
    			(new WorldGenMinable(Block.waterStill.blockID, 32, Block.lavaStill.blockID)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
    			(new WorldGenMinable(Block.waterMoving.blockID, 32, Block.lavaMoving.blockID)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
    		}

	}
}