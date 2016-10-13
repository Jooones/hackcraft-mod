package com.jooones.hackcraft.mod.recipe;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.item.ItemStack;

import static com.jooones.hackcraft.mod.item.WarpiumIngot.warpiumIngot;
import static com.jooones.hackcraft.mod.item.WarpiumNugget.warpiumNugget;
import static net.minecraftforge.fml.common.registry.GameRegistry.addRecipe;

public class WarpiumNuggetToWarpiumIngotRecipe {

    @Initialize
    public static void init() {
        addRecipe(new ItemStack(warpiumIngot()),"NNN", "NNN", "NNN", 'N', warpiumNugget());
    }

}
