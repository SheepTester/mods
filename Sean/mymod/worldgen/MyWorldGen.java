package mymod.worldgen;

import java.util.Random;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MyWorldGen extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        while (par1World.isAirBlock(par3, par4, par5) && par4 > 2)
        {
            --par4;
        }
        par1World.setBlock(par3, par4, par5, Main.MyBlock_4.blockID);
        for(int i =0; i<12; i++){
        	par1World.setBlock(par3, par4 + i, par5, Block.blockDiamond.blockID); //diamond
        }
        for(int i =0; i<55; i++){
        	par1World.setBlock(par3, par4 + i, par5 + 1, Block.blockIron.blockID); //iron
        }
        for(int i =0; i<99; i++){
        	par1World.setBlock(par3 + 1, par4 + i, par5 + 1, Block.coalBlock.blockID); //coal
        }
        for(int i =0; i<13; i++){
        	par1World.setBlock(par3 - 1, par4 + i, par5, Block.blockGold.blockID); //gold
        }
        for(int i =0; i<87; i++){
        	par1World.setBlock(par3, par4 + i, par5 - 1, Block.blockLapis.blockID); //lapis
        }
        for(int i =0; i<70; i++){
        	par1World.setBlock(par3 + 1, par4 + i, par5, Block.blockRedstone.blockID); //redstone
        }
        for(int i =0; i<2; i++){
        	par1World.setBlock(par3 - 1, par4 + i, par5 - 1, Block.blockEmerald.blockID); //emerald
        }
        /**
         *  IC
         * GDR
         * EL
         */
        return true;
    }
}