package com.jooones.hackcraft.mod.recipe;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static com.jooones.hackcraft.mod.item.Wandium.wandium;
import static com.jooones.hackcraft.mod.item.WarpiumIngot.warpiumIngot;
import static net.minecraftforge.fml.common.registry.GameRegistry.addRecipe;

public class WandiumRecipe {
    @Initialize
    public static void init() {
        addRecipe(new ItemStack(wandium()), "I", "S", "S", 'I', warpiumIngot(), 'S', Items.STICK);
    }
}
