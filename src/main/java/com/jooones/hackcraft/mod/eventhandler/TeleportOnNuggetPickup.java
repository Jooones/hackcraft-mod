package com.jooones.hackcraft.mod.eventhandler;

import com.jooones.hackcraft.mod.annotation.Initialize;
import com.jooones.hackcraft.mod.item.WarpiumNugget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class TeleportOnNuggetPickup {

    private static TeleportOnNuggetPickup instance;

    @Initialize
    public static void init() {
        MinecraftForge.EVENT_BUS.register(teleportOnNuggetPickup());
    }

    public static TeleportOnNuggetPickup teleportOnNuggetPickup() {
        if (instance == null) {
            instance = new TeleportOnNuggetPickup();
        }
        return instance;
    }

    @SubscribeEvent
    public void TeleportOnNuggetPickup(EntityItemPickupEvent event) {
        if (isPlayer(event) && pickingUpWarpiumNugget(event) && randomTeleportChance()) {
            teleportPlayer(event.getEntityPlayer());
        }
    }

    private boolean randomTeleportChance() {
        return new Random().nextInt(8) == 1;
    }

    private boolean isPlayer(EntityItemPickupEvent event) {
        return event.getEntityPlayer() != null;
    }

    private boolean pickingUpWarpiumNugget(EntityItemPickupEvent event) {
        return event.getItem().getEntityItem().getUnlocalizedName().equals(WarpiumNugget.warpiumNugget().getUnlocalizedName());
    }

    private void teleportPlayer(EntityPlayer player) {
        Random random = new Random();
        int newX = player.getPosition().getX() + random.nextInt(20) - 10;
        int newZ = player.getPosition().getZ() + random.nextInt(20) - 10;
        BlockPos newBlockPos = new BlockPos(newX, player.getPosition().getY(), newZ);

        player.setPositionAndUpdate(newBlockPos.getX(), player.getPosition().getY(), newBlockPos.getZ());
        player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 500));
    }

}
