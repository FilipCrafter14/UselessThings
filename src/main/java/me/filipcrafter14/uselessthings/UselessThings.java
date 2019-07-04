package me.filipcrafter14.uselessthings;


import me.filipcrafter14.uselessthings.init.ModTiles;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntityType;
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
    public static final Logger Logger = LogManager.getLogger(MOD_ID);
    public static final ItemGroup group = new UselessThingsGroup(); //TODO: if a lot of item in mod extend to more groups!

    public UselessThings(){
        instance = this;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
        MinecraftForge.EVENT_BUS.register(this);

        DistExecutor.runForDist(
                () -> SideProxy.Client::new,
                () -> SideProxy.Server::new
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
        public static void registerTE(final RegistryEvent.Register<TileEntityType<?>> event){
            final TileEntityType<?>[] tile = {
                    ModTiles.simple_generator_tile,
                    ModTiles.upgraded_generator_tile
            };
            event.getRegistry().registerAll(tile);
            UselessThings.Logger.info("Registered all Tiles");
        }
    }

    public static ResourceLocation location(String name){
        return new ResourceLocation(MOD_ID, name);
    }


}
