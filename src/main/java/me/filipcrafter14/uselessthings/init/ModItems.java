package me.filipcrafter14.uselessthings.init;

import me.filipcrafter14.uselessthings.UselessThings;
import me.filipcrafter14.uselessthings.init.items.ItemCustomAxe;
import me.filipcrafter14.uselessthings.init.items.ItemCustomPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {


    public static Item redstone_infused_shard;
    public static Item redstone_infused_pearl;
    public static Item pearl_shard;

    public static Item old_pade;
    public static Item rusty_sword;
    public static Item dusty_pickaxe;
    public static Item broken_axe;




    static final Map<String, ItemBlock> BLOCKS_TO_REGISTER = new LinkedHashMap<>();

    public static void registerAll(RegistryEvent.Register<Item> event){
        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;

        //Blocks
        BLOCKS_TO_REGISTER.forEach(ModItems::register);

        //Items
        pearl_shard = register("pearl_shard", new Item(new Item.Properties()
                .group(UselessThings.group)));
        redstone_infused_shard = register("redstone_infused_shard", new Item(new Item.Properties()
                .group(UselessThings.group)));
        redstone_infused_pearl = register("redstone_infused_pearl", new Item(new Item.Properties()
                .group(UselessThings.group)));
        old_pade = register("old_pade", new ItemSpade(
                ItemTier.dust,
                -3.0f,
                6.0f,
                new Item.Properties()
                        .group(UselessThings.group)));
        rusty_sword = register("rusty_sword", new ItemSword(
                ItemTier.dust,
                3,
                6.0f,
                new Item.Properties()
                        .group(UselessThings.group)));
        broken_axe = register("broken_axe", new ItemCustomAxe(
                ItemTier.dust,
                -3.0f,
                6.0f,
                new Item.Properties()
                        .group(UselessThings.group)));
        dusty_pickaxe = register("dusty_pickaxe", new ItemCustomPickaxe(
                ItemTier.dust,
                -3,
                6.0f,
                new Item.Properties()
                        .group(UselessThings.group)));

    }

    private static <T extends Item> T register(String name, T item){
        ResourceLocation location = UselessThings.location(name);
        item.setRegistryName(location);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

}
