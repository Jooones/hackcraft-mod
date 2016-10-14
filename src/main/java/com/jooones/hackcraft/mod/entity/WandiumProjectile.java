package com.jooones.hackcraft.mod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import static java.lang.Math.random;

public class WandiumProjectile extends EntityThrowable {

    public static final String NAME = "wandium_projectile";

    public WandiumProjectile(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(result.entityHit.isEntityAlive()) {
            result.entityHit.setPositionAndUpdate(random(), random(), random());
        }
    }
}
