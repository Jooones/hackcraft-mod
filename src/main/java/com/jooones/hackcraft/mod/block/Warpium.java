package com.jooones.hackcraft.mod.block;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static net.minecraft.item.Item.getItemFromBlock;

public class Warpium extends Block {

    public static final String NAME = "warpium";

    @Initialize
    public static void init() {
        Warpium warpium = new Warpium();
        GameRegistry.register(warpium);
        GameRegistry.register(new ItemBlock(warpium).setRegistryName(warpium.getRegistryName()));
        ModelLoader.setCustomModelResourceLocation(getItemFromBlock(warpium), 0, new ModelResourceLocation(warpium.getRegistryName(), "inventory"));
    }

    public Warpium() {
        super(Material.ROCK);
        setRegistryName(NAME);
        setUnlocalizedName(NAME);
        setCreativeTab(CreativeTabs.MATERIALS);
    }

}
