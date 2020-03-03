package mymod.worldgen;

import java.util.Random;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MyNetherWorldGen extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        while (par1World.isAirBlock(par3, par4, par5) && par4 > 2)
        {
            --par4;
        }
        for(int j = -3; j<4; j++){
        		for(int k = -2; k<4; k++){
        			par1World.setBlock(par3 + j, par4, par5 + k, Block.lavaMoving.blockID); //lava
        		}
        }
        for(int i =0; i<15; i++){
        	for(int j = -2; j<3; j++){
        		for(int k = -2; k<3; k++){
        			par1World.setBlock(par3 + j, par4 + i, par5 + k, Block.blockNetherQuartz.blockID); //quartz
        		}
        	}
        }
        for(int i =0; i<16; i++){
        	for(int j = -1; j<2; j++){
        		for(int k = -1; k<2; k++){
        			par1World.setBlock(par3 + j, par4 + i, par5 + k, Block.glowStone.blockID); //glowstone
        		}
        	}
        }
        for(int i =0; i<17; i++){
        	par1World.setBlock(par3, par4 + i, par5, Block.netherBrick.blockID); //netherbrick
        }
        par1World.setBlock(par3, par4 + 17, par5, Block.lavaMoving.blockID); //lava
        return true;
    }
}