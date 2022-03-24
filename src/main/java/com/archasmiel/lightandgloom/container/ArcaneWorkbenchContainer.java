package com.archasmiel.lightandgloom.container;

import com.archasmiel.lightandgloom.screens.ArcaneWorkbenchScreen;
import jdk.internal.net.http.common.Pair;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;

public class ArcaneWorkbenchContainer extends Container {

    private final TileEntity tileEntity;
    private final PlayerEntity playerEntity;
    private final IItemHandler playerInv;

    private static final Integer fX = ArcaneWorkbenchScreen.fixX;
    private static final Integer fY = ArcaneWorkbenchScreen.fixY;

    private static final Pair<Integer, Integer>[] coords = new Pair[]{
            // Crafting slots 0-8 positions
            new Pair<>(40 + fX, 40 + fY), new Pair<>(64 + fX, 40 + fY), new Pair<>(88 + fX, 40 + fY),
            new Pair<>(40 + fX, 64 + fY), new Pair<>(64 + fX, 64 + fY), new Pair<>(88 + fX, 64 + fY),
            new Pair<>(40 + fX, 88 + fY), new Pair<>(64 + fX, 88 + fY), new Pair<>(88 + fX, 88 + fY),

            // Wand slot position
            new Pair<>(160 + fX, 24 + fY),

            // Output slot position
            new Pair<>(160 + fX, 64 + fY),

            // Inventory slots position
            new Pair<>(16 + fX, 151 + fY),
    };



    public ArcaneWorkbenchContainer(int windowId, World world, BlockPos pos,
                                       PlayerInventory inv, PlayerEntity player) {
        super(ModContainers.ARCANE_WORKBENCH_CONTAINER.get(), windowId);
        this.tileEntity = world.getBlockEntity(pos);
        this.playerEntity = player;
        this.playerInv = new InvWrapper(inv);

        if (tileEntity != null){
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(
                h -> {
                    // crafting slots: 0-8
                    // rod slot:       9
                    // result:         10

                    for (int i = 0 ; i < 9 ; i++){
                        addSlot(new SlotCraftingArcaneWorkbench(h, i, coords[i].first, coords[i].second));
                    }

                    addSlot(new SlotOnlyWand(h, 9, coords[9].first, coords[9].second));
                    addSlot(new SlotOutput(h, 10, coords[10].first, coords[10].second));

                }
            );
        }

        layoutPlayerInventorySlots(coords[11].first, coords[11].second);
    }

    @Nonnull
    @Override
    public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();
            if (index == 0) {
                if (!this.moveItemStackTo(stack, 1, 37, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(stack, itemstack);
            } else {
                if (stack.getItem() == Items.DIAMOND) {
                    if (!this.moveItemStackTo(stack, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 28) {
                    if (!this.moveItemStackTo(stack, 28, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index < 37 && !this.moveItemStackTo(stack, 1, 28, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, stack);
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(PlayerEntity p_75145_1_) {
        return isSynched(playerEntity);
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx){
        for (int i = 0 ; i < amount ; i++){
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy){
        for (int j = 0 ; j < verAmount ; j++){
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }

        return index;
    }

    private void layoutPlayerInventorySlots(int leftCol, int topRow){
        // player inventory
        addSlotBox(playerInv, 9, leftCol, topRow, 9, 18, 3, 18);

        // hotbar
        topRow += 58;
        addSlotRange(playerInv, 0, leftCol, topRow, 9, 18);
    }

}
