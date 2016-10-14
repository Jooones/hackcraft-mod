package com.jooones.hackcraft.mod.block;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class WarpiumOre extends BaseBlock {

    private static final String NAME = "warpium_ore";

    private static WarpiumOre instance;

    @Initialize
    public static void init() {
        register(warpiumOre());
    }

    private WarpiumOre() {
        super(Material.ROCK, NAME);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setHardness(3);
    }

    public static WarpiumOre warpiumOre() {
        if (instance == null) {
            instance = new WarpiumOre();
        }
        return instance;
    }

}
