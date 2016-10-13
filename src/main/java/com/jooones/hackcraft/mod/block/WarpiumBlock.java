package com.jooones.hackcraft.mod.block;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class WarpiumBlock extends BaseBlock {

    public static final String NAME = "warpium_block";

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
        if(instance == null) {
            instance = new WarpiumBlock();
        }
        return instance;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        WarpiumPortal.warpiumPortal().trySpawnPortal(worldIn, calculatePositionToEvaluatePortal(pos, side));
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
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

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        EntityLightningBolt entityLightningBolt = new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ(), true);
        worldIn.addWeatherEffect(entityLightningBolt);
//        worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(Items.APPLE)));
    }

}
