package com.archasmiel.lightandgloom.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ArcaneWorkbenchTile extends TileEntity {

    private final ItemStackHandler itemHandler = createHandler();

    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public ArcaneWorkbenchTile(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public ArcaneWorkbenchTile() {
        super(ModTileEntities.ARCANE_WORKBENCH_TILE_ENTITY.get());
    }

    @Override
    public void load(BlockState state, CompoundNBT tag){
        itemHandler.deserializeNBT(tag.getCompound("inv"));

        super.load(state, tag);
    }

    @Override
    public CompoundNBT save(CompoundNBT tag){
        tag.put("inv", itemHandler.serializeNBT());
        return super.save(tag);
    }

    private ItemStackHandler createHandler(){
        return new ItemStackHandler(11)
        {

            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack itemStack){
                return true;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack itemStack, boolean simulate){
                return super.insertItem(slot, itemStack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return handler.cast();
        return super.getCapability(cap, side);
    }

}
