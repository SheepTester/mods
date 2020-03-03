package mymod.entity.fourm;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class MyRenderFourm extends RenderLiving {

    public MyRenderFourm(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2);
    }   

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation("mymod:textures/entity/MyFourm.png");

    }

}
