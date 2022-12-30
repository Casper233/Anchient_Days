package com.Casper_233.aciday.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

public class EffectAncient extends BaseEffect{
    public EffectAncient(MobEffectCategory type, int color, boolean isInstant) {
        super(type, color, isInstant);
    }

    //time
    @Override
    protected boolean canApplyEffect(int remainingTicks, int level) {
        return remainingTicks % 10 == 0;
    }

    @Override
    public void applyEffectTick(LivingEntity living, int amplified) {
        amplified ++;
        Random ran = new Random();
        int co = ran.nextInt(5);
        if(living instanceof Player)
            ((Player)living).causeFoodExhaustion(2F*amplified);
        living.hurt(DamageSource.WITHER, 0.5F*amplified);

    }

    @Override
    public boolean isBeneficial() {
        return false;
    }
}
