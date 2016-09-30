package com.jooones.hackcraft.mod.item;

import com.jooones.hackcraft.mod.annotation.Initialize;
import com.jooones.hackcraft.mod.block.Warpium;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WarpiumItem extends ItemBlock {

    @Initialize
    public static void init() {
        GameRegistry.register(new WarpiumItem());
    }

    public WarpiumItem() {
        super(new Warpium());
        setRegistryName("hackcraft", Warpium.NAME);
        setUnlocalizedName(Warpium.NAME);
        setMaxStackSize(64);
    }


}
