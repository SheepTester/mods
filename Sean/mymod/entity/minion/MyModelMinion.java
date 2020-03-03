package mymod.entity.minion;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class MyModelMinion extends ModelBase {

    ModelRenderer body;
    ModelRenderer rLeg;
    ModelRenderer lLeg;
    ModelRenderer rArm;
    ModelRenderer lArm;
  
  public MyModelMinion ()
  {
    textureWidth = 70;
    textureHeight = 30;
    
      body = new ModelRenderer(this, 18, 0);
      body.addBox(-3F, -4F, -3F, 8, 8, 8);
      body.setRotationPoint(0F, 16F, 0F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rLeg = new ModelRenderer(this, 16, 18);
      rLeg.addBox(-2F, 0F, -2F, 4, 4, 4);
      rLeg.setRotationPoint(-1F, 20F, 1F);
      rLeg.setTextureSize(128, 128);
      rLeg.mirror = true;
      setRotation(rLeg, 0F, 0F, 0F);
      lLeg = new ModelRenderer(this, 34, 18);
      lLeg.addBox(0F, 0F, 0F, 4, 4, 4);
      lLeg.setRotationPoint(1F, 20F, -1F);
      lLeg.setTextureSize(128, 128);
      lLeg.mirror = true;
      setRotation(lLeg, 0F, 0F, 0F);
      rArm = new ModelRenderer(this, 2, 0);
      rArm.addBox(-3F, -1F, -2F, 3, 6, 4);
      rArm.setRotationPoint(-3F, 15F, 1F);
      rArm.setTextureSize(128, 128);
      rArm.mirror = true;
      setRotation(rArm, 0F, 0F, 0F);
      lArm = new ModelRenderer(this, 52, 0);
      lArm.addBox(0F, -1F, -2F, 3, 6, 4);
      lArm.setRotationPoint(5F, 15F, 1F);
      lArm.setTextureSize(128, 128);
      lArm.mirror = true;
      setRotation(lArm, 0F, 0F, 0F);
  }
  
 
   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

        if (this.isChild)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5.0F * par7, 2.0F * par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
            GL11.glTranslatef(0.0F, 24.0F * par7, 0.0F);
            this.body.render(par7);
            this.rLeg.render(par7);
            this.lLeg.render(par7);
            this.rArm.render(par7);
            this.lArm.render(par7);
            GL11.glPopMatrix();
        }
        else
        {
            this.body.render(par7);
            this.rLeg.render(par7);
            this.lLeg.render(par7);
            this.rArm.render(par7);
            this.lArm.render(par7);
        }
    }
    
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
    this.rArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
    this.lArm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
    this.rLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
    this.lLeg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
  }

}