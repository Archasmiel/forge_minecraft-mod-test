package com.archasmiel.lightandgloom.item.armor.copper;

import com.archasmiel.lightandgloom.util.tier.ModArmorMaterial;
import com.archasmiel.lightandgloom.util.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class CopperBoots extends ArmorItem {

    public CopperBoots() {
        super(ModArmorMaterial.COPPER, EquipmentSlotType.FEET, ModItems.usualItemTab);
    }

}
