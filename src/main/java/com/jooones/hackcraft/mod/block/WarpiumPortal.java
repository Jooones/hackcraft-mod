package com.jooones.hackcraft.mod.block;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class WarpiumPortal extends BlockPortal {

    public static final String NAME = "warpium_portal";

    @Initialize
    public static void init() {
        BaseBlock.register(new WarpiumPortal());
    }

    public WarpiumPortal() {
        super();
        setRegistryName(NAME);
        setUnlocalizedName(NAME);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {}
}
