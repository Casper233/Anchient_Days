package com.Casper_233.aciday;

import com.Casper_233.aciday.effects.BaseEffect;
import com.Casper_233.aciday.init.BlockInit;
import com.Casper_233.aciday.init.EffectInit;
import com.Casper_233.aciday.init.ItemInit;
import com.Casper_233.aciday.world.feature.ModConfiguredFeatures;
import com.Casper_233.aciday.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MOD_ID)
public class Main
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "aciday";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    //Inventory
    public static final CreativeModeTab ACIDAY_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.DEBRIS_ORE.get());
        }
    };

    public Main()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus   ();

        // Register the commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::setup);

        //Items/Blocks
        ItemInit.ITEMS.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);

        //Effects/potions
        //EffectInit.EFFECTS.register(modEventBus);

        //Ores
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("ACIDAY loading!");
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        LOGGER.info("ACIDAY loaded successfully");
    }

    //You can use EventBusSubscriber automatically register static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
