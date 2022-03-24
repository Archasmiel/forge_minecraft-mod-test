package com.archasmiel.lightandgloom.util.init;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.item.Seed;
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
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems
{
    /* TAB PREFAB */
    public static final Item.Properties usualItemTab
            = new Item.Properties().tab(LightAndGloom.MOD_TAB);



    /* MATERIALS */
    public static final RegistryObject<Item> COPPER_INGOT
            = registerItem("copper_ingot", Ingot::new);

    public static final RegistryObject<Item> COPPER_WIRE
            = registerItem("copper_wire", Wire::new);



    /* FOOD */
    public static final RegistryObject<Item> COPPERED_APPLE
            = registerItem("coppered_apple", CopperedApple::new);



    /* FUEL */
    public static final RegistryObject<Item> COPPERED_COAL
            = registerItem("coppered_coal", () -> new CoalFuel(32, 3200));



    /* TOOLS */
    public static final RegistryObject<Item> COPPER_SHOVEL
            = registerItem("copper_shovel", CopperShovel::new);

    public static final RegistryObject<Item> COPPER_AXE
            = registerItem("copper_axe", CopperAxe::new);

    public static final RegistryObject<Item> COPPER_PICKAXE
            = registerItem("copper_pickaxe", CopperPickaxe::new);

    public static final RegistryObject<Item> COPPER_SWORD
            = registerItem("copper_sword", CopperSword::new);

    public static final RegistryObject<Item> COPPER_HOE
            = registerItem("copper_hoe", CopperHoe::new);



    /* ARMOR */
    public static final RegistryObject<Item> COPPER_HELMET
            = registerItem("copper_helmet", CopperHelmet::new);

    public static final RegistryObject<Item> COPPER_CHESTPLATE
            = registerItem("copper_chestplate", CopperChestplate::new);

    public static final RegistryObject<Item> COPPER_LEGGINGS
            = registerItem("copper_leggings", CopperLeggings::new);

    public static final RegistryObject<Item> COPPER_BOOTS
            = registerItem("copper_boots", CopperBoots::new);



    /* SEEDS */
    public static final RegistryObject<Item> ZUCCINI_SEED
            = registerItem("zuccini_seed",
            () -> new Seed(ModBlocks.ZUCCINI_CROP.get(), usualItemTab));



    /* BUCKETS */
    public static final RegistryObject<Item> OIL_BUCKET
            = registerItem("oil_bucket",
                () -> new BucketItem(
                        () -> ModFluids.OIL_FLUID.get(),
                        new Item.Properties().tab(LightAndGloom.MOD_TAB).stacksTo(1)
                )
            );



    /* REGISTER METHODS */
    public static void register() {}

    public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> itemProperties) {
        return Registration.ITEMS.register(name, itemProperties);
    }
}
