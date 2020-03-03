package mymod.entity.creeper;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.world.World;

public class MyEntityCreeper extends EntityAnimal
{
    public MyEntityCreeper(World par1World)
    {
        super(par1World);
        this.setSize(0.9F, 1.3F);  
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityageable) {
        return null;
    }

 
}
