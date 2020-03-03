package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyBiome extends BiomeGenBase
{
    public MyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("Sean");
        
        this.topBlock = (byte)Main.MyBlock_2.blockID;
        this.fillerBlock = (byte)Main.MyBlock_3.blockID;
        
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 30, 4, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 10, 1, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityMagmaCube.class, 10, 1, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGhast.class, 20, 4, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 5, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBlaze.class, 20, 3, 5));
        
        this.setMinMaxHeight(-1.0F, 1.0F);
        this.setTemperatureRainfall(0.7F, 0.0F);
   
    }
}