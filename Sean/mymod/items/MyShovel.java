package mymod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class MyShovel extends ItemSpade {
    
    private String texturePath = "mymod:";
    
    public MyShovel(int ItemID, EnumToolMaterial material, String textureName)
    {
        super(ItemID, material);
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