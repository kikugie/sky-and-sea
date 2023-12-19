package com.example.effect;

import com.example.Reference;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;

public class ModEffects {
    public static final StatusEffect FLOATING = StatusEffects.register(Reference.id("floating").toString(), new StatusEffect(StatusEffectCategory.BENEFICIAL, 0x4DA6FF));

    public static void init() {

    }
}