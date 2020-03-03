package mymod.entity.lavaslime;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MyRenderLavaSlime extends RenderLiving
{
    private static final ResourceLocation magmaCubeTextures = new ResourceLocation("mymod:textures/entity/MyLavaSlime.png");
    private ModelBase scaleAmount;

    public MyRenderLavaSlime(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.scaleAmount = par2ModelBase;
    }


    protected ResourceLocation getMagmaCubeTextures(MyEntityLavaSlime par1EntityMagmaCube)
    {
        return magmaCubeTextures;
    }

    protected void scaleMagmaCube(MyEntityLavaSlime par1EntityMagmaCube, float par2)
    {
        int i = par1EntityMagmaCube.getSlimeSize();
        float f1 = (par1EntityMagmaCube.prevSquishFactor + (par1EntityMagmaCube.squishFactor - par1EntityMagmaCube.prevSquishFactor) * par2) / ((float)i * 0.5F + 1.0F);
        float f2 = 1.0F / (f1 + 1.0F);
        float f3 = (float)i;
        GL11.glScalef(f2 * f3, 1.0F / f2 * f3, f2 * f3);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleMagmaCube((MyEntityLavaSlime)par1EntityLivingBase, par2);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getMagmaCubeTextures((MyEntityLavaSlime)par1Entity);
    }
}