package com.jooones.hackcraft.mod.recipe;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.item.ItemStack;

import static com.jooones.hackcraft.mod.item.WarpiumIngot.warpiumIngot;
import static com.jooones.hackcraft.mod.item.WarpiumNugget.warpiumNugget;
import static net.minecraftforge.fml.common.registry.GameRegistry.addShapelessRecipe;

public class WarpiumIngotToWarpiumNuggetRecipe {

    @Initialize
    public static void init() {
        addShapelessRecipe(new ItemStack(warpiumNugget(), 9), new ItemStack(warpiumIngot()));
    }

}
