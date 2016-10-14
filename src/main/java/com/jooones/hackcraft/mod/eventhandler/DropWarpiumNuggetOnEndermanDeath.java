package com.jooones.hackcraft.mod.eventhandler;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

import static com.jooones.hackcraft.mod.item.WarpiumNugget.warpiumNugget;

public class DropWarpiumNuggetOnEndermanDeath {

    private static DropWarpiumNuggetOnEndermanDeath instance;

    @Initialize
    public static void init() {
        MinecraftForge.EVENT_BUS.register(endermanDroppingWarpiumNugget());
    }

    public static DropWarpiumNuggetOnEndermanDeath endermanDroppingWarpiumNugget() {
        if (instance == null) {
            instance = new DropWarpiumNuggetOnEndermanDeath();
        }
        return instance;
    }

    @SubscribeEvent
    public void dropWarpiumNuggetIfEnderman(LivingDeathEvent event) {
        if (event.getEntity() instanceof EntityEnderman) {
            dropWarpiumNugget(event);
        }
    }

    private void dropWarpiumNugget(LivingDeathEvent event) {
        if (!event.getEntity().getEntityWorld().isRemote) {
            event.getEntity().dropItem(warpiumNugget(), new Random().nextInt(3));
        }
    }

}
