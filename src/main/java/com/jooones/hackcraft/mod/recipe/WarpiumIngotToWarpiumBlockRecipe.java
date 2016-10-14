package com.jooones.hackcraft.mod.recipe;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.item.ItemStack;

import static com.jooones.hackcraft.mod.block.WarpiumBlock.warpiumBlock;
import static com.jooones.hackcraft.mod.item.WarpiumIngot.warpiumIngot;
import static net.minecraftforge.fml.common.registry.GameRegistry.addRecipe;

public class WarpiumIngotToWarpiumBlockRecipe {

    @Initialize
    public static void init() {
        addRecipe(new ItemStack(warpiumBlock()), "II", "II", 'I', warpiumIngot());
    }

}
