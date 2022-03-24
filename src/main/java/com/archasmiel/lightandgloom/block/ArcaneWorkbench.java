package com.archasmiel.lightandgloom.block;

import com.archasmiel.lightandgloom.container.ArcaneWorkbenchContainer;
import com.archasmiel.lightandgloom.tileentity.ArcaneWorkbenchTile;
import com.archasmiel.lightandgloom.tileentity.ModTileEntities;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class ArcaneWorkbench extends Block {

    public ArcaneWorkbench() {
        super(
                AbstractBlock.Properties.
                copy(Blocks.CRAFTING_TABLE)
        );
    }

    @SuppressWarnings({"deprecation", "NullableProblems"})
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult traceResult) {
        if (!world.isClientSide()){
            TileEntity tileEntity = world.getBlockEntity(pos);

            if (tileEntity instanceof ArcaneWorkbenchTile){

                INamedContainerProvider containerProvider = new INamedContainerProvider() {
                    @Override
                    public ITextComponent getDisplayName() {
                        return new TranslationTextComponent("screen.lightandgloom.arcane_workbench_name");
                    }

                    @Nullable
                    @Override
                    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        return new ArcaneWorkbenchContainer(i, world, pos, playerInventory, playerEntity);

                    }
                };
                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getBlockPos());
            } else {
                throw new IllegalStateException("Our container provider is missing!");
            }

        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world){
        return ModTileEntities.ARCANE_WORKBENCH_TILE_ENTITY.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state){
        return true;
    }

}
