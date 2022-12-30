package com.Casper_233.aciday.init;

import com.Casper_233.aciday.effects.EffectAncient;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectInit {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
            "aciday");
    public static RegistryObject<MobEffect> BURN = EFFECTS.register("Ancient",()->
    {
        return new EffectAncient(MobEffectCategory.HARMFUL, 0x000033, false)
                .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                        "7107DE5E-7CE8-4030-940E-514C1F160890", (double)-0.25F, AttributeModifier.Operation.
                                MULTIPLY_TOTAL);
    });
}
