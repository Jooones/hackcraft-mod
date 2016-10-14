package com.jooones.hackcraft.mod.item;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.creativetab.CreativeTabs;

public class WarpiumNugget extends BaseItem {

    private static final String NAME = "warpium_nugget";

    private static WarpiumNugget instance;

    @Initialize
    public static void init() {
        register(warpiumNugget());
    }

    private WarpiumNugget() {
        super(NAME);
        setCreativeTab(CreativeTabs.MATERIALS);
        setMaxStackSize(64);
    }

    public static WarpiumNugget warpiumNugget() {
        if (instance == null) {
            instance = new WarpiumNugget();
        }

        return instance;
    }

}
