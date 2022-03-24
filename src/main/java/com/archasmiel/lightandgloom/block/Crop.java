package com.archasmiel.lightandgloom.block;

import com.archasmiel.lightandgloom.util.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class Crop extends CropsBlock {

    private static final VoxelShape[] SHAPES = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};


    public Crop(Properties builder){
        super(builder);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader,
                               BlockPos pos, ISelectionContext context) {
        return SHAPES[state.getValue(this.getAgeProperty())];
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected IItemProvider getBaseSeedId() {
        return ModItems.ZUCCINI_SEED.get();
    }


}
