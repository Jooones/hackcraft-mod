package com.jooones.hackcraft.mod.recipe;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.item.ItemStack;

import static com.jooones.hackcraft.mod.block.WarpiumOre.warpiumOre;
import static com.jooones.hackcraft.mod.item.WarpiumIngot.warpiumIngot;
import static net.minecraftforge.fml.common.registry.GameRegistry.addSmelting;

public class WarpiumOreToWarpiumIngotRecipe {
    @Initialize
    public static void init() {
        addSmelting(warpiumOre(), new ItemStack(warpiumIngot()), 1);
    }
}
