package mymod.handlers;

import mymod.Main;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.IPickupNotifier;

public class MyPickupHandler implements IPickupNotifier 
{
        @Override
        public void notifyPickup(EntityItem item, EntityPlayer player) 
        {
            if (item.getEntityItem().itemID == Main.MyBlock_1.blockID) {
                player.addStat(Main.MyAchievement_1, 1);
                player.addExperienceLevel(10);
            }
            if (item.getEntityItem().itemID == Main.MyBlock_2.blockID) {
                player.addStat(Main.MyAchievement_3, 1);
                player.addExperienceLevel(10);
            }
            if (item.getEntityItem().itemID == Main.MyBlock_4.blockID) {
                player.addStat(Main.MyAchievement_9, 1);
                player.addExperienceLevel(10);
            }
            if (item.getEntityItem().itemID == Main.MyBlock_8.blockID) {
                player.addStat(Main.MyAchievement_15, 1);
                player.addExperienceLevel(10);
            }
        }
}