package io.github.chaosawakens.common.items.base;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.github.chaosawakens.api.item.ICATieredItem;
import io.github.chaosawakens.common.util.EntityUtil;
import io.github.chaosawakens.common.util.EnumUtil.CAItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.Lazy;

import java.util.function.Supplier;

public class CASwordItem extends SwordItem implements ICATieredItem {
	private Supplier<IntValue> configDmg;
	private float attackSpeed;
	private double reach;
	private double attackKnockback;
	private Lazy<? extends Multimap<Attribute, AttributeModifier>> attributeModMapLazy = Lazy.of(() -> {
		ImmutableMultimap.Builder<Attribute, AttributeModifier> attrModMapBuilder = ImmutableMultimap.builder();
		
		attrModMapBuilder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", getActualAttackDamage().get().get() - 1, AttributeModifier.Operation.ADDITION));
		attrModMapBuilder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", getAttackSpeed(), AttributeModifier.Operation.ADDITION));
		if (ForgeMod.REACH_DISTANCE.isPresent()) attrModMapBuilder.put(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(ICATieredItem.getReachUUIDMod(), "Weapon modifier", getReach(), AttributeModifier.Operation.ADDITION));
		attrModMapBuilder.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(ICATieredItem.getKBUUIDMod(), "Weapon modifier", getAttackKnockback(), AttributeModifier.Operation.ADDITION));
		
		return attrModMapBuilder.build();
	});

	public CASwordItem(CAItemTier pTier, Supplier<IntValue> configDmg, float pAttackSpeedModifier, double reach, Properties pProperties) {
		super(pTier, pTier.getAttackDamageMod(), pAttackSpeedModifier, pProperties);
		this.configDmg = configDmg;
		this.attackSpeed = pAttackSpeedModifier;
		this.reach = reach;
		this.attackKnockback = 0;
	}
	
	public CASwordItem(CAItemTier pTier, Supplier<IntValue> configDmg, float pAttackSpeedModifier, Double attackKnockback, Properties pProperties) {
		super(pTier, pTier.getAttackDamageMod(), pAttackSpeedModifier, pProperties);
		this.configDmg = configDmg;
		this.attackSpeed = pAttackSpeedModifier;
		this.reach = 0;
		this.attackKnockback = attackKnockback;
	}
	
	public CASwordItem(CAItemTier pTier, Supplier<IntValue> configDmg, double reach, double attackKnockback, Properties pProperties) {
		super(pTier, pTier.getAttackDamageMod(), -2.4F, pProperties);
		this.configDmg = configDmg;
		this.attackSpeed = -2.4F;
		this.reach = reach;
		this.attackKnockback = attackKnockback;
	}
	
	public CASwordItem(CAItemTier pTier, Supplier<IntValue> configDmg, float pAttackSpeedModifier, double reach, double attackKnockback, Properties pProperties) {
		super(pTier, pTier.getAttackDamageMod(), pAttackSpeedModifier, pProperties);
		this.configDmg = configDmg;
		this.attackSpeed = pAttackSpeedModifier;
		this.reach = reach;
		this.attackKnockback = attackKnockback;
	}
	
	public CASwordItem(CAItemTier pTier, Supplier<IntValue> configDmg, float pAttackSpeedModifier, Properties pProperties) {
		super(pTier, pTier.getAttackDamageMod(), pAttackSpeedModifier, pProperties);
		this.configDmg = configDmg;
		this.attackSpeed = pAttackSpeedModifier;
		this.reach = 0;
		this.attackKnockback = 0;
	}
	
	public CASwordItem(CAItemTier pTier, Supplier<IntValue> configDmg, Properties pProperties) {
		super(pTier, pTier.getAttackDamageMod(), -2.4F, pProperties);
		this.configDmg = configDmg;
		this.attackSpeed = -2.4F;
		this.reach = 0;
		this.attackKnockback = 0;
	}
	
	@Override
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType slot, ItemStack stack) {
		return slot.equals(EquipmentSlotType.MAINHAND) ? attributeModMapLazy.get() : super.getAttributeModifiers(slot, stack);
	}
	
	@Override
	public Supplier<IntValue> getActualAttackDamage() {
		return configDmg;
	}
	
	@Override
	public float getDamage() {
		return getActualAttackDamage().get().get();
	}
	
	@Override
	public void setAttackDamage(Supplier<IntValue> attackDamage) {
		this.configDmg = attackDamage;
	}
	
	@Override
	public float getAttackSpeed() {
		return attackSpeed;
	}
	
	@Override
	public void setAttackSpeed(float attackSpeed) {
		this.attackSpeed = attackSpeed - 2.4F;
	}
	
	@Override
	public double getReach() {
		return reach;
	}
	
	@Override
	public void setReach(double reach) {
		this.reach = reach;
	}
	
	@Override
	public double getAttackKnockback() {
		return attackKnockback;
	}
	
	@Override
	public void setAttackKnockback(double attackKnockback) {
		this.attackKnockback = attackKnockback;
	}
	
	@Override
	public void setAttributeModifiers(Lazy<? extends Multimap<Attribute, AttributeModifier>> attributeModMapLazy) {
		this.attributeModMapLazy = attributeModMapLazy;
	}
	
	@Override
	public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
		if (entity != null) EntityUtil.applyReachModifierToEntity(entity, stack, getDamage());
		return super.onEntitySwing(stack, entity);
	}
}
