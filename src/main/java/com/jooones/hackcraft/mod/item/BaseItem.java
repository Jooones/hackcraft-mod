package com.jooones.hackcraft.mod.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

abstract class BaseItem extends Item {

    BaseItem(String name) {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
    }

    static void register(Item itemInstance) {
        GameRegistry.register(itemInstance);
        ModelLoader.setCustomModelResourceLocation(itemInstance, 0, new ModelResourceLocation(itemInstance.getRegistryName(), "inventory"));
    }
}
