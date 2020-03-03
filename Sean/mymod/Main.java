package mymod;

import java.awt.Color;

import mymod.armor.MyArmor;
import mymod.armor.MyDarkArmor;
import mymod.biome.MyBiome;
import mymod.biome.MyBiome2;
import mymod.biome.MyGlitchyBiome;
import mymod.blocks.MyBlock;
import mymod.blocks.MyBlockGen;
import mymod.blocks.MyBlockGen2;
import mymod.entity.creeper.MyEntityCreeper;
import mymod.entity.creeper.MyRenderCreeper;
import mymod.entity.fourm.MyEntityFourm;
import mymod.entity.fourm.MyModelFourm;
import mymod.entity.fourm.MyRenderFourm;
import mymod.entity.ghast.MyEntityGhast;
import mymod.entity.ghast.MyRenderGhast;
import mymod.entity.lavaslime.MyEntityLavaSlime;
import mymod.entity.lavaslime.MyModelLavaSlime;
import mymod.entity.lavaslime.MyRenderLavaSlime;
import mymod.entity.minion.MyEntityMinion;
import mymod.entity.minion.MyModelMinion;
import mymod.entity.minion.MyRenderMinion;
import mymod.entity.slime.MyEntitySlime;
import mymod.entity.slime.MyModelSlime;
import mymod.entity.slime.MyRenderSlime;
import mymod.entity.wraith.MyEntityWraith;
import mymod.entity.wraith.MyModelWraith;
import mymod.entity.wraith.MyRenderWraith;
import mymod.handlers.MyCraftingHandler;
import mymod.handlers.MyPickupHandler;
import mymod.items.MyAxe;
import mymod.items.MyFood;
import mymod.items.MyItem;
import mymod.items.MyItem5;
import mymod.items.MyPickaxe;
import mymod.items.MyShovel;
import mymod.items.MySword;
import mymod.items.MySword3;
import mymod.items.MySword4;
import mymod.projectiles.MyEntityProjectile;
import mymod.projectiles.MyProjectile;
import mymod.projectiles.MyRenderProjectile;
import mymod.proxies.CommonProxy;
import mymod.worldgen.MyNetherWorldGen;
import mymod.worldgen.MyWorldGen;
import mymod.worldgen.MyWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


/* 	MOD INFO */
    @Mod( modid = "mymod", name = "Sean's Mod", version = "2.0")
    @NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
    @SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
    public static CommonProxy proxy;


/**	
 * DECLARATION SECTION 
 * *********************************************************** */

//  DECLARE THE SWORD 
        public static Item MySword_1;
        public static Item MySword_2;
        public static Item MySword_3;
        public static Item MySword_4;
        public static Item MySword_5;

//  DECLARE THE PICKAXE 
        public static Item MyPickaxe_1;
        public static Item MyPickaxe_2;

//  DECLARE THE SHOVEL
        public static Item MyShovel_1;
        public static Item MyShovel_2;

//  DECLARE THE AXE
        public static Item MyAxe_1;
        public static Item MyAxe_2;

//  DECLARE THE ITEM
        public static Item MyItem_1;
        public static Item MyItem_2;
        public static Item MyItem_3;
        public static Item MyItem_4;
        public static Item MyItem_5;
        public static Item MyItem_6;
        public static Item MyPoop;
        public static Item MySoulium;

//  DECLARE THE EXPLODING PROJECTILE
        public static Item MyProjectile_1;

//  DECLARE THE FOOD
        public static Item MyFood_1; //cheerio
        public static Item MyFood_2; //chocolate
        public static Item Jelly; //Jelly

//  DECLARE THE BLOCK
        public static Block MyBlock_1;
        public static Block MyBlock_2;
        public static Block MyBlock_3;
        public static Block MyBlock_4;
        public static Block MyBlock_5;
        // public static Block MyBlock_6;
        public static Block MyBlock_7;
        public static Block MyBlock_8;
        public static Block MyPooPile;
        public static Block MySouliumBlock;

//  DECLARE THE ARMOR
        public static Item MyHelmet_1;
        public static Item MyChest_1;
        public static Item MyLeggings_1;
        public static Item MyBoots_1;

//  DECLARE THE DARK ARMOR
        public static Item MyHelmet_2;
        public static Item MyChest_2;
        public static Item MyLeggings_2;
        public static Item MyBoots_2;

//  DECLARE THE ARMOR MATERIAL
        									/** maxDamageFactor, damageReductionAmountArray, enchantability */
        public static EnumArmorMaterial MyArmorMaterial_1 = EnumHelper.addArmorMaterial("Redstone", 15, new int[]{2, 6, 5, 2}, 222);
        public static EnumArmorMaterial MyArmorMaterial_2 = EnumHelper.addArmorMaterial("Dark", 100, new int[]{2, 8, 8, 2}, 2222);

//  DECLARE THE BIOME
        public static  BiomeGenBase MyBiome_1; // Sean
        public static  BiomeGenBase MyBiome_2; // Wildgrowth
        public static  BiomeGenBase MyGlitchyBiome; //Glitched

//  DECLARE THE MOB ID
        static int MyEntityID = 300;

//  SEARCH FOR UNIQUE ID    
        public static int getUniqueEntityId() {
            do {
                MyEntityID++;
            }
            while (EntityList.getStringFromID(MyEntityID) != null);
            return MyEntityID++;
        }

//  DECLARE A NEW EGG
        public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
            int id = getUniqueEntityId();
            EntityList.IDtoClassMapping.put(id, entity);
            EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
        }

