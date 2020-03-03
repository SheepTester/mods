package mymod.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MyBiome2 extends BiomeGenBase
{
    public MyBiome2(int par1)
    {
        super(par1);
        
        this.setBiomeName("Wildgrowth");
        
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        
        this.theBiomeDecorator.bigMushroomsPerChunk = 1000;
        this.theBiomeDecorator.treesPerChunk = 1000;
        this.theBiomeDecorator.mushroomsPerChunk = 1000;
        this.theBiomeDecorator.flowersPerChunk = 1000;
        this.theBiomeDecorator.cactiPerChunk = 1000;
        this.theBiomeDecorator.grassPerChunk = 1000;
        this.theBiomeDecorator.waterlilyPerChunk = 1000;
        this.theBiomeDecorator.deadBushPerChunk = 1000;
        this.theBiomeDecorator.sandPerChunk = 1000;
        this.theBiomeDecorator.clayPerChunk = 1000;
        this.theBiomeDecorator.reedsPerChunk = 1000;
        this.theBiomeDecorator.generateLakes = true;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCaveSpider.class, 50, 1, 10));
        
        this.setMinMaxHeight(0.1F, 0.5F);
        this.setTemperatureRainfall(1.5F, 0.0F);
   
    }
/** Adds Huge Trees to your Biome */
        public WorldGenerator getRandomWorldGenForTrees(Random random)
        {
            return (WorldGenerator)
            new WorldGenHugeTrees(false, 1 + random.nextInt(100), 0 + random.nextInt(3), 0 + random.nextInt(3));
            /* Wood/Leaf Metadata: 0=Oak, 1=Spruce, 2=Birch, 3=Jungle Wood */
        }
}