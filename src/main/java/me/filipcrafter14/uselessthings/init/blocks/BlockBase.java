package me.filipcrafter14.uselessthings.init;

import me.filipcrafter14.uselessthings.UselessThings;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class BlockBase extends Block {
    public BlockBase() {

        super(Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.0f).lightValue(3));
    }

    public static <T extends Block> T register(String name, T block) {
        ItemBlock item = new ItemBlock(block, new Item.Properties().group(UselessThings.group));
        return register(name, block, item);
    }

    private static <T extends Block> T register(String name, T block, @Nullable ItemBlock item) {
        ResourceLocation location = UselessThings.location(name);
        block.setRegistryName(location);
        ForgeRegistries.BLOCKS.register(block);
        if (item != null) ModItems.BLOCKS_TO_REGISTER.put(name, item);
        return block;
    }
}
