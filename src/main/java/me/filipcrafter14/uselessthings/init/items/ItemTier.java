package me.filipcrafter14.uselessthings.init;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ItemTier implements IItemTier {

    dust(10.0f, 9f, 800, 3, 25, ModItems.pearl_shard);

    private float attackDamage, efficency;
    private int durabillity, harvestLevel, enchantabillity;
    private Item repairMaterial;

    private ItemTier(float attackDamage, float efficency, int durabillity, int harvestLevel, int enchantabillity, Item repairMaterial) {
        this.attackDamage = attackDamage;
        this.efficency = efficency;
        this.durabillity = durabillity;
        this.harvestLevel = harvestLevel;
        this.enchantabillity = enchantabillity;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return this.durabillity;
    }

    @Override
    public float getEfficiency() {
        return this.efficency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantabillity;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}
