package com.jooones.hackcraft.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Warpium extends Block {

    public Warpium() {
        super(Material.WOOD);
        this.setRegistryName("warpium");
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }
}
