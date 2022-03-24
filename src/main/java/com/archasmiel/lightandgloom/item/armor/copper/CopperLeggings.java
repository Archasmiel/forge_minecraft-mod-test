package com.archasmiel.lightandgloom.item.armor.copper;

import com.archasmiel.lightandgloom.util.tier.ModArmorMaterial;
import com.archasmiel.lightandgloom.util.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class CopperLeggings extends ArmorItem {

    public CopperLeggings() {
        super(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, ModItems.usualItemTab);
    }

}
