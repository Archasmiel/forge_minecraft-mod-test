package com.archasmiel.lightandgloom.item.armor.copper;

import com.archasmiel.lightandgloom.util.tier.ModArmorMaterial;
import com.archasmiel.lightandgloom.util.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class CopperHelmet extends ArmorItem {
    public CopperHelmet() {
        super(ModArmorMaterial.COPPER, EquipmentSlotType.HEAD, ModItems.usualItemTab);
    }
}
