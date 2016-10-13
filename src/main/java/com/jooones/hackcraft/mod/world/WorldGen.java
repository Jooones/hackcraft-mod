package com.jooones.hackcraft.mod.world;

import com.jooones.hackcraft.mod.annotation.Initialize;
import com.jooones.hackcraft.mod.block.WarpiumOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class WorldGen implements IWorldGenerator {

    @Initialize
    public static void init() {
        GameRegistry.registerWorldGenerator(new WorldGen(), 0);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator iChunkGenerator, IChunkProvider iChunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //Overworld
                generateOre(world, random, chunkX, chunkZ, 128, 35, 10, WarpiumOre.warpiumOre().getDefaultState());
                break;
            case -1: //Nether
                break;
            case 1: //End
                break;
            default:
                break;
        }
    }

    private void generateOre(World world, Random rand, int chunkX, int chunkZ, int maxY, int chancesToSpawn, int veinSize, IBlockState blockState) {
        for (int k = 0; k < chancesToSpawn; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int y = rand.nextInt(maxY);
            BlockPos blockPos = new BlockPos(firstBlockXCoord, y, firstBlockZCoord);
            (new WorldGenMinable(blockState, veinSize)).generate(world, rand, blockPos);
        }
    }
}

