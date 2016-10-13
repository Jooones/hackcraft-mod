package com.jooones.hackcraft.mod.block;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class WarpiumOre extends BaseBlock {

    public static final String NAME = "warpium_ore";
    private static WarpiumOre instance;

    @Initialize
    public static void init() {
        register(warpiumOre());
    }

    public WarpiumOre() {
        super(Material.ROCK, NAME);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    public static WarpiumOre warpiumOre() {
        if(instance == null) {
            instance = new WarpiumOre();
        }

        return instance;
    }

}
