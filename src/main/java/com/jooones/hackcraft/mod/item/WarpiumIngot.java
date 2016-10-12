package com.jooones.hackcraft.mod.item;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.creativetab.CreativeTabs;

public class WarpiumIngot extends BaseItem {
    public static final String NAME = "warpium_ingot";

    @Initialize
    public static void init() {
        register(new WarpiumIngot());
    }

    public WarpiumIngot() {
        super(NAME);
        setCreativeTab(CreativeTabs.MATERIALS);
        setMaxStackSize(64);
    }
}
