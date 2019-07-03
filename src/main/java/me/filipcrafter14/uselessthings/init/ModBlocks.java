package me.filipcrafter14.uselessthings.init;

import me.filipcrafter14.uselessthings.init.blocks.BlockGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import static me.filipcrafter14.uselessthings.init.BlockBase.register;

public class ModBlocks {
    public static Block simpleGenerator;
    public static Block simpleGeneratorUpgraded;
    public static void registerAll(RegistryEvent.Register<Block> event){
        if (!event.getName().equals(ForgeRegistries.BLOCKS.getRegistryName())) return;
/*
        simpleGenerator = register("simple_generator", new BlockGenerator(Block.Properties
                .create(Material.IRON)
                .hardnessAndResistance(3.0f)
                .sound(SoundType.METAL)
                .lightValue(3)));

 */
        simpleGeneratorUpgraded = register("simple_generator_upgraded", new BlockGenerator());
        simpleGenerator = register("simple_generator", new BlockGenerator());
    }

    /*
    Calling the other register function & also setting group and other things


    private static <T extends Block> T register(String name, T block){
        ItemBlock item = new ItemBlock(block, new Item.Properties().group(UselessThings.group));
        return register(name, block, item);
    }

    private static <T extends Block> T register(String name, T block, @Nullable ItemBlock item){
        ResourceLocation location = UselessThings.location(name);
        block.setRegistryName(location);
        ForgeRegistries.BLOCKS.register(block);
        if (item != null) ModItems.BLOCKS_TO_REGISTER.put(name, item);
        return block;
    }


     */
}
