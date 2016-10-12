package com.jooones.hackcraft.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static net.minecraft.item.Item.getItemFromBlock;

abstract class BaseBlock extends Block {
    BaseBlock(Material materialIn, String name) {
        super(materialIn);
        setRegistryName(name);
        setUnlocalizedName(name);
    }

    static void register(Block blockInstance) {
        GameRegistry.register(blockInstance);
        GameRegistry.register(new ItemBlock(blockInstance).setRegistryName(blockInstance.getRegistryName()));
        ModelLoader.setCustomModelResourceLocation(getItemFromBlock(blockInstance), 0, new ModelResourceLocation(blockInstance.getRegistryName(), "inventory"));
    }
}
