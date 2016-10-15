package com.jooones.hackcraft.mod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class WandiumProjectile extends EntityThrowable {

    public static final String NAME = "wandium_projectile";
    private Random random = new Random();

    public WandiumProjectile(World worldIn) {
        super(worldIn);
    }

    public WandiumProjectile(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public WandiumProjectile(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if(result.entityHit != null && result.entityHit.isEntityAlive()) {
            result.entityHit.setPositionAndUpdate(result.entityHit.posX, result.entityHit.posY + random.nextInt(256), result.entityHit.posZ);
        }
    }
}
