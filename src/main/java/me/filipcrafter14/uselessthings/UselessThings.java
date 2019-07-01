package me.filipcrafter14.uselessthings;


import me.filipcrafter14.uselessthings.init.SideProxy;
import me.filipcrafter14.uselessthings.lists.BlockList;
import me.filipcrafter14.uselessthings.lists.ItemList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(UselessThings.MOD_ID)
public class UselessThings {

    public static UselessThings instance;
    public static final String MOD_ID = "ut";
    private static final Logger Logger = LogManager.getLogger(MOD_ID);
    public static final ItemGroup group = new UselessThingsGroup(); //TODO: if a lot of item in mod extend to more groups!

    public UselessThings(){
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        MinecraftForge.EVENT_BUS.register(this);

        DistExecutor.runForDist(
                () -> () -> new SideProxy.Client(),
                () -> () -> new SideProxy.Server()
        );
    }

    private void setup(final FMLCommonSetupEvent event){

        Logger.info("Setup method registered!");

    }

    private void clientRegistries(final FMLClientSetupEvent event){

        Logger.info("clientRegistries method registered!");

    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents{
        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event){

            event.getRegistry().registerAll(

            //Items
            ItemList.redstone_infused_shard = new Item(new Item.Properties().group(group)).setRegistryName(location("redstone_infused_shard")),
            ItemList.redstone_infused_shard = new Item(new Item.Properties().group(group)).setRegistryName(location("redstone_infused_pearl")),
            ItemList.pearl_shard = new Item(new Item.Properties().group(group)).setRegistryName(location("pearl_shard")));

            Logger.info("Items registered!");
        }

        public static void registerBlocks(final RegistryEvent.Register<Block> event){

            event.getRegistry().registerAll(

            //Block
            BlockList.simple_generator = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f).lightValue(3).sound(SoundType.METAL)).setRegistryName(location("simple_generator")));

            Logger.info("Blocks registered!");
        }
    }

    public static ResourceLocation location(String name){
        return new ResourceLocation(MOD_ID, name);
    }


}
