package com.archasmiel.lightandgloom.util;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ModArmorMaterial implements IArmorMaterial {
    COPPER(
            new Integer[] { 40, 70, 80, 50 },
            new Integer[] { 2, 3, 4, 3 },
            10,
            SoundEvents.ARMOR_EQUIP_IRON,
            Ingredient.of(new ItemStack(ModItems.COPPER_INGOT.get())),
            LightAndGloom.MOD_ID + ":copper/copper",
            1f,
            0f
    );

    private final Integer[] durability;
    private final Integer[] damageReduction;
    private final Integer enchantability;
    private final SoundEvent soundEvent;
    private final Ingredient repairMaterial;
    private final String name;
    private final Float thoughness;
    private final Float knockbackResistance;

    ModArmorMaterial(Integer[] durability, Integer[] damageReduction, Integer enchantability, SoundEvent soundEvent,
                     Ingredient repairMaterial, String name, Float thoughness, Float knockbackResistance) {
        this.durability = durability;
        this.damageReduction = damageReduction;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.repairMaterial = repairMaterial;
        this.name = name;
        this.thoughness = thoughness;
        this.knockbackResistance = knockbackResistance;
    }


    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return durability[slot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        return damageReduction[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return thoughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
