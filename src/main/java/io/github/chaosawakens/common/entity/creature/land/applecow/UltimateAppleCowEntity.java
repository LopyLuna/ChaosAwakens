package io.github.chaosawakens.common.entity.creature.land.applecow;

import io.github.chaosawakens.api.animation.IAnimatableEntity;
import io.github.chaosawakens.api.animation.IAnimationBuilder;
import io.github.chaosawakens.api.animation.SingletonAnimationBuilder;
import io.github.chaosawakens.api.animation.WrappedAnimationController;
import io.github.chaosawakens.common.entity.base.AnimatableAnimalEntity;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class UltimateAppleCowEntity extends AnimatableAnimalEntity {
	private final AnimationFactory factory = new AnimationFactory(this);
	private final ObjectArrayList<WrappedAnimationController<UltimateAppleCowEntity>> ultimateAppleCowControllers = new ObjectArrayList<WrappedAnimationController<UltimateAppleCowEntity>>(1);
	private final ObjectArrayList<IAnimationBuilder> ultimateAppleCowAnimations = new ObjectArrayList<IAnimationBuilder>(3);
	private static final DataParameter<Boolean> PANICKING = EntityDataManager.defineId(UltimateAppleCowEntity.class, DataSerializers.BOOLEAN);
	private final WrappedAnimationController<UltimateAppleCowEntity> mainController = createMainMappedController("ultimateapplecowmaincontroller");
	private final SingletonAnimationBuilder idleAnim = new SingletonAnimationBuilder(this, "Idle", EDefaultLoopTypes.LOOP);
	private final SingletonAnimationBuilder walkAnim = new SingletonAnimationBuilder(this, "Walk", EDefaultLoopTypes.LOOP);
	private final SingletonAnimationBuilder runAnim = new SingletonAnimationBuilder(this, "Run", EDefaultLoopTypes.LOOP);
	public static final String ULTIMATE_APPLE_COW_MDF_NAME = "apple_cow";

	public UltimateAppleCowEntity(EntityType<? extends AnimalEntity> type, World world) {
		super(type, world);
	}
	
	public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
		return MobEntity.createLivingAttributes()
				.add(Attributes.MAX_HEALTH, 100)
				.add(Attributes.MOVEMENT_SPEED, 0.2D)
				.add(Attributes.FOLLOW_RANGE, 10);
	}

	@Override
	public AnimationFactory getFactory() {
		return factory;
	}
	
	@Override
	public WrappedAnimationController<UltimateAppleCowEntity> getMainWrappedController() {
		return mainController;
	}

	@Override
	public int animationInterval() {
		return 2;
	}

	@Override
	public <E extends IAnimatableEntity> PlayState mainPredicate(AnimationEvent<E> event) {
		return PlayState.CONTINUE;
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D) {
			@Override
			public void start() {
				super.start();
				setPanicking(true);
			}
			
			@Override
			public void stop() {
				super.stop();
				setPanicking(false);
			}
		});
		this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PANICKING, false);
	}
	
	public boolean isPanicking() {
		return this.entityData.get(PANICKING);
	}
	
	public void setPanicking(boolean panicking) {
		this.entityData.set(PANICKING, panicking);
	}

	@Override
	public SingletonAnimationBuilder getIdleAnim() {
		return idleAnim;
	}

	@Override
	public SingletonAnimationBuilder getWalkAnim() {
		return walkAnim;
	}

	@Override
	public SingletonAnimationBuilder getDeathAnim() {
		return null;
	}

	@Override
	public String getOwnerMDFileName() {
		return ULTIMATE_APPLE_COW_MDF_NAME;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.COW_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.COW_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.COW_DEATH;
	}
	
	@Override
	protected float getVoicePitch() {
		return super.getVoicePitch() - 0.4F;
	}
	
	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}
	
	@Override
	protected void tickDeath() {
		super.tickDeath();
		setPanicking(false);
	}
	
	@Override
	public void aiStep() {
		if (this.level.isClientSide) this.level.addParticle(ParticleTypes.INSTANT_EFFECT, false, getRandomX(0.5D), getY(0.85D), getRandomZ(0.5D), -1000, -1000, -1000);
		super.aiStep();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}
	
	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return isBaby() ? sizeIn.height * 0.95F : 1.3F;
	}
	
	@Override
	public ActionResultType mobInteract(PlayerEntity playerIn, Hand hand) {
		ItemStack handStack = playerIn.getItemInHand(hand);
		
		if (handStack.getItem() == Items.BUCKET && !isBaby()) {
			playerIn.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
			ItemStack milkBucketStack = DrinkHelper.createFilledResult(handStack, playerIn, Items.MILK_BUCKET.getDefaultInstance());
			playerIn.setItemInHand(hand, milkBucketStack);
			return ActionResultType.sidedSuccess(this.level.isClientSide);
		} else return super.mobInteract(playerIn, hand);
	}

	@Nullable
	@Override
	public AgeableEntity getBreedOffspring(ServerWorld pServerLevel, AgeableEntity pMate) {
		return null;
	}
	
	@Override
	protected void handleBaseAnimations() {
		if (getIdleAnim() != null && !isMoving()) playAnimation(getIdleAnim(), false);
		if (getWalkAnim() != null && isMoving() && !isPanicking()) playAnimation(getWalkAnim(), false);
		if (isPanicking()) playAnimation(runAnim, false);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ObjectArrayList<WrappedAnimationController<UltimateAppleCowEntity>> getWrappedControllers() {
		return ultimateAppleCowControllers;
	}
	
	@Override
	public ObjectArrayList<IAnimationBuilder> getCachedAnimations() {
		return ultimateAppleCowAnimations;
	}
}
