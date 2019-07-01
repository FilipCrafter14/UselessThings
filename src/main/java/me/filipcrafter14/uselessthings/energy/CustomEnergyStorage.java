package me.filipcrafter14.uselessthings.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergyStorage extends EnergyStorage{
	
	 public CustomEnergyStorage(int capacity)
	    {
	        super(capacity, capacity, capacity, 0);
	    }

	    public CustomEnergyStorage(int capacity, int maxTransfer)
	    {
	        super(capacity, maxTransfer, maxTransfer, 0);
	    }

	    public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract)
	    {
	        super(capacity, maxReceive, maxExtract, 0);
	    }

	    public CustomEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy)
	    {
	        super(capacity, maxReceive, maxExtract, energy);
	    }
	    
	    @Override
	    public int receiveEnergy(int maxReceive, boolean simulate) {
	    	// TODO Auto-generated method stub
	    	return super.receiveEnergy(maxReceive, simulate);
	    }
	    
	    @Override
	    public int extractEnergy(int maxExtract, boolean simulate) {
	    	// TODO Auto-generated method stub
	    	return super.extractEnergy(maxExtract, simulate);
	    }
	    
	    @Override
	    public int getEnergyStored() {
	    	// TODO Auto-generated method stub
	    	return super.getEnergyStored();
	    }
	    
	    @Override
	    public int getMaxEnergyStored() {
	    	// TODO Auto-generated method stub
	    	return super.getMaxEnergyStored();
	    }
	    
	    @Override
	    public boolean canExtract() {
	    	// TODO Auto-generated method stub
	    	return super.canExtract();
	    }
	    
	    @Override
	    public boolean canReceive() {
	    	// TODO Auto-generated method stub
	    	return super.canReceive();
	    }
	    
	    public void readFromNBT(NBTTagCompound compound) {
	    	this.energy = compound.getInt("Energy");
	    	this.capacity = compound.getInt("Capacity");
	    	this.maxReceive = compound.getInt("MaxRecive");
	    	this.maxExtract = compound.getInt("MaxExtract");
	    }
	    
	    public void writeToNBT(NBTTagCompound compound) {
	    	compound.setInt("Energy", this.energy);
	    	compound.setInt("Capacity", this.capacity);
	    	compound.setInt("MaxRecive", this.maxReceive);
	    	compound.setInt("MaxExtract", this.maxExtract);
	    }

}
