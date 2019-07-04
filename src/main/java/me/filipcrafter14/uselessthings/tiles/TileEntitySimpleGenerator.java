package me.filipcrafter14.uselessthings.tiles;

import me.filipcrafter14.uselessthings.UselessThings;
import me.filipcrafter14.uselessthings.energy.CustomEnergyStorage;
import me.filipcrafter14.uselessthings.init.ModBlocks;
import me.filipcrafter14.uselessthings.init.ModTiles;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nonnull;

public class TileEntitySimpleGenerator extends TileEntity implements ITickable {


    private CustomEnergyStorage storage = new CustomEnergyStorage(100000, 1000);
    private int energy = storage.getEnergyStored();
    private int cooldown;

    public TileEntitySimpleGenerator() {
        super(ModTiles.simple_generator_tile);
    }



    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, EnumFacing side) {
        if (cap == CapabilityEnergy.ENERGY) return LazyOptional.of(() -> this.storage).cast();
        return super.getCapability(cap, side);
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        this.storage.writeToNBT(compound);
        return compound;
    }

    @Override
    public void read(NBTTagCompound compound) {
        this.storage.readFromNBT(compound);
    }

    public int getEnergyStored() {
        return this.energy;
    }

    public int getMaxEnergyStored() {
        return this.storage.getMaxEnergyStored();
    }

    @Override
    public void tick() {
        cooldown++;
        if (energy != getMaxEnergyStored() && cooldown == 25)
            energy++;
        cooldown = 0;
        System.out.println(energy);
        UselessThings.Logger.info(energy);
    }

    public void update() {
        cooldown++;
        if (energy != getMaxEnergyStored() && cooldown == 25)
            energy++;
        cooldown = 0;
        System.out.println(energy + "Update");
        UselessThings.Logger.info(energy + "Update");
    }

}