//  DECLARE NEW TOOL MATERIAL
        public static EnumToolMaterial MyToolMaterial = EnumHelper.addToolMaterial("Sean", 3, 22222, 222F, 2222F, 222);
        public static EnumToolMaterial MyToolMaterial2 = EnumHelper.addToolMaterial("Dirt", 0, 1, 0.1F, -3.9F, 0);

//	DECLARE A NEW ACHIEVEMENT	
    	public static Achievement MyAchievement_1;
    	public static Achievement MyAchievement_2;
    	public static Achievement MyAchievement_3;
    	public static Achievement MyAchievement_4;
    	public static Achievement MyAchievement_5;
    	public static Achievement MyAchievement_6;
    	public static Achievement MyAchievement_7;
    	public static Achievement MyAchievement_8;
    	public static Achievement MyAchievement_9;
    	public static Achievement MyAchievement_10;
    	public static Achievement MyAchievement_11;
    	public static Achievement MyAchievement_12;
    	public static Achievement MyAchievement_13;
    	public static Achievement MyAchievement_14;
    	public static Achievement MyAchievement_15;
    	public static Achievement MyAchievement_16;
    	public static Achievement MyAchievement_17;
    	public static Achievement MyAchievement_18;
    	public static Achievement MyAchievement_19;
    	public static Achievement MyAchievement_20;

//  DECLARE A NEW CREATIVE TAB  
        public static CreativeTabs MyCreativeTab_1;
        public static CreativeTabs MyCreativeTab_2;

//  DECLARE A NEW WORLD GEN?
        public static WorldGenerator MyWorldGen_1;
        public static WorldGenerator MyNetherWorldGen_1;

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
    public  void preInit( FMLPreInitializationEvent event ) 
    {
/**	
 * LOAD SECTION 
 * *********************************************************** */ 

//  LOAD THE CREATIVE TAB
        MyCreativeTab_1 = new CreativeTabs("MyCreativeTab_1") {
            public ItemStack getIconItemStack() {
                return new ItemStack(MyItem_1, 1, 0);   // Icon, Stack Size, Tab Position
            }
        };
        MyCreativeTab_2 = new CreativeTabs("MyCreativeTab_2") {
            public ItemStack getIconItemStack() {
                return new ItemStack(MyItem_4, 1, 1);   // Icon, Stack Size, Tab Position
            }
        };

//  LOAD THE SWORD
        MySword_1 = new MySword(2021, MyToolMaterial2, "MySword_1").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MySword_1, "MySword_1");
        LanguageRegistry.addName(MySword_1, "Dirt Sword");

        MySword_2 = new MySword(2022, MyToolMaterial, "MySword_2").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MySword_2, "MySword_2");
        LanguageRegistry.addName(MySword_2, "Senite Sword");

        MySword_3 = new MySword(2023, EnumToolMaterial.IRON, "MySword_3").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MySword_3, "MySword_3");
        LanguageRegistry.addName(MySword_3, "Redstone Sword");

        MySword_4 = new MySword4(2024, EnumToolMaterial.EMERALD, "MySword_4").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MySword_4, "MySword_4");
        LanguageRegistry.addName(MySword_4, "Lightning Sword");

        MySword_5 = new MySword3(2025, EnumToolMaterial.EMERALD, "MySword_5").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MySword_5, "MySword_5");
        LanguageRegistry.addName(MySword_5, "TNT Sword");

//  LOAD THE PICKAXE
        MyPickaxe_1 = new MyPickaxe(2026, MyToolMaterial, "MyPickaxe_1").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyPickaxe_1, "MyPickaxe_1");
        LanguageRegistry.addName(MyPickaxe_1, "Senite Pickaxe");

        MyPickaxe_2 = new MyPickaxe(2027, MyToolMaterial2, "MyPickaxe_2").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyPickaxe_2, "MyPickaxe_2");
        LanguageRegistry.addName(MyPickaxe_2, "Dirt Pickaxe");
    
//  LOAD THE SHOVEL
        MyShovel_1 = new MyShovel(2028, MyToolMaterial, "MyShovel_1").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyShovel_1, "MyShovel_1");
        LanguageRegistry.addName(MyShovel_1, "Senite Shovel");

        MyShovel_2 = new MyShovel(2037, MyToolMaterial2, "MyShovel_2").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyShovel_2, "MyShovel_2");
        LanguageRegistry.addName(MyShovel_2, "Dirt Shovel");

//  LOAD THE AXE
        MyAxe_1 = new MyAxe(2029, MyToolMaterial, "MyAxe_1").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyAxe_1, "MyAxe_1");
        LanguageRegistry.addName(MyAxe_1, "Senite Axe");

        MyAxe_2 = new MyAxe(2038, MyToolMaterial2, "MyAxe_2").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyAxe_2, "MyAxe_2");
        LanguageRegistry.addName(MyAxe_2, "Dirt Axe");

