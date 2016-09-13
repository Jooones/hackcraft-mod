package com.jooones.hackcraft.mod;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityJump {

    @SubscribeEvent
    public void handleEntityJump(LivingEvent.LivingJumpEvent livingJumpEvent) {
        livingJumpEvent.getEntity().motionY *= 2;
    }

}
