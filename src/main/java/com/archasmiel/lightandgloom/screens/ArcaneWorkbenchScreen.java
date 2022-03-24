package com.archasmiel.lightandgloom.screens;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.container.ArcaneWorkbenchContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nonnull;

public class ArcaneWorkbenchScreen extends ContainerScreen<ArcaneWorkbenchContainer> {

    private static final Integer textureSizeX = 256;
    private static final Integer textureSizeY = 256;

    public static final Integer fixX =   0;
    public static final Integer fixY = -35;

    private final ResourceLocation GUI
            = new ResourceLocation(
                    LightAndGloom.MOD_ID,
                    "textures/gui/arcane_workbench_gui.png"
            );

    public ArcaneWorkbenchScreen(ArcaneWorkbenchContainer container,
                                 PlayerInventory inv,
                                 ITextComponent name) {
        super(container, inv, name);
    }


    @Override
    public void render(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBg(matrixStack, partialTicks, mouseX, mouseY);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int p_230451_2_, int p_230451_3_) {

        drawString(
                matrixStack,
                Minecraft.getInstance().font,
                "Vis discount: 0",
                115+fixX,
                20+fixY,
                0xffffff
        );
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(GUI);
        int i = this.getGuiLeft()+fixX;
        int j = this.getGuiTop()+fixY;
        this.blit(matrixStack, i, j, 0, 0, textureSizeX, textureSizeY);

    }
}
