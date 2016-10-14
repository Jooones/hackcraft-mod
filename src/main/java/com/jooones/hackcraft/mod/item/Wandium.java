package com.jooones.hackcraft.mod.item;

import com.jooones.hackcraft.mod.annotation.Initialize;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class Wandium extends BaseItem {

    private static final String NAME = "wandium";

    private static Wandium instance;

    @Initialize
    public static void init() {
        register(wandium());
    }

    private Wandium() {
        super(NAME);
        setCreativeTab(CreativeTabs.MATERIALS);
        setMaxStackSize(64);
    }

    public static Wandium wandium() {
        if (instance == null) {
            instance = new Wandium();
        }

        return instance;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        //fireProjectile(new WandiumProjectile(worldIn, playerIn), worldIn, playerIn);
        fireProjectile(new EntitySnowball(worldIn, playerIn), worldIn, playerIn);

        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }

    private void fireProjectile(EntityThrowable projectile, World worldIn, EntityPlayer playerIn) {
        projectile.setThrowableHeading(
            playerIn.getLookVec().xCoord * 0.1,
            playerIn.getLookVec().yCoord * 0.1,
            playerIn.getLookVec().zCoord * 0.1, 1.6F, 0.0F);
        worldIn.spawnEntityInWorld(projectile);
    }
}
