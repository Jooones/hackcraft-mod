package com.jooones.hackcraft.mod;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Mod(modid = "hackcraft", version = "0.1")
public class Main {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IllegalAccessException, IOException, InvocationTargetException {
        initialize();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) throws IllegalAccessException, IOException, InvocationTargetException {

    }

    private void initialize() throws IOException, InvocationTargetException, IllegalAccessException {
        ClassPath classPath = ClassPath.from(this.getClass().getClassLoader());
        ImmutableSet<ClassPath.ClassInfo> classes = classPath.getTopLevelClassesRecursive(this.getClass().getPackage().getName());
        for (ClassPath.ClassInfo aClass : classes) {
            for (Method method : aClass.load().getMethods()) {
                if (method.isAnnotationPresent(Initialize.class)) {
                    if (Modifier.isStatic(method.getModifiers())) {
                        method.invoke(null);
                    }
                }
            }
        }
    }
}
