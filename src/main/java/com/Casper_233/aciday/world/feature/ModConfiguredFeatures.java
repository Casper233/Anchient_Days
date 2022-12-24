package com.Casper_233.aciday.world.feature;

import com.Casper_233.aciday.Main;
import com.Casper_233.aciday.init.BlockInit;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister
            .create(Registry.CONFIGURED_FEATURE_REGISTRY, Main.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_DEBRIS_ORES = Suppliers
            .memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.DEBRIS_ORE
                            .get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.DEEPSLATE_DEBRIS_ORE
                            .get().defaultBlockState())
                    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BRONZE_ORES = Suppliers
            .memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.BRONZE_ORE
                            .get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.DEEPSLATE_BRONZE_ORE
                            .get().defaultBlockState())
            ));

    public static final RegistryObject<ConfiguredFeature<?, ?>> DEBRIS_ORES = CONFIGURED_FEATURES.register(
            "debris_ores", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_DEBRIS_ORES
                    .get(), 7)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BRONZE_ORES = CONFIGURED_FEATURES.register(
            "bronze_ores", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BRONZE_ORES
                    .get(), 7)));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
