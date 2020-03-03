package mymod;

import mymod.items.MySword;
import mymod.proxies.CommonProxy;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;


/* 	MOD INFO */
	@Mod( modid = "mymod", name = "Alan Mod", version = "1.0")
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


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/* *	
 * LOAD SECTION 
 * *********************************************************** */ 

//  LOAD THE SWORD
        MySword_1 = new MySword(2021, EnumToolMaterial.IRON, "MySword_1");
        GameRegistry.registerItem(MySword_1, "MySword_1");
        LanguageRegistry.addName(MySword_1, "Fireball Sword");

	
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
                "X",
                "X",
                "S",
            'S', Item.blazeRod,
            'X', Item.fireballCharge,
        });
	

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */


        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
