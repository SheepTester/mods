package mymod.entity.wraith;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import mymod.items.MyItem;
import mymod.items.MyItem5;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MyEntityWraith extends EntityAnimal implements IAnimals
{
    public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;
    private Entity targetedEntity;

/** The time until the next soul is spawned. */
    public int timeUntilNextSoul;

    /** Cooldown time between target loss and new target aquirement. */
    private int aggroCooldown;
    public int prevAttackCounter;
    public int attackCounter;

    public MyEntityWraith(World par1World)
    {
        super(par1World);
        this.setSize(0.6F, 1.8F);
        this.timeUntilNextSoul = this.rand.nextInt(6000) + 1000;
        this.isImmuneToFire = true;
        this.experienceValue = 5;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, Main.MyItem_5.itemID, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    @SideOnly(Side.CLIENT)
    public boolean func_110182_bF()
    {
        return this.dataWatcher.getWatchableObjectByte(16) != 0;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25D);
    }

    protected void updateEntityActionState()
    {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0)
        {
            this.setDead();
        }

        this.despawnEntity();
        this.prevAttackCounter = this.attackCounter;
        double d0 = this.waypointX - this.posX;
        double d1 = this.waypointY - this.posY;
        double d2 = this.waypointZ - this.posZ;
        double d3 = d0 * d0 + d1 * d1 + d2 * d2;

        if (d3 < 1.0D || d3 > 3600.0D)
        {
            this.waypointX = this.posX + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointY = this.posY + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
            this.waypointZ = this.posZ + (double)((this.rand.nextFloat() * 2.0F - 1.0F) * 16.0F);
        }

        if (this.courseChangeCooldown-- <= 0)
        {
            this.courseChangeCooldown += this.rand.nextInt(5) + 2;
            d3 = (double)MathHelper.sqrt_double(d3);

            if (this.isCourseTraversable(this.waypointX, this.waypointY, this.waypointZ, d3))
            {
                this.motionX += d0 / d3 * 0.1D;
                this.motionY += d1 / d3 * 0.1D;
                this.motionZ += d2 / d3 * 0.1D;
            }
            else
            {
                this.waypointX = this.posX;
                this.waypointY = this.posY;
                this.waypointZ = this.posZ;
            }
        }
        if (!this.worldObj.isRemote)
        {
            byte b0 = this.dataWatcher.getWatchableObjectByte(16);
            byte b1 = (byte)(this.attackCounter > 10 ? 1 : 0);

            if (b0 != b1)
            {
                this.dataWatcher.updateObject(16, Byte.valueOf(b1));
            }
        }
        if (!this.isChild() && !this.worldObj.isRemote && --this.timeUntilNextSoul <= 0)
        {
            this.playSound("ambient.weather.thunder", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.dropItem(Block.slowSand.blockID, 1);
            this.timeUntilNextSoul = this.rand.nextInt(6000) + 1000;
        }
    }

    /**
     * True if the ghast has an unobstructed line of travel to the waypoint.
     */
    private boolean isCourseTraversable(double par1, double par3, double par5, double par7)
    {
        double d4 = (this.waypointX - this.posX) / par7;
        double d5 = (this.waypointY - this.posY) / par7;
        double d6 = (this.waypointZ - this.posZ) / par7;
        AxisAlignedBB axisalignedbb = this.boundingBox.copy();

        for (int i = 1; (double)i < par7; ++i)
        {
            axisalignedbb.offset(d4, d5, d6);

            if (!this.worldObj.getCollidingBoundingBoxes(this, axisalignedbb).isEmpty())
            {
                return false;
            }
        }

        return true;
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.ghast.moan";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
    	this.dropItem(Item.ghastTear.itemID, 1);
        return "fire.ignite";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "random.explode";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Main.MyItem_5.itemID;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(2) + this.rand.nextInt(1 + par2);
        int k;

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Main.MyItem_5.itemID, 1);
        }

        j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

        for (k = 0; k < j; ++k)
        {
            this.dropItem(Main.MyItem_5.itemID, 1);
        }
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 10.0F;
    }

    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public MyEntityWraith spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new MyEntityWraith(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.getItem() instanceof MyItem5;
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.rand.nextInt(20) == 0 && super.getCanSpawnHere() && this.worldObj.difficultySetting > 0;
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 10;
    }
}