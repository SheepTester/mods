package mymod.worldgen;

import java.util.Random;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MyBigHole extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        while (par1World.isAirBlock(par3, par4, par5) && par4 > 2)
        {
            --par4;
        }
        for(int i =0; i<16; i++){
        	for(int j =0; j<16; j++){
        		for(int k =1; k<100; k++){
        			par1World.setBlock(par3 + i, 0 + k, par5 + j, 0); //air?
        		}
        	}
        }
        for(int i =0; i<16; i++){
        	for(int j =0; j<16; j++){
        		par1World.setBlock(par3 + i, 0, par5 + j, Block.bedrock.blockID); //bedrock
        	}
        }
        return true;
    }
}