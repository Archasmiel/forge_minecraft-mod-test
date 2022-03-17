package com.archasmiel.lightandgloom.item;

import com.archasmiel.lightandgloom.item.food.CopperedApple;
import com.archasmiel.lightandgloom.item.materials.ModIngot;
import com.archasmiel.lightandgloom.item.materials.ModMaterial;
import com.archasmiel.lightandgloom.item.tools.*;
import com.archasmiel.lightandgloom.util.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{

    /* MATERIALS */
    public static final RegistryObject<Item> COPPER_INGOT
            = Registration.ITEMS.register("copper_ingot", ModIngot::new);

    public static final RegistryObject<Item> COPPER_WIRE
            = Registration.ITEMS.register("copper_wire", ModMaterial::new);

    /* FOOD */
    public static final RegistryObject<Item> COPPERED_APPLE
            = Registration.ITEMS.register("coppered_apple", CopperedApple::new);

    /* TOOLS */
    public static final RegistryObject<Item> COPPER_SHOVEL
            = Registration.ITEMS.register("copper_shovel", CopperShovel::new);

    public static final RegistryObject<Item> COPPER_AXE
            = Registration.ITEMS.register("copper_axe", CopperAxe::new);

    public static final RegistryObject<Item> COPPER_PICKAXE
            = Registration.ITEMS.register("copper_pickaxe", CopperPickaxe::new);

    public static final RegistryObject<Item> COPPER_SWORD
            = Registration.ITEMS.register("copper_sword", CopperSword::new);

    public static final RegistryObject<Item> COPPER_HOE
            = Registration.ITEMS.register("copper_hoe", CopperHoe::new);

    public static void register() {

    }
}
