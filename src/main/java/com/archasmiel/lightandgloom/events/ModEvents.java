package com.archasmiel.lightandgloom.events;

import com.archasmiel.lightandgloom.init.ModItems;
import com.archasmiel.lightandgloom.util.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

public class ModEvents {

    @SubscribeEvent
    public void onCopperedSheep(AttackEntityEvent event){
        if (event.getPlayer().getMainHandItem().getItem() == ModItems.COPPERED_APPLE.get()) {
            if (event.getTarget().isAlive()){
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof SheepEntity){
                    PlayerEntity player = event.getPlayer();

                    player.getMainHandItem().shrink(1);

                    target.addEffect(new EffectInstance(Effects.GLOWING, Config.COPPERED_GLOW_DURATION.get()));

                    if (player.level.isClientSide()) {
                        player.sendMessage(
                                new StringTextComponent(TextFormatting.YELLOW + "Sheep is now glowing!"),
                                player.getUUID()
                        );
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onCopperedSheepDrops(LivingDropsEvent event) {
        LivingEntity entity = event.getEntityLiving();

        if (entity instanceof SheepEntity){
            World world = entity.level;
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActiveEffects());

            if (entity.hasEffect(Effects.GLOWING)){
                drops.add(
                        new ItemEntity(
                                world,
                                entity.getX(),
                                entity.getY(),
                                entity.getZ(),
                                new ItemStack(ModItems.COPPER_WIRE.get(), 18)
                        )
                );
            }
        }
    }

    @SubscribeEvent
    public void onJoin(EntityJoinWorldEvent event){
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            World world = event.getWorld();
            if (!world.isClientSide())
                player.sendMessage(
                        new StringTextComponent("Hello %p!".replace("%p", player.getName().getString())),
                        player.getUUID()
                );
        }
    }


}
