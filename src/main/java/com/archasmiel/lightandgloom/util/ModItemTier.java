package com.archasmiel.lightandgloom.util;

import com.archasmiel.lightandgloom.item.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public enum ModItemTier implements IItemTier {
    COPPER(
            2,
            200,
            2.5f,
            2f,
            15,
            Ingredient.of(new ItemStack(ModItems.COPPER_INGOT.get()))
    );

    private final int harvestLevel;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Ingredient repairMaterial;

    ModItemTier(int harvestLevel, int uses, float speed, float attackDamageBonus,
                int enchantmentValue, Ingredient repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial;
    }
}
