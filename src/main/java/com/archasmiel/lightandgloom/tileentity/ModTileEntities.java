package com.archasmiel.lightandgloom.tileentity;

import com.archasmiel.lightandgloom.util.Registration;
import com.archasmiel.lightandgloom.util.init.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

public class ModTileEntities {

    public static final RegistryObject<TileEntityType<ArcaneWorkbenchTile>> ARCANE_WORKBENCH_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register(
                    "arcane_workbench_tile_entity",
                    () -> TileEntityType.Builder.of(
                            () -> new ArcaneWorkbenchTile(),
                            ModBlocks.ARCANE_WORKBENCH.get()
                    ).build(null)
            );

    public static void register() {}

}
