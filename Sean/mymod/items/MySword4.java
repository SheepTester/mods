package mymod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class MySword4 extends ItemSword {
    
    private String texturePath = "mymod:";
    
    public MySword4(int ItemID, EnumToolMaterial material, String textureName)
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
/** Adds Lightning Power to your Sword */

    public boolean hitEntity(ItemStack item, EntityLivingBase target, EntityLivingBase player)
    {
        target.worldObj.addWeatherEffect(new EntityLightningBolt(target.worldObj, target.posX, target.posY, target.posZ));
        return true;
    }
/** Makes your Item Enchanted when it is crafted */
        public void onCreated(ItemStack item, World world, EntityPlayer player) 
        {
            item.addEnchantment(Enchantment.fireAspect, 10);
            // Replace the "." after "Enchantment" to see options
            // The number is the Enchantment Level
        }
}