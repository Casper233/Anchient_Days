package com.Casper_233.aciday.world.feature;

import com.Casper_233.aciday.Main;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.Casper_233.aciday.world.feature.ModOrePlacement.commonOrePlacement;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.
            PLACED_FEATURE_REGISTRY, Main.MOD_ID);

    //ore-placement
    public static final RegistryObject<PlacedFeature> DEBRIS_ORE_PLACED = PLACED_FEATURES.register(
            "debris_ore_placed", () -> new PlacedFeature(ModConfiguredFeatures.DEBRIS_ORES.getHolder().get(),
                    commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-60),
                            VerticalAnchor.aboveBottom(60)))));

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
