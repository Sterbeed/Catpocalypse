package net.sterbee.catpocalypse.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.CamelEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PykeEntity extends HostileEntity {
    public PykeEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }


    /**
     * Setting up idle animation cooldown.
     */
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationCooldown = 0;
    private void updateAnimations(){
        if (this.idleAnimationCooldown <= 0) {
            this.idleAnimationCooldown = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationCooldown;
        }
    }

    /**
     * Method that executes the animation for standing posing.
     */
    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
            super.tick();
            if(this.getWorld().isClient()){
                updateAnimations();
            }
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * This method specifies the AI of Pyke and what he does.
     * He can swim, he is hostile towards all mobs, and wanders around.
     */
    protected void initGoals(){
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new ActiveTargetGoal<>(this, LivingEntity.class, 10, true, true,
                target -> target instanceof LivingEntity));

        this.goalSelector.add(2, new MeleeAttackGoal(this, 1, false));

        this.goalSelector.add(3, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(5, new LookAroundGoal(this));

    }
    private StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.POISON, 200, 1);

    /**
     * This method are Pyke's attributes like health movement speed, armor and damage.
     */
    public static DefaultAttributeContainer.Builder createPykeAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1f)
                .add(EntityAttributes.GENERIC_ARMOR, 10f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5);
    }

    /**
     * These methods are the sound Pyke makes when an event is triggered.
     */
    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CAT_AMBIENT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAT_HURT;
    }
    @Override
    public SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CAT_DEATH;
    }

}
