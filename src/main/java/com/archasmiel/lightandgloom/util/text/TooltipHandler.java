package com.archasmiel.lightandgloom.util.text;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class TooltipHandler {

    public static final StringTextComponent shiftHelp
            = new StringTextComponent(
                    TextFormatting.GRAY + "Hold " +
                    TextFormatting.GOLD + "[SHIFT]" +
                    TextFormatting.GRAY + " for more information."
            );
    public static final StringTextComponent ctrlHelp
            = new StringTextComponent(
                    TextFormatting.GRAY + "Hold " +
                    TextFormatting.GOLD + "[Ctrl]" +
                    TextFormatting.GRAY + " for additional information."
            );


    public static StringTextComponent getShiftInfo(String tip){
        return new StringTextComponent(
                TextFormatting.AQUA + tip
        );
    }

    public static StringTextComponent getCtrlHelp(String tip){
        return new StringTextComponent(
                TextFormatting.DARK_AQUA + tip
        );
    }

}
