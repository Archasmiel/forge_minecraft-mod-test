package com.archasmiel.lightandgloom.item.food;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.util.Config;
import com.archasmiel.lightandgloom.util.KeyboardHandler;
import com.archasmiel.lightandgloom.util.text.TooltipHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import java.util.List;

public class CopperedApple extends Item
{


    public CopperedApple() {
        super(new Properties()
            .tab(LightAndGloom.MOD_TAB)
            .food(new Food.Builder()
                    .nutrition(4)
                    .saturationMod(1.5f)
                    .effect(
                            () -> new EffectInstance(
                                    Effects.DIG_SPEED,
                                    Config.COPPERED_HASTE_DURATION.get(),
                                    Config.COPPERED_HASTE_POWER.get()
                            ),
                            1f
                    )
                    .alwaysEat()
                    .build()
            )
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, World world,
                                List<ITextComponent> tooltip, ITooltipFlag flag) {
        if (KeyboardHandler.isHoldingShift()){
            tooltip.add(TooltipHandler.getCtrlHelp("Turns sheep into copper wires if hit with apple and killed."));
        } else {
            tooltip.add(TooltipHandler.shiftHelp);
        }

        if (KeyboardHandler.isHoldingCtrl()){
            tooltip.add(TooltipHandler.getCtrlHelp("Gives haste effect on eating."));
        } else {
            tooltip.add(TooltipHandler.ctrlHelp);
        }
        super.appendHoverText(stack, world, tooltip, flag);
    }

}
