package mymod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class MySword3 extends ItemSword {
    
    private String texturePath = "mymod:";
    
    public MySword3(int ItemID, EnumToolMaterial material, String textureName)
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
/** Creates an Explosive lightning bolt that 
* sends the target flying through the air and sets it on fire */
    public boolean hitEntity(ItemStack item, EntityLivingBase target, EntityLivingBase player)
    {
        /** Creates an Explosion */
            target.worldObj.createExplosion(target, target.posX, target.posY, target.posZ, 2.0F, true); // The size of the explosion

        return true;
    }

}