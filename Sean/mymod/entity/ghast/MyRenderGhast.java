package mymod.entity.ghast;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MyRenderGhast extends RenderLiving
{
    private static final ResourceLocation ghastTextures = new ResourceLocation("mymod:textures/entity/MyGhast.png");

    public MyRenderGhast()
    {
        super(new MyModelGhast(), 0.5F);
    }

    protected ResourceLocation func_110867_a(MyEntityGhast par1EntityGhast)
    {
        return ghastTextures;
    }

    /**
     * Pre-Renders the Ghast.
     */
    protected void preRenderGhast(MyEntityGhast par1EntityGhast, float par2)
    {
        float f1 = 0.1F;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        f1 = 1.0F / (f1 * f1 * f1 * f1 * f1 * 2.0F + 1.0F);
        float f2 = (8.0F + f1) / 2.0F;
        float f3 = (8.0F + 1.0F / f1) / 2.0F;
        GL11.glScalef(f3, f2, f3);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.preRenderGhast((MyEntityGhast)par1EntityLivingBase, par2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110867_a((MyEntityGhast)par1Entity);
    }
}