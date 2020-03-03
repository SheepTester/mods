package mymod.handlers;

import mymod.Main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class MyCraftingHandler implements ICraftingHandler 
{

        @Override
        public void onSmelting(EntityPlayer player, ItemStack item) {
        
            if (item.itemID == Main.MyItem_1.itemID)
            {
                player.addStat(Main.MyAchievement_2, 1);
                player.addExperienceLevel(10);
            }
        
            if (item.itemID == Main.MyItem_2.itemID)
            {
                player.addStat(Main.MyAchievement_16, 1);
                player.addExperienceLevel(10);
            }
        
        }
        
        @Override
        public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
            
            if (item.itemID == Main.MyItem_2.itemID)
            {
                player.addStat(Main.MyAchievement_4, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MySword_2.itemID)
            {
                player.addStat(Main.MyAchievement_5, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyPickaxe_1.itemID)
            {
                player.addStat(Main.MyAchievement_6, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyBlock_3.blockID)
            {
                player.addStat(Main.MyAchievement_7, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyBlock_2.blockID)
            {
                player.addStat(Main.MyAchievement_8, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyFood_1.itemID)
            {
                player.addStat(Main.MyAchievement_10, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyFood_2.itemID)
            {
                player.addStat(Main.MyAchievement_11, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyItem_3.itemID)
            {
                player.addStat(Main.MyAchievement_12, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyPickaxe_2.itemID)
            {
                player.addStat(Main.MyAchievement_13, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MySword_1.itemID)
            {
                player.addStat(Main.MyAchievement_14, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyAxe_1.itemID)
            {
                player.addStat(Main.MyAchievement_17, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyShovel_1.itemID)
            {
                player.addStat(Main.MyAchievement_18, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyAxe_2.itemID)
            {
                player.addStat(Main.MyAchievement_19, 1);
                player.addExperienceLevel(10);
            }
            
            if (item.itemID == Main.MyShovel_2.itemID)
            {
                player.addStat(Main.MyAchievement_20, 1);
                player.addExperienceLevel(10);
            }
            
        }

}