//  LOAD THE ITEM
        MyItem_1 = new MyItem(2030, "MyItem_1").setCreativeTab(MyCreativeTab_1).setMaxStackSize(63);
        GameRegistry.registerItem(MyItem_1, "MyItem_1");
        LanguageRegistry.addName(MyItem_1, "Senite Gem");

        MyItem_2 = new MyItem(2031, "MyItem_2").setCreativeTab(MyCreativeTab_1).setMaxStackSize(63);
        GameRegistry.registerItem(MyItem_2, "MyItem_2");
        LanguageRegistry.addName(MyItem_2, "Senite Rod");

        MyItem_3 = new MyItem(2032, "MyItem_3").setCreativeTab(MyCreativeTab_1).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_3, "MyItem_3");
        LanguageRegistry.addName(MyItem_3, "Dirt Item");

        MyItem_4 = new MyItem(2033, "MyItem_4").setCreativeTab(MyCreativeTab_1).setMaxStackSize(99);
        GameRegistry.registerItem(MyItem_4, "MyItem_4");
        LanguageRegistry.addName(MyItem_4, "Dust");
        
        MyItem_5 = new MyItem5(2034, "MyItem_5").setCreativeTab(MyCreativeTab_1).setMaxStackSize(66);
        GameRegistry.registerItem(MyItem_5, "MyItem_5");
        LanguageRegistry.addName(MyItem_5, "Soul");
        
        MyPoop = new MyItem(2039, "MyPoop").setCreativeTab(MyCreativeTab_1).setMaxStackSize(78);
        GameRegistry.registerItem(MyPoop, "MyPoop");
        LanguageRegistry.addName(MyPoop, "Poop");
        
        MySoulium = new MyItem(2043, "MySoulium").setCreativeTab(MyCreativeTab_1).setMaxStackSize(66);
        GameRegistry.registerItem(MySoulium, "MySoulium");
        LanguageRegistry.addName(MySoulium, "Soulium Ingot");

//  LOAD THE PROJECTILE ITEM 
        MyProjectile_1 = new MyProjectile(2035, "MyProjectile_1").setCreativeTab(MyCreativeTab_1).setMaxStackSize(16);
        GameRegistry.registerItem(MyProjectile_1, "MyProjectile_1");
        LanguageRegistry.addName(MyProjectile_1, "Throwable TNT");

        MyItem_6 = new MyItem(2036, "MyItem_6").setCreativeTab(MyCreativeTab_1).setMaxStackSize(64);
        GameRegistry.registerItem(MyItem_6, "MyItem_6");
        LanguageRegistry.addName(MyItem_6, "Shadow of Darkness");

//  REGISTER THE PROJECTILE ENTITY
         EntityRegistry.registerGlobalEntityID(MyEntityProjectile.class, "MyProjectile_1", 1);
         EntityRegistry.registerModEntity(MyEntityProjectile.class, "MyProjectile_1", 1, this, 256, 1, true);
         LanguageRegistry.instance().addStringLocalization("entity.modid.MyProjectile_1.name", "My Awesome Projectile");
         RenderingRegistry.registerEntityRenderingHandler(MyEntityProjectile.class, new MyRenderProjectile(MyProjectile_1));

//  LOAD THE FOOD
        /** itemID, healAmount, saturationModifier (F), isWolfsFavoriteMeat, Texture Name */
        MyFood_1 = new MyFood(2040, 1, 22.0F, false, "MyFood_1").setAlwaysEdible().setPotionEffect(Potion.nightVision.id, 100, 10, 1.0F).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyFood_1, "MyFood_1");
        LanguageRegistry.addName(MyFood_1, "Cheerio"); //cheerio

        MyFood_2 = new MyFood(2041, 4, 0.5F, false, "MyFood_2").setAlwaysEdible().setPotionEffect(Potion.moveSpeed.id, 20, 10, 1.0F).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyFood_2, "MyFood_2");
        LanguageRegistry.addName(MyFood_2, "Chocolate Bar"); //chocolate

        Jelly = new MyFood(2042, 2, 2.0F, true, "Jelly").setPotionEffect(Potion.jump.id, 20, 10, 1.0F).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(Jelly, "Jelly");
        LanguageRegistry.addName(Jelly, "Jelly"); //Jelly

//  LOAD THE BLOCK 
        MyBlock_1 = new MyBlock(250, Material.rock, "MyBlock_1").setLightValue(1.0F).setResistance(2.0F).setHardness(0.0F).setStepSound(Block.soundClothFootstep).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MyBlock_1, "MyBlock_1");
        LanguageRegistry.addName(MyBlock_1, "Senite Gem Ore"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_1, "pickaxe", 2);

		MyBlock_2 = new MyBlock(251, Material.rock, "MyBlock_2").setLightValue(1.0F).setResistance(2222.0F).setHardness(0.0F).setStepSound(Block.soundWoodFootstep).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MyBlock_2, "MyBlock_2");
        LanguageRegistry.addName(MyBlock_2, "Senite Rod Core"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_2, "pickaxe", 2);

		MyBlock_3 = new MyBlock(252, Material.rock, "MyBlock_3").setLightValue(1.0F).setResistance(2222.0F).setHardness(0.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MyBlock_3, "MyBlock_3");
        LanguageRegistry.addName(MyBlock_3, "Senite Gem Block"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_3, "pickaxe", 2);

		MyBlock_4 = new MyBlock(253, Material.rock, "MyBlock_4").setLightValue(2.0F).setResistance(2.0F).setHardness(2.0F).setStepSound(Block.soundMetalFootstep).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MyBlock_4, "MyBlock_4");
        LanguageRegistry.addName(MyBlock_4, "Color Block"); 
		MinecraftForge.setBlockHarvestLevel(MyBlock_4, "pickaxe", 0);

		MyBlock_5 = new MyBlock(254, Material.rock, "MyBlock_5").setLightValue(0.0F).setResistance(0.0F).setHardness(0.0F).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MyBlock_5, "MyBlock_5");
        LanguageRegistry.addName(MyBlock_5, "mymod.main.MyBlock_5");

		MyBlock_7 = new MyBlock(255, Material.rock, "MyBlock_7").setLightValue(1.0F).setResistance(2.0F).setHardness(1.0F).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MyBlock_7, "MyBlock_7");
        LanguageRegistry.addName(MyBlock_7, "Color Block Core");

		MyBlock_8 = new MyBlock(249, Material.rock, "MyBlock_8").setLightValue(1.0F).setResistance(2.0F).setHardness(0.0F).setStepSound(Block.soundClothFootstep).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MyBlock_8, "MyBlock_8");
        LanguageRegistry.addName(MyBlock_8, "Senite Rod Ore");
		MinecraftForge.setBlockHarvestLevel(MyBlock_8, "pickaxe", 2);

		MyPooPile = new mymod.blocks.MyPooPile(248, Material.clay, "MyPooPile").setLightValue(0.0F).setResistance(1.0F).setHardness(1.0F).setStepSound(Block.soundSnowFootstep).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MyPooPile, "MyPooPile");
        LanguageRegistry.addName(MyPooPile, "Pile of Poo");
		MinecraftForge.setBlockHarvestLevel(MyPooPile, "shovel", 0);

		MySouliumBlock = new MyBlock(247, Material.iron, "MySouliumBlock").setLightValue(1.0F).setResistance(2000.0F).setHardness(5.0F).setStepSound(Block.soundPowderFootstep).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(MySouliumBlock, "MySouliumBlock");
        LanguageRegistry.addName(MySouliumBlock, "Soulium Block");
		MinecraftForge.setBlockHarvestLevel(MySouliumBlock, "pickaxe", 3);

		/** MyBlock_6 = new MyBlock(249, Material.ground, "MyBlock_6").setLightValue(0.0F).setResistance(5.0F).setHardness(1.0F).setCreativeTab(MyCreativeTab_1).setStepSound(Block.soundSandFootstep);
        GameRegistry.registerBlock(MyBlock_6, "MyBlock_6");
        LanguageRegistry.addName(MyBlock_6, "Chatty Block"); */

