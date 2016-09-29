package com.jooones.hackcraft.mod;

import com.jooones.hackcraft.mod.block.Warpium;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "Hackcraft", version = "0.1")
public class Main {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EntityJump());
        GameRegistry.register(new Warpium());
        GameRegistry.register(new ItemBlock(new Warpium()).setRegistryName(new Warpium().getRegistryName()));
    }
}
