package mymod.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class MyFood extends ItemFood 
{
   
    private String texturePath = "mymod:";
    
    public MyFood(int itemID, int healAmount, Float saturationModifier, boolean isWolfsFavoriteMeat, String textureName) 
    {
        super(itemID, healAmount, saturationModifier, isWolfsFavoriteMeat);
        this.setUnlocalizedName(textureName);
        texturePath += textureName;
    }

@Override
@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }
    
}