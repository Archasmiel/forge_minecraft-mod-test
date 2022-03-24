package com.archasmiel.lightandgloom.item.armor.copper;

import com.archasmiel.lightandgloom.util.tier.ModArmorMaterial;
import com.archasmiel.lightandgloom.util.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class CopperChestplate extends ArmorItem {

    public CopperChestplate() {
        super(ModArmorMaterial.COPPER, EquipmentSlotType.CHEST, ModItems.usualItemTab);
    }

}
