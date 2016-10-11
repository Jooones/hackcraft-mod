package com.jooones.hackcraft.mod;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ClientProxy extends ServerProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) throws IllegalAccessException, IOException, InvocationTargetException {
    }

    @Override
    public void init(FMLInitializationEvent event) throws IllegalAccessException, IOException, InvocationTargetException {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
