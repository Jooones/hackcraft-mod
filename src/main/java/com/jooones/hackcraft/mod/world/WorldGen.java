package com.jooones.hackcraft.mod.world;

import com.jooones.hackcraft.mod.annotation.Initialize;
import com.jooones.hackcraft.mod.block.WarpiumOre;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class WorldGen implements IWorldGenerator {

    private WorldGenerator warpiumOreGenerator;

    public WorldGen() {
        this.warpiumOreGenerator = new WorldGenMinable(WarpiumOre.warpiumOre().getDefaultState(), 8);
    }

    @Initialize
    public static void init() {
        GameRegistry.registerWorldGenerator(new WorldGen(), 0);
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator iChunkGenerator, IChunkProvider iChunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //Overworld
                oreGenerator(warpiumOreGenerator, world, random, chunkX, chunkZ, 35, 0, 128);
                break;
            case -1: //Nether
                break;
            case 1: //End
                break;
            default:
                break;
        }
    }

    private void oreGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}

