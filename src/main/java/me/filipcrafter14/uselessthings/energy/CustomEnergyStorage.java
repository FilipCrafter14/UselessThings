package me.filipcrafter14.uselessthings.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergyStorage extends EnergyStorage {

    public CustomEnergyStorage(int capacity) {
        super(capacity, capacity, capacity, 0);
    }

    public CustomEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer, maxTransfer, 0);
    }

    public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract, 0);
    }

    public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return super.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return super.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored() {
        return super.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored() {
        return super.getMaxEnergyStored();
    }

    @Override
    public boolean canExtract() {
        return super.canExtract();
    }

    @Override
    public boolean canReceive() {
        return super.canReceive();
    }

    public void writeToNBT(NBTTagCompound compound) {
        compound.putInt("Energy", this.energy);
        compound.putInt("Capacity", this.capacity);
        compound.putInt("MaxRecive", this.maxReceive);
        compound.putInt("MaxExtract", this.maxExtract);
    }

    public void readFromNBT(NBTTagCompound compound) {
        this.energy = compound.getInt("Energy");
        this.capacity = compound.getInt("Capacity");
        this.maxReceive = compound.getInt("MaxRecive");
        this.maxExtract = compound.getInt("MaxExtract");
    }


}
