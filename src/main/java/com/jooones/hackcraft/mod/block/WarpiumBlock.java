package com.jooones.hackcraft.mod.block;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class WarpiumBlock extends BaseBlock {

    public static final String NAME = "warpium_block";

    private static WarpiumBlock instance;

    @Initialize
    public static void init() {
        register(new WarpiumBlock());
    }

    public WarpiumBlock() {
        super(Material.IRON, NAME);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }


    public static WarpiumBlock warpiumBlock() {
        if(instance == null) {
            instance = new WarpiumBlock();
        }

        return instance;
    }


}
