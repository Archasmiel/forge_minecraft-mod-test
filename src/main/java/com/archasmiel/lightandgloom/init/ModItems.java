package com.archasmiel.lightandgloom.init;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.item.armor.copper.CopperBoots;
import com.archasmiel.lightandgloom.item.armor.copper.CopperChestplate;
import com.archasmiel.lightandgloom.item.armor.copper.CopperHelmet;
import com.archasmiel.lightandgloom.item.armor.copper.CopperLeggings;
import com.archasmiel.lightandgloom.item.food.CopperedApple;
import com.archasmiel.lightandgloom.item.fuel.CoalFuel;
import com.archasmiel.lightandgloom.item.material.Ingot;
import com.archasmiel.lightandgloom.item.material.Wire;
import com.archasmiel.lightandgloom.item.tool.copper.*;
import com.archasmiel.lightandgloom.util.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    /* TAB PREFAB */
    public static final Item.Properties usualItemTab
            = new Item.Properties().tab(LightAndGloom.MOD_TAB);



    /* MATERIALS */
    public static final RegistryObject<Item> COPPER_INGOT
            = Registration.registerItem("copper_ingot", Ingot::new);

    public static final RegistryObject<Item> COPPER_WIRE
            = Registration.registerItem("copper_wire", Wire::new);



    /* FOOD */
    public static final RegistryObject<Item> COPPERED_APPLE
            = Registration.registerItem("coppered_apple", CopperedApple::new);



    /* FUEL */
    public static final RegistryObject<Item> COPPERED_COAL
        = Registration.registerItem("coppered_coal", () -> new CoalFuel(32, 3200));



    /* TOOLS */
    public static final RegistryObject<Item> COPPER_SHOVEL
            = Registration.registerItem("copper_shovel", CopperShovel::new);

    public static final RegistryObject<Item> COPPER_AXE
            = Registration.registerItem("copper_axe", CopperAxe::new);

    public static final RegistryObject<Item> COPPER_PICKAXE
            = Registration.registerItem("copper_pickaxe", CopperPickaxe::new);

    public static final RegistryObject<Item> COPPER_SWORD
            = Registration.registerItem("copper_sword", CopperSword::new);

    public static final RegistryObject<Item> COPPER_HOE
            = Registration.registerItem("copper_hoe", CopperHoe::new);



    /* ARMOR */
    public static final RegistryObject<Item> COPPER_HELMET
            = Registration.registerItem("copper_helmet", CopperHelmet::new);

    public static final RegistryObject<Item> COPPER_CHESTPLATE
            = Registration.registerItem("copper_chestplate", CopperChestplate::new);

    public static final RegistryObject<Item> COPPER_LEGGINGS
            = Registration.registerItem("copper_leggings", CopperLeggings::new);

    public static final RegistryObject<Item> COPPER_BOOTS
            = Registration.registerItem("copper_boots", CopperBoots::new);



    public static void register() {}
}