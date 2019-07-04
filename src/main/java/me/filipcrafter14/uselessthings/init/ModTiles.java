package me.filipcrafter14.uselessthings.init;

import me.filipcrafter14.uselessthings.UselessThings;
import me.filipcrafter14.uselessthings.tiles.TileEntitySimpleGenerator;
import net.minecraft.tileentity.TileEntityType;

public class ModTiles {

    public static final TileEntityType<?> simple_generator_tile = TileEntityType.Builder.create(TileEntitySimpleGenerator::new).build(null).setRegistryName(UselessThings.location("simple_tile"));
    public static final TileEntityType<?> upgraded_generator_tile = TileEntityType.Builder.create(TileEntitySimpleGenerator::new).build(null).setRegistryName(UselessThings.location("simple_tile_up"));


/*
   // simple_generator_tile(TileEntitySimpleGenerator::new, ModBlocks.simple_generator::asBlock);

    public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {

        final TileEntityType<?>[] tile_entities = {
                simple_generator_tile = TileEntityType.Builder
                        .create(TileEntitySimpleGenerator::new)  //  ()->new TileEntitySimpleGenerator() == TileEntitySimpleGenerator::new
                        .build(null)
                        .setRegistryName(UselessThings.location("simple_tile")),

                upgraded_generator_tile = TileEntityType.Builder
                        .create(TileEntitySimpleGenerator::new)
                        .build(null)
                        .setRegistryName(UselessThings.location("upgraded_tile"))
        };

        for (TileEntityType<?> tile : tile_entities) {
            Preconditions.checkNotNull(tile.getRegistryName(), "TileEntityType: %s has a NULL registry name", tile);
            event.getRegistry().register(tile);
        }
        UselessThings.Logger.info("Registered all Tiles");
    }
*/


}
