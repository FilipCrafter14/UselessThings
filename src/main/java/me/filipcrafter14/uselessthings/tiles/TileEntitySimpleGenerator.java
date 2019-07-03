package me.filipcrafter14.uselessthings.tiles;

import me.filipcrafter14.uselessthings.energy.CustomEnergyStorage;
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

    private static TileEntityType<?> GEN = Null();

    private static <T> T Null() {
        return null;
    }

    private CustomEnergyStorage storage = new CustomEnergyStorage(100000, 1000);
    private int energy = storage.getEnergyStored();
    private int cooldown;

    public TileEntitySimpleGenerator() {
        super(GEN);
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
    }

    public void update() {
        cooldown++;
        if (energy != getMaxEnergyStored() && cooldown == 25)
            energy++;
        cooldown = 0;
    }

}
