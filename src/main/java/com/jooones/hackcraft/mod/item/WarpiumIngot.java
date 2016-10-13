package com.jooones.hackcraft.mod.item;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.creativetab.CreativeTabs;

public class WarpiumIngot extends BaseItem {
    public static final String NAME = "warpium_ingot";

    private static WarpiumIngot instance;

    @Initialize
    public static void init() {
        register(warpiumIngot());
    }

    public WarpiumIngot() {
        super(NAME);
        setCreativeTab(CreativeTabs.MATERIALS);
        setMaxStackSize(64);
    }

    public static WarpiumIngot warpiumIngot() {
        if(instance == null) {
            instance = new WarpiumIngot();
        }

        return instance;
    }
}
