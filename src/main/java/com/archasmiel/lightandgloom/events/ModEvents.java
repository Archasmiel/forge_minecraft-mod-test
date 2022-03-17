package com.archasmiel.lightandgloom.events;

import com.archasmiel.lightandgloom.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.world.BlockEvent;
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

                    target.addEffect(new EffectInstance(Effects.GLOWING, 600));

                    String msg = TextFormatting.YELLOW + "Sheep is now glowing!";
                    if (!player.level.isClientSide()) {

                        player.sendMessage(new StringTextComponent(msg), player.getUUID());
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

    /*
    @SubscribeEvent
    public void eventG(BlockEvent blockEvent){
        BlockPos blockPos = blockEvent.getPos();

        if (blockPos.getY() == 0){
            if (blockEvent.getWorld().isEmptyBlock(blockPos)) {
                LogManager.getLogger().debug("Destroyed block at [" + blockPos.getX() + "," + blockPos.getY() + "," + blockPos.getZ() + "]");
            } else {
                LogManager.getLogger().debug("Set block at [" + blockPos.getX() + "," + blockPos.getY() + "," + blockPos.getZ() + "]");
            }

        }
    }
    */


}
