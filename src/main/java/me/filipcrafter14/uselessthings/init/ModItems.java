package me.filipcrafter14.uselessthings.init;

import me.filipcrafter14.uselessthings.UselessThings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {

    public static Item redstone_infused_shard;
    static final Map<String, ItemBlock> BLOCKS_TO_REGISTER = new LinkedHashMap<>();

    public static void registerAll(RegistryEvent.Register<Item> event){
        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;
        //Blocks
        BLOCKS_TO_REGISTER.forEach(ModItems::register);

        //Items
        redstone_infused_shard = register("redstone_infused_shard", new Item(new Item.Properties().group(UselessThings.group)));

    }

    private static <T extends Item> T register(String name, T item){
        ResourceLocation location = UselessThings.location(name);
        item.setRegistryName(location);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

}
