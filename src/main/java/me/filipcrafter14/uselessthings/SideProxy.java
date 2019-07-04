package me.filipcrafter14.uselessthings;

import me.filipcrafter14.uselessthings.init.ModBlocks;
import me.filipcrafter14.uselessthings.init.ModItems;
import me.filipcrafter14.uselessthings.init.ModTiles;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SideProxy {
    SideProxy(){

        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModBlocks::registerAll);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModItems::registerAll);

    }

    private static void commonSetup(FMLCommonSetupEvent event){

    }

    public static class Client extends SideProxy {

        public Client() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
        }
        private static void clientSetup(FMLClientSetupEvent event) {

        }
    }

    public static class Server extends SideProxy {

        public Server() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);
        }
        private static void serverSetup(FMLDedicatedServerSetupEvent event) {

        }
    }

}
