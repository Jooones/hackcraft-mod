package com.jooones.hackcraft.mod.block;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Warpium extends Block {

    @Initialize
    public static void init() {
        GameRegistry.register(new Warpium());
        GameRegistry.register(new ItemBlock(new Warpium()).setRegistryName(new Warpium().getRegistryName()));
    }

    public Warpium() {
        super(Material.WOOD);
        this.setRegistryName("warpium");
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }

}
