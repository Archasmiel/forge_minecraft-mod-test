package com.archasmiel.lightandgloom.item.armor.copper;

import com.archasmiel.lightandgloom.util.ModArmorMaterial;
import com.archasmiel.lightandgloom.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class CopperLeggings extends ArmorItem {

    public CopperLeggings() {
        super(ModArmorMaterial.COPPER, EquipmentSlotType.LEGS, ModItems.usualItemTab);
    }

}
