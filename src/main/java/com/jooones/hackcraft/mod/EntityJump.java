package com.jooones.hackcraft.mod;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityJump {

    @Initialize
    public static void init(){
        MinecraftForge.EVENT_BUS.register(new EntityJump());
    }

    @SubscribeEvent
    public void handleEntityJump(LivingEvent.LivingJumpEvent livingJumpEvent) {
        livingJumpEvent.getEntity().motionY *= 1;
    }

}
