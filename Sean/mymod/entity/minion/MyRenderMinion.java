package mymod.entity.minion;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MyRenderMinion extends RenderLiving
{
    private static final ResourceLocation MinionTextures = new ResourceLocation("mymod:textures/entity/MyMinion.png");

    public MyRenderMinion(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected ResourceLocation getMinionTextures(MyEntityMinion par1EntityMinion)
    {
        return MinionTextures;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getMinionTextures((MyEntityMinion)par1Entity);
    }
}