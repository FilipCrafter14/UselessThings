package me.filipcrafter14.uselessthings;

import me.filipcrafter14.uselessthings.lists.ItemList;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class UselessThingsGroup extends ItemGroup {
    public UselessThingsGroup() {
        super("useless_things_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemList.redstone_infused_pearl);
    }
}
