package com.jooones.hackcraft.mod.item;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.creativetab.CreativeTabs;

public class Wandium extends BaseItem {

    private static final String NAME = "wandium";

    private static Wandium instance;

    @Initialize
    public static void init() {
        register(wandium());
    }

    private Wandium() {
        super(NAME);
        setCreativeTab(CreativeTabs.MATERIALS);
        setMaxStackSize(64);
    }

    public static Wandium wandium() {
        if (instance == null) {
            instance = new Wandium();
        }

        return instance;
    }

}
