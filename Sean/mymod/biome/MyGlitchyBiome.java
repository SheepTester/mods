package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyGlitchyBiome extends BiomeGenBase
{
    public MyGlitchyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("mymod.biome.myglitchybiome");
        
        this.topBlock = (byte)Main.MyBlock_5.blockID;
        this.fillerBlock = (byte)Main.MyBlock_5.blockID;
        
        this.spawnableCreatureList.add(new SpawnListEntry(EntityEnderPearl.class, 100, 10, 20));
        
        this.setMinMaxHeight(0.1F, 1.1F);
        this.setTemperatureRainfall(0.7F, 0.0F);
   
    }
}