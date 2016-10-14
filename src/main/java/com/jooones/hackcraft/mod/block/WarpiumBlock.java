package com.jooones.hackcraft.mod.block;

import com.jooones.hackcraft.mod.annotation.Initialize;
import com.jooones.hackcraft.mod.item.Wandium;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class WarpiumBlock extends BaseBlock {

    private static final String NAME = "warpium_block";

    private static WarpiumBlock instance;

    @Initialize
    public static void init() {
        register(warpiumBlock());
    }

    private WarpiumBlock() {
        super(Material.IRON, NAME);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public static WarpiumBlock warpiumBlock() {
        if (instance == null) {
            instance = new WarpiumBlock();
        }
        return instance;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (wandEquipped(heldItem)) {
            WarpiumPortal.warpiumPortal().trySpawnPortal(worldIn, calculatePositionToEvaluatePortal(pos, side));
            worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX() - 5, pos.getY(), pos.getZ(), true));
            worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX() + 5, pos.getY(), pos.getZ(), true));
            worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ() - 5, true));
            worldIn.addWeatherEffect(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ() + 5, true));
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
    }

    private Boolean wandEquipped(@Nullable ItemStack heldItem) {
        return ofNullable(heldItem).map(item -> item.getItem().equals(Wandium.wandium())).orElse(false);
    }

    private BlockPos calculatePositionToEvaluatePortal(BlockPos pos, EnumFacing side) {
        BlockPos positionToEvaluatePortal = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        if (side == EnumFacing.UP) {
            positionToEvaluatePortal = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
        }
        if (side == EnumFacing.DOWN) {
            positionToEvaluatePortal = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        }
        if (side == EnumFacing.EAST) {
            positionToEvaluatePortal = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
        }
        if (side == EnumFacing.WEST) {
            positionToEvaluatePortal = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
        }
        if (side == EnumFacing.NORTH) {
            positionToEvaluatePortal = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
        }
        if (side == EnumFacing.SOUTH) {
            positionToEvaluatePortal = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
        }
        return positionToEvaluatePortal;
    }

}
