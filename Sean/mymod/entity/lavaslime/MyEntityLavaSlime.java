package mymod.entity.lavaslime;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MyEntityLavaSlime extends EntitySlime
{

    /** The time until the next egg is spawned. */
    public int timeUntilNextEgg;
    public MyEntityLavaSlime(World par1World)
    {
        super(par1World);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.isImmuneToFire = true;
        this.experienceValue = 2222;
    }
public void onLivingUpdate()
    {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote && --this.timeUntilNextEgg <= 0)
        {
            this.playSound("mob.chicken.plop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Main.MyPoop.itemID, 2);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.20000000298023224D);
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        return this.getSlimeSize();
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float par1)
    {
        return 15728880;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        return 1.0F;
    }

    /**
     * Returns the name of a particle effect that may be randomly created by EntitySlime.onUpdate()
     */
    protected String getSlimeParticle()
    {
        return "iconcrack_" + Main.MyPoop.itemID; //RenderGlobal.java
    }

    protected EntitySlime createInstance()
    {
        return new MyEntityLavaSlime(this.worldObj);
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Main.MyPoop.itemID;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.getDropItemId();

        if (j > 0)
        {
            int k = this.rand.nextInt(4);

            if (par2 > 0)
            {
                k += this.rand.nextInt(par2 + 4);
            }

            for (int l = 0; l < k; ++l)
            {
                this.dropItem(j, 5);
            }
        }
    }

    /**
     * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    public boolean isBurning()
    {
        return false;
    }

    /**
     * Gets the amount of time the slime needs to wait between jumps.
     */
    protected int getJumpDelay()
    {
        return super.getJumpDelay() * 4;
    }

    protected void alterSquishAmount()
    {
        this.squishAmount *= 0.9F;
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump()
    {
        this.motionY = (double)(0.42F + (float)this.getSlimeSize() * 0.1F);
        this.isAirBorne = true;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1) {}

    /**
     * Indicates weather the slime is able to damage the player (based upon the slime's size)
     */
    protected boolean canDamagePlayer()
    {
        return false;
    }

    /**
     * Gets the amount of damage dealt to the player when "attacked" by the slime.
     */
    protected int getAttackStrength()
    {
        return super.getAttackStrength() + 2;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
    }

    /**
     * Returns the name of the sound played when the slime jumps.
     */
    protected String getJumpSound()
    {
        return this.getSlimeSize() > 1 ? "mob.magmacube.big" : "mob.magmacube.small";
    }

    /**
     * Whether or not the current entity is in lava
     */
    public boolean handleLavaMovement()
    {
        return false;
    }

    /**
     * Returns true if the slime makes a sound when it lands after a jump (based upon the slime's size)
     */
    protected boolean makesSoundOnLand()
    {
        return true;
    }
}
