package com.archasmiel.lightandgloom;

import com.archasmiel.lightandgloom.container.ModContainers;
import com.archasmiel.lightandgloom.tileentity.ModTileEntities;
import com.archasmiel.lightandgloom.util.init.ModBlocks;
import com.archasmiel.lightandgloom.event.ModEvents;
import com.archasmiel.lightandgloom.util.init.ModFluids;
import com.archasmiel.lightandgloom.util.init.ModItems;
import com.archasmiel.lightandgloom.util.init.ModTab;
import com.archasmiel.lightandgloom.util.setup.ClientProxy;
import com.archasmiel.lightandgloom.util.setup.IProxy;
import com.archasmiel.lightandgloom.util.setup.ServerProxy;
import com.archasmiel.lightandgloom.util.Config;
import com.archasmiel.lightandgloom.util.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LightAndGloom.MOD_ID)
public class LightAndGloom
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "lightandgloom";
    public static final String MOD_NAME = "Light and Gloom";
    public static final ItemGroup MOD_TAB = new ModTab(MOD_NAME);

    public static IProxy proxy;

    public LightAndGloom() {
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        registerConfigs();

        proxy.init();

        loadConfigs();
    }

    private void registerModAdditions(){
        // init registration
        Registration.init();

        // registered items, blocks, etc
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
        ModTileEntities.register();
        ModContainers.register();

        // events
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }

    private void registerConfigs(){
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT,
                Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER,
                Config.SERVER_CONFIG);
    }

    private void loadConfigs() {
        Config.loadConfigFile(Config.CLIENT_CONFIG,
                FMLPaths.CONFIGDIR.get().resolve("lightandgloom-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG,
                FMLPaths.CONFIGDIR.get().resolve("lightandgloom-server.toml").toString());
    }
}
