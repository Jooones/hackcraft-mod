package com.jooones.hackcraft.mod;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.jooones.hackcraft.mod.annotation.Initialize;
import com.jooones.hackcraft.mod.entity.WandiumProjectile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static com.jooones.hackcraft.mod.item.WarpiumNugget.warpiumNugget;

@Mod(modid = Main.MOD_ID, version = Main.MOD_VERSION, name = Main.MOD_NAME)
public class Main {

    public static final String MOD_ID = "hackcraft";
    public static final String MOD_VERSION = "0.1";
    public static final String MOD_NAME = "Hackcraft";

    @Instance(MOD_ID)
    public static Main instance;

    @SidedProxy(clientSide = "com.jooones.hackcraft.mod.ClientProxy", serverSide = "com.jooones.hackcraft.mod.ServerProxy")
    public static ServerProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IllegalAccessException, IOException, InvocationTargetException {
        initialize();

        EntityRegistry.registerModEntity(WandiumProjectile.class, "Wandium Projectile", 12345, instance, 64, 10, true);

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) throws IllegalAccessException, IOException, InvocationTargetException {
        RenderingRegistry.registerEntityRenderingHandler(WandiumProjectile.class, new RenderSnowball<WandiumProjectile>(Minecraft.getMinecraft().getRenderManager(), warpiumNugget(), Minecraft.getMinecraft().getRenderItem()));
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
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