//  LOAD HELMET 
        MyHelmet_1 = new MyArmor(2060, MyArmorMaterial_1, 0, 0, "myarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyHelmet_1, "MyHelmet_1");
        LanguageRegistry.addName(MyHelmet_1, "Redstone Helmet");      

//  LOAD CHESTPLATE
        MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyChest_1, "MyChest_1");
        LanguageRegistry.addName(MyChest_1, "Redstone Chestplate");

//  LOAD LEGGINGS    
        MyLeggings_1 = new MyArmor(2062, MyArmorMaterial_1, 0, 2, "myarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyLeggings_1, "MyLeggings_1");
        LanguageRegistry.addName(MyLeggings_1, "Redstone Leggings");

//  LOAD BOOTS   
        MyBoots_1 = new MyArmor(2063, MyArmorMaterial_1, 0, 3, "myarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyBoots_1, "MyBoots_1");
        LanguageRegistry.addName(MyBoots_1, "Redstone Boots");

//  LOAD DARK HELMET 
        MyHelmet_2 = new MyDarkArmor(2064, MyArmorMaterial_2, 0, 0, "mydarkarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyHelmet_2, "MyHelmet_2");
        LanguageRegistry.addName(MyHelmet_2, "Mask of Darkness");      

//  LOAD DARK CHESTPLATE
        MyChest_2 = new MyDarkArmor(2065, MyArmorMaterial_2, 0, 1, "mydarkarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyChest_2, "MyChest_2");
        LanguageRegistry.addName(MyChest_2, "Chestplate of Darkness");

//  LOAD DARK LEGGINGS    
        MyLeggings_2 = new MyDarkArmor(2066, MyArmorMaterial_2, 0, 2, "mydarkarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyLeggings_2, "MyLeggings_2");
        LanguageRegistry.addName(MyLeggings_2, "Leggings of Darkness");

//  LOAD DARK BOOTS   
        MyBoots_2 = new MyDarkArmor(2067, MyArmorMaterial_2, 0, 3, "mydarkarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyBoots_2, "MyBoots_2");
        LanguageRegistry.addName(MyBoots_2, "Shoes of Darkness");

//  LOAD BIOME
        MyBiome_1 = new MyBiome(30);
        GameRegistry.addBiome(MyBiome_1); // Sean

        MyBiome_2 = new MyBiome2(31);
        GameRegistry.addBiome(MyBiome_2); // Wildgrowth

        MyGlitchyBiome = new MyGlitchyBiome(32);
        GameRegistry.addBiome(MyGlitchyBiome); // Glitched

//  REMOVE OTHER BIOMES
/**
        GameRegistry.removeBiome(BiomeGenBase.beach);
        GameRegistry.removeBiome(BiomeGenBase.desert);
        GameRegistry.removeBiome(BiomeGenBase.desertHills);
        GameRegistry.removeBiome(BiomeGenBase.desertHills);
        GameRegistry.removeBiome(BiomeGenBase.extremeHills);
        GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
        GameRegistry.removeBiome(BiomeGenBase.forest);
        GameRegistry.removeBiome(BiomeGenBase.forestHills);
        GameRegistry.removeBiome(BiomeGenBase.frozenOcean);
        GameRegistry.removeBiome(BiomeGenBase.frozenRiver);
        GameRegistry.removeBiome(BiomeGenBase.iceMountains);
        GameRegistry.removeBiome(BiomeGenBase.icePlains);
        GameRegistry.removeBiome(BiomeGenBase.jungle);
        GameRegistry.removeBiome(BiomeGenBase.jungleHills);
        GameRegistry.removeBiome(BiomeGenBase.mushroomIsland);
        GameRegistry.removeBiome(BiomeGenBase.ocean);
        GameRegistry.removeBiome(BiomeGenBase.plains);
        GameRegistry.removeBiome(BiomeGenBase.river);
        GameRegistry.removeBiome(BiomeGenBase.swampland);
        GameRegistry.removeBiome(BiomeGenBase.taiga);
        GameRegistry.removeBiome(BiomeGenBase.taigaHills);
        */

//  REGISTER YOUR GHAST
        EntityRegistry.registerGlobalEntityID(MyEntityGhast.class, "Senite Ghast", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityGhast.class, 50, 1, 5, EnumCreatureType.monster, BiomeGenBase.jungle);
        EntityRegistry.addSpawn(MyEntityGhast.class, 50, 1, 5, EnumCreatureType.monster, BiomeGenBase.jungleHills);
        EntityRegistry.addSpawn(MyEntityGhast.class, 50, 1, 5, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(MyEntityGhast.class, 222, 1, 5, EnumCreatureType.monster, MyBiome_1);     
        registerEntityEgg(MyEntityGhast.class, (new Color(0, 255, 255)).getRGB(), (new Color(255, 255, 0)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityGhast.class, new MyRenderGhast());
        ModLoader.addLocalization("entity.Senite Ghast.name", "Senite Ghast");

//  REGISTER YOUR CREEPER
        EntityRegistry.registerGlobalEntityID(MyEntityCreeper.class, "mymod.entity.creeper", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityCreeper.class, 200, 1, 5, EnumCreatureType.monster, MyGlitchyBiome);     
        EntityRegistry.addSpawn(MyEntityCreeper.class, 20, 1, 5, EnumCreatureType.monster, BiomeGenBase.extremeHills); 
        EntityRegistry.addSpawn(MyEntityCreeper.class, 20, 1, 5, EnumCreatureType.monster, BiomeGenBase.ocean);
        EntityRegistry.addSpawn(MyEntityCreeper.class, 20, 1, 5, EnumCreatureType.monster, BiomeGenBase.river);
        EntityRegistry.addSpawn(MyEntityCreeper.class, 20, 1, 5, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.addSpawn(MyEntityCreeper.class, 20, 1, 5, EnumCreatureType.monster, BiomeGenBase.hell);
        registerEntityEgg(MyEntityCreeper.class, (new Color(255, 0, 255)).getRGB(), (new Color(0, 0, 0)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityCreeper.class, new MyRenderCreeper());
        ModLoader.addLocalization("entity.mymod.entity.creeper.name", "mymod.entity.creeper");

//  REGISTER YOUR WRAITH
        EntityRegistry.registerGlobalEntityID(MyEntityWraith.class, "Ghost", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityWraith.class, 200, 2, 6, EnumCreatureType.creature, BiomeGenBase.hell);
        EntityRegistry.addSpawn(MyEntityWraith.class, 50, 1, 3, EnumCreatureType.creature, BiomeGenBase.desert);
        EntityRegistry.addSpawn(MyEntityWraith.class, 25, 1, 5, EnumCreatureType.creature, BiomeGenBase.sky);
        EntityRegistry.addSpawn(MyEntityWraith.class, 50, 1, 3, EnumCreatureType.creature, BiomeGenBase.icePlains);
        EntityRegistry.addSpawn(MyEntityWraith.class, 50, 1, 3, EnumCreatureType.creature, BiomeGenBase.iceMountains);
        EntityRegistry.addSpawn(MyEntityWraith.class, 100, 1, 10, EnumCreatureType.creature, MyBiome_1);
        registerEntityEgg(MyEntityWraith.class, (new Color(255, 255, 255)).getRGB(), (new Color(200, 200, 200)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityWraith.class, new MyRenderWraith(new MyModelWraith(), 0.3F));
        ModLoader.addLocalization("entity.Ghost.name", "Ghost");

//  REGISTER YOUR FOURM
        EntityRegistry.registerGlobalEntityID(MyEntityFourm.class, "AutoKiller", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityFourm.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
        EntityRegistry.addSpawn(MyEntityFourm.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.sky);
        EntityRegistry.addSpawn(MyEntityFourm.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.ocean);
        EntityRegistry.addSpawn(MyEntityFourm.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.plains);
        EntityRegistry.addSpawn(MyEntityFourm.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.desert);
        EntityRegistry.addSpawn(MyEntityFourm.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.beach);
        EntityRegistry.addSpawn(MyEntityFourm.class, 15, 1, 1, EnumCreatureType.monster, BiomeGenBase.extremeHills);
        EntityRegistry.addSpawn(MyEntityFourm.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.forest);
        EntityRegistry.addSpawn(MyEntityFourm.class, 5, 1, 1, EnumCreatureType.monster, BiomeGenBase.river);
        EntityRegistry.addSpawn(MyEntityFourm.class, 100, 1, 1, EnumCreatureType.monster, MyBiome_1);
        registerEntityEgg(MyEntityFourm.class, (new Color(234, 87, 63)).getRGB(), (new Color(156, 184, 52)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityFourm.class, new MyRenderFourm(new MyModelFourm(), 0.3F));
        ModLoader.addLocalization("entity.AutoKiller.name", "AutoKiller");

//  REGISTER YOUR SLIME
        EntityRegistry.registerGlobalEntityID(MyEntitySlime.class, "Jellycube", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntitySlime.class, 50, 1, 5, EnumCreatureType.monster, BiomeGenBase.jungle);
        registerEntityEgg(MyEntitySlime.class, (new Color(250, 70, 230)).getRGB(), (new Color(250, 160, 240)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntitySlime.class, new MyRenderSlime(new MyModelSlime(16), new MyModelSlime(0), 0.25F));
        ModLoader.addLocalization("entity.Jellycube.name", "Jellycube");
        // RenderingRegistry.registerEntityRenderingHandler(MyEntityCreeper.class, new MyRenderCreeper());
        // ModLoader.addLocalization("entity.NAME.name", "NAME");
        
//  REGISTER YOUR LAVASLIME
        EntityRegistry.registerGlobalEntityID(MyEntityLavaSlime.class, "the Poopy Thing", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntitySlime.class, 50, 1, 5, EnumCreatureType.creature, BiomeGenBase.jungle);
        registerEntityEgg(MyEntityLavaSlime.class, (new Color(140, 80, 0)).getRGB(), (new Color(50, 30, 0)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityLavaSlime.class, new MyRenderLavaSlime(new MyModelLavaSlime(), new MyModelLavaSlime(), 0.25F));
        ModLoader.addLocalization("entity.the Poopy Thing.name", "the Poopy Thing");
 

//  REGISTER YOUR ENTITY
        EntityRegistry.registerGlobalEntityID(MyEntityMinion.class, "Dirt Thing", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.addSpawn(MyEntityMinion.class, 50, 1, 5, EnumCreatureType.creature, BiomeGenBase.desert);     
        EntityRegistry.addSpawn(MyEntityMinion.class, 50, 1, 5, EnumCreatureType.monster, MyBiome_1);  
        registerEntityEgg(MyEntityMinion.class, (new Color(121, 85, 58)).getRGB(), (new Color(185, 133, 92)).getRGB());
        RenderingRegistry.registerEntityRenderingHandler(MyEntityMinion.class, new MyRenderMinion(new MyModelMinion(), 0.3F));
        ModLoader.addLocalization("entity.Dirt Thing.name", "Dirt Thing");

//	LOAD THE ACHIEVEMENTS
		MyAchievement_1 = new Achievement(2001, "MyAchievement_1", -2, 2, MyBlock_1, AchievementList.acquireIron).registerAchievement();
		MyAchievement_2 = new Achievement(2002, "MyAchievement_2", -2, 1, MyItem_1, MyAchievement_1).registerAchievement();
		MyAchievement_3 = new Achievement(2003, "MyAchievement_3", 1, 6, MyBlock_2, AchievementList.acquireIron).registerAchievement();
		MyAchievement_4 = new Achievement(2004, "MyAchievement_4", 1, 7, MyItem_2, MyAchievement_3).registerAchievement();
		MyAchievement_5 = new Achievement(2005, "MyAchievement_5", -2, 0, MySword_2, MyAchievement_2).registerAchievement();
		MyAchievement_6 = new Achievement(2006, "MyAchievement_6", -2, -1, MyPickaxe_1, MyAchievement_5).registerAchievement();
		MyAchievement_7 = new Achievement(2007, "MyAchievement_7", -2, -2, MyBlock_3, MyAchievement_6).registerAchievement();
		MyAchievement_8 = new Achievement(2008, "MyAchievement_8", -2, -3, MyBlock_2, MyAchievement_7).registerAchievement();
		MyAchievement_9 = new Achievement(2009, "MyAchievement_9", -2, -4, MyBlock_4, MyAchievement_8).setSpecial().registerAchievement();
		MyAchievement_10 = new Achievement(2010, "MyAchievement_10", -1, -4, MyFood_1, AchievementList.makeBread).registerAchievement();
		MyAchievement_11 = new Achievement(2011, "MyAchievement_11", -1, -5, MyFood_2, MyAchievement_10).registerAchievement();
		MyAchievement_12 = new Achievement(2012, "MyAchievement_12", 0, -1, MyItem_3, AchievementList.openInventory).registerAchievement();
		MyAchievement_13 = new Achievement(2013, "MyAchievement_13", 0, -2, MyPickaxe_2, MyAchievement_12).registerAchievement();
		MyAchievement_14 = new Achievement(2014, "MyAchievement_14", -1, -2, MySword_1, MyAchievement_13).registerAchievement();
		MyAchievement_15 = new Achievement(2015, "MyAchievement_15", -2, 7, MyBlock_8, AchievementList.portal).registerAchievement();
		MyAchievement_16 = new Achievement(2016, "MyAchievement_16", -3, 7, MyItem_2, MyAchievement_15).registerAchievement();
		MyAchievement_17 = new Achievement(2017, "MyAchievement_17", -3, 0, MyAxe_1, MyAchievement_5).registerAchievement();
		MyAchievement_18 = new Achievement(2018, "MyAchievement_18", -1, 0, MyShovel_1, MyAchievement_5).registerAchievement();
		MyAchievement_19 = new Achievement(2019, "MyAchievement_19", 1, -2, MyAxe_2, MyAchievement_13).registerAchievement();
		MyAchievement_20 = new Achievement(2020, "MyAchievement_20", -1, -1, MyShovel_2, MyAchievement_12).registerAchievement();
		//	(id, "NameOfAchievement", x, y coordinates on Achievement map, icon, Required Achievement to unlock)
		// 	For no Pre-required achievement, use "(Achievement)null"

//  LOAD THE WORLD GEN?
		MyWorldGen_1 = new MyWorldGen();
		MyNetherWorldGen_1 = new MyNetherWorldGen();
/**
 * MyChest_1 = new MyArmor(2061, MyArmorMaterial_1, 0, 1, "myarmor").setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerItem(MyChest_1, "MyChest_1");
        LanguageRegistry.addName(MyChest_1, "Redstone Chestplate");
    
    Ooh this works!
 */

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

    }

@EventHandler
    public static void init( FMLInitializationEvent event ) 
    {

/**	
 * RECIPES SECTION 
 * *********************************************************** */

//  SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(MySword_1, 1), new Object[]
        {
                "XS",
                "SX",
            'X', Block.dirt,
            'S', MyItem_3,
        });

        GameRegistry.addRecipe(new ItemStack(MySword_2, 1), new Object[]
        {
                "X",
                "X",
                "S",
            'X', MyItem_1,
            'S', MyItem_2,
        });

        GameRegistry.addRecipe(new ItemStack(MySword_3, 1), new Object[]
        {
                "XS",
            'X', Item.redstone,
            'S', Item.swordIron,
        });

        GameRegistry.addRecipe(new ItemStack(MySword_4, 1), new Object[]
        {
                "X",
                "X",
                "S",
            'X', Item.fireballCharge,
            'S', Item.blazeRod,
        });

        GameRegistry.addRecipe(new ItemStack(MySword_5, 1), new Object[]
        {
                "X",
                "X",
                "S",
            'X', Block.tnt,
            'S', Item.gunpowder,
        });

//  PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(MyPickaxe_1, 1), new Object[]
        {
                "XXX",
                " S ",
                " S ",
            'S', MyItem_2,
            'X', MyItem_1,
        });

        GameRegistry.addRecipe(new ItemStack(MyPickaxe_2, 1), new Object[]
        {
                "XS",
                "XS",
            'X', Block.dirt,
            'S', MyItem_3,
        });

//  SHOVEL RECIPE
        GameRegistry.addRecipe(new ItemStack(MyShovel_1, 1), new Object[]
        {
                "S",
                "X",
                "X",
            'X', MyItem_2,
            'S', MyItem_1,
        });

        GameRegistry.addRecipe(new ItemStack(MyShovel_2, 1), new Object[]
        {
                "SX",
                "SX",
            'X', Block.dirt,
            'S', MyItem_3,
        });

//  AXE RECIPE
        GameRegistry.addRecipe(new ItemStack(MyAxe_1, 1), new Object[]
        {
                "SS",
                "SX",
                " X",
            'X', MyItem_2,
            'S', MyItem_1,
        });

        GameRegistry.addRecipe(new ItemStack(MyAxe_1, 1), new Object[]
        {
                "SS",
                "XS",
                "X ",
            'X', MyItem_2,
            'S', MyItem_1,
        });

        GameRegistry.addRecipe(new ItemStack(MyAxe_2, 1), new Object[]
        {
                "SX",
                "XS",
            'X', Block.dirt,
            'S', MyItem_3,
        });

//  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(MyItem_1, 9), new Object[]
        {
                "S",
            'S', MyBlock_3,
        });

        GameRegistry.addRecipe(new ItemStack(MyItem_2, 9), new Object[]
        {
                "S",
            'S', MyBlock_2,
        });

        GameRegistry.addRecipe(new ItemStack(MyItem_3, 4), new Object[]
        {
                "SS",
                "SS",
            'S', Block.dirt,
        });

        GameRegistry.addRecipe(new ItemStack(MyItem_4, 1), new Object[]
        {
                "   ",
            'S', Block.dirt,
        });

        GameRegistry.addRecipe(new ItemStack(MyProjectile_1, 4), new Object[]
        {
                "S",
            'S', Block.tnt,
        });

        GameRegistry.addRecipe(new ItemStack(MyPoop, 4), new Object[]
        {
                "SSS",
                "SSS",
                "SSS",
            'S', Item.rottenFlesh,
        });

        GameRegistry.addShapelessRecipe(new ItemStack(MySoulium, 1), new Object[] {Main.MyItem_5,Item.ingotIron});


        GameRegistry.addShapelessRecipe(new ItemStack(MyItem_6, 1), new Object[] {Block.obsidian, new ItemStack(Block.cloth, 1, 15), Block.coalBlock, new ItemStack(Block.stainedClay, 1, 15)});

//  FOOD RECIPE
        GameRegistry.addRecipe(new ItemStack(MyFood_1, 64), new Object[]
        {
                "SXS",
                "X X",
                "SXS",
            'S', Item.wheat,
            'X', Item.bread,
        }); //cheerio

        GameRegistry.addRecipe(new ItemStack(MyFood_2, 4), new Object[]
        {
                "SX",
            'S', new ItemStack(Item.dyePowder, 1, 3),
            'X', Item.sugar,
        }); //chocolate

//  SMELTING RECIPE
        GameRegistry.addSmelting(MyBlock_1.blockID, (new ItemStack(MyItem_1, 2)), 222);
        GameRegistry.addSmelting(MyBlock_8.blockID, (new ItemStack(MyItem_2, 2)), 222);
        GameRegistry.addSmelting(Block.tnt.blockID, (new ItemStack(Block.dirt, 1)), 10);

//  HELMET RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyHelmet_1, 1), new Object[]
    {
            "SX",
        'S', Item.redstone,
        'X', Item.helmetIron,
    });         

//  CHESTPLATE RECIPE   
    GameRegistry.addRecipe(new ItemStack(MyChest_1, 1), new Object[]
    {
            "SX",
        'S', Item.redstone,
        'X', Item.plateIron,
    });         

//  LEGGINGS RECIPE 
    GameRegistry.addRecipe(new ItemStack(MyLeggings_1, 1), new Object[]
    {
            "SX",
        'S', Item.redstone,
        'X', Item.legsIron,
    });         

//  BOOTS RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyBoots_1, 1), new Object[]
    {
            "SX",
        'S', Item.redstone,
        'X', Item.bootsIron,
    });

//  HELMET RECIPE
    GameRegistry.addRecipe(new ItemStack(MyHelmet_2, 1), new Object[]
    {
            "XXX",
            "X X",
        'X', MyItem_6,
    });         

//  CHESTPLATE RECIPE
    GameRegistry.addRecipe(new ItemStack(MyChest_2, 1), new Object[]
    {
            "X X",
            "XXX",
            "XXX",
        'X', MyItem_6,
    });         

//  LEGGINGS RECIPE
    GameRegistry.addRecipe(new ItemStack(MyLeggings_2, 1), new Object[]
    {
            "XXX",
            "X X",
            "X X",
        'X', MyItem_6,
    });         

//  BOOTS RECIPE
    GameRegistry.addRecipe(new ItemStack(MyBoots_2, 1), new Object[]
    {
            "X X",
            "X X",
        'X', MyItem_6,
    });

//  BLOCK RECIPE

    GameRegistry.addRecipe(new ItemStack(MyBlock_2, 1), new Object[]
    {
            "XXX",
            "XXX",
            "XXX",
        'X', MyItem_2,
    });

    GameRegistry.addRecipe(new ItemStack(MyBlock_3, 1), new Object[]
    {
            "XXX",
            "XXX",
            "XXX",
        'X', MyItem_1,
    });

    GameRegistry.addRecipe(new ItemStack(MyBlock_7, 1), new Object[]
    {
            "XXX",
            "XSX",
            "XXX",
        'X', MyItem_2,
        'S', MyBlock_4,
    });

    GameRegistry.addRecipe(new ItemStack(MyPooPile, 1), new Object[]
    {
            "XXX",
            "XXX",
            "XXX",
        'X', MyPoop,
    });

    GameRegistry.addRecipe(new ItemStack(MySouliumBlock, 1), new Object[]
    {
            "XXX",
            "XXX",
            "XXX",
        'X', MySoulium,
    });
    
    GameRegistry.addShapelessRecipe(new ItemStack(Block.slowSand, 1), new Object[] {Main.MyItem_5,Block.sand,Item.bucketWater});
GameRegistry.addShapelessRecipe(new ItemStack(Block.ice, 1), new Object[] {Item.bucketWater});

    
//  GHOST RECIPE    
    GameRegistry.addRecipe(new ItemStack(MyItem_5, 9), new Object[]
    {
            "XXX",
            "XXX",
            "XXX",
        'X', MyItem_5,
    });

//  GHOST RECIPE    
    GameRegistry.addRecipe(new ItemStack(Block.commandBlock, 1), new Object[]
    {
            "XXX",
            "XSX",
            "XXX",
        'X', Block.hardenedClay,
        'S', Block.blockRedstone,
    });

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

//  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new MyBlockGen());
    GameRegistry.registerWorldGenerator(new MyBlockGen2());

//	CHANGE THE TEXT OF THE ACHIEVEMENT	
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_1", "en_US", "One punch wool");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_1.desc", "en_US", "Mine senite gem ore");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_2", "en_US", "Blue and shiny");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_2.desc", "en_US", "Smelt a senite gem");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_3", "en_US", "Yellow circles");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_3.desc", "en_US", "Mine a senite rod core");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_4", "en_US", "Yellow sticks");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_4.desc", "en_US", "Craft a senite rod");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_5", "en_US", "OP Sword");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_5.desc", "en_US", "Craft a senite sword");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_6", "en_US", "OP Pickaxe");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_6.desc", "en_US", "Craft a senite pick");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_7", "en_US", "That blue block");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_7.desc", "en_US", "Craft a sentie gem block");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_8", "en_US", "Back to a yellow circle");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_8.desc", "en_US", "Craft a senite rod core");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_9", "en_US", "Colorful");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_9.desc", "en_US", "Mine a color block or kill an Auto-Killer");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_10", "en_US", "Yummy cereal");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_10.desc", "en_US", "Craft some cheerios");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_11", "en_US", "CHOCOLATE!!!");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_11.desc", "en_US", "Craft some chocolate");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_12", "en_US", "Such a dumb name for a dumb item");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_12.desc", "en_US", "Craft a dirt item");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_13", "en_US", "Why did I make this?");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_13.desc", "en_US", "Craft a dirt pickaxe");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_14", "en_US", "Even worse than your fists");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_14.desc", "en_US", "Craft a dirt sword");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_15", "en_US", "Nether Ore");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_15.desc", "en_US", "Mine senite rod ore");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_16", "en_US", "Yellow rods");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_16.desc", "en_US", "Smelt a senite rod");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_17", "en_US", "Forest deleter");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_17.desc", "en_US", "Craft a senite axe");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_18", "en_US", "Where's the dirt?");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_18.desc", "en_US", "Craft a senite shovel");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_19", "en_US", "Slower than your fists");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_19.desc", "en_US", "Craft a dirt axe");

    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_20", "en_US", "Not used for dirt");
    	LanguageRegistry.instance().addStringLocalization("achievement.MyAchievement_20.desc", "en_US", "Craft a dirt shoevel");

//  REGISTER PICKUP HANDLER
        MyPickupHandler MyPickupHandler_1 = new MyPickupHandler();
        GameRegistry.registerPickupHandler(MyPickupHandler_1);

//  REGISTER CRAFTING HANDLER
        MyCraftingHandler MyCraftingHandler_1 = new MyCraftingHandler();
        GameRegistry.registerCraftingHandler(MyCraftingHandler_1);  

//  CHANGE TAB NAME
        LanguageRegistry.instance().addStringLocalization("itemGroup.MyCreativeTab_1", "en_US", "Sean's Mod");
        LanguageRegistry.instance().addStringLocalization("itemGroup.MyCreativeTab_2", "en_US", "");

//  REGISTER WORLD GEN?
        GameRegistry.registerWorldGenerator(new MyWorldGenerator());
// GameRegistry.registerWorldGenerator(new MyBlockGen());

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


	}

@EventHandler
    public static void postInit( FMLPostInitializationEvent event ) 
    {

    }

}