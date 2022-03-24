package com.archasmiel.lightandgloom.util.setup;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.container.ModContainers;
import com.archasmiel.lightandgloom.screens.ArcaneWorkbenchScreen;
import com.archasmiel.lightandgloom.util.init.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = LightAndGloom.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class ClientProxy implements IProxy {

    @Override
    public void init() {

        RenderTypeLookup.setRenderLayer(ModBlocks.ZUCCINI_CROP.get(), RenderType.cutout());
        ScreenManager.register(ModContainers.ARCANE_WORKBENCH_CONTAINER.get(), ArcaneWorkbenchScreen::new);

    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().level;
    }

}
