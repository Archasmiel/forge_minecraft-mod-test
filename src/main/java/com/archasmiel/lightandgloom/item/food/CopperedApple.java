package com.archasmiel.lightandgloom.item.food;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import com.archasmiel.lightandgloom.util.KeyboardHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class CopperedApple extends Item
{


    public CopperedApple() {
        super(new Properties()
            .tab(LightAndGloomMod.MOD_TAB)
            .food(new Food.Builder()
                    .nutrition(4)
                    .saturationMod(1.5f)
                    .effect(
                            () -> new EffectInstance(
                                    Effects.DIG_SPEED,
                                    1000,
                                    1
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
            tooltip.add(new StringTextComponent("Turns sheep into copper wires if hit with apple and killed."));
        } else {
            tooltip.add(new StringTextComponent("\u00A77" + "Hold " + "\u00A7e" + "[SHIFT]" + "\u00A77" + " for more information."));
        }
        super.appendHoverText(stack, world, tooltip, flag);
    }

}
