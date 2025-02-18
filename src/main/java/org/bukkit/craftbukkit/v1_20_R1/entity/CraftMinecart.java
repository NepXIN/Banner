package org.bukkit.craftbukkit.v1_20_R1.entity;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_20_R1.CraftServer;
import org.bukkit.craftbukkit.v1_20_R1.block.data.CraftBlockData;
import org.bukkit.craftbukkit.v1_20_R1.util.CraftMagicNumbers;
import org.bukkit.entity.Minecart;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

public abstract class CraftMinecart extends CraftVehicle implements Minecart {
    public CraftMinecart(CraftServer server, net.minecraft.world.entity.vehicle.AbstractMinecart entity) {
        super(server, entity);
    }

    @Override
    public void setDamage(double damage) {
        getHandle().setDamage((float) damage);
    }

    @Override
    public double getDamage() {
        return getHandle().getDamage();
    }

    @Override
    public double getMaxSpeed() {
        // Banner TODO return getHandle().maxSpeed;
        return 0;
    }

    @Override
    public void setMaxSpeed(double speed) {
        if (speed >= 0D) {
            //Banner TODO getHandle().maxSpeed = speed;
        }
    }

    @Override
    public boolean isSlowWhenEmpty() {
        //Banner TODO return getHandle().slowWhenEmpty;
        return false;
    }

    @Override
    public void setSlowWhenEmpty(boolean slow) {
        //Banner TODO getHandle().slowWhenEmpty = slow;
    }

    @Override
    public Vector getFlyingVelocityMod() {
        //Banner TODO return getHandle().getFlyingVelocityMod();
        return null;
    }

    @Override
    public void setFlyingVelocityMod(Vector flying) {
        //Banner TODO getHandle().setFlyingVelocityMod(flying);
    }

    @Override
    public Vector getDerailedVelocityMod() {
        //Banner TODO return getHandle().getDerailedVelocityMod();
        return null;
    }

    @Override
    public void setDerailedVelocityMod(Vector derailed) {
        //Banner TODO getHandle().setDerailedVelocityMod(derailed);
    }

    @Override
    public net.minecraft.world.entity.vehicle.AbstractMinecart getHandle() {
        return (net.minecraft.world.entity.vehicle.AbstractMinecart) entity;
    }

    @Override
    public void setDisplayBlock(MaterialData material) {
        if (material != null) {
            BlockState block = CraftMagicNumbers.getBlock(material);
            this.getHandle().setDisplayBlockState(block);
        } else {
            // Set block to air (default) and set the flag to not have a display block.
            this.getHandle().setDisplayBlockState(Blocks.AIR.defaultBlockState());
            this.getHandle().setCustomDisplay(false);
        }
    }

    @Override
    public void setDisplayBlockData(BlockData blockData) {
        if (blockData != null) {
            BlockState block = ((CraftBlockData) blockData).getState();
            this.getHandle().setDisplayBlockState(block);
        } else {
            // Set block to air (default) and set the flag to not have a display block.
            this.getHandle().setDisplayBlockState(Blocks.AIR.defaultBlockState());
            this.getHandle().setCustomDisplay(false);
        }
    }

    @Override
    public MaterialData getDisplayBlock() {
        BlockState blockData = getHandle().getDisplayBlockState();
        return CraftMagicNumbers.getMaterial(blockData);
    }

    @Override
    public BlockData getDisplayBlockData() {
        BlockState blockData = getHandle().getDisplayBlockState();
        return CraftBlockData.fromData(blockData);
    }

    @Override
    public void setDisplayBlockOffset(int offset) {
        getHandle().setDisplayOffset(offset);
    }

    @Override
    public int getDisplayBlockOffset() {
        return getHandle().getDisplayOffset();
    }
}
