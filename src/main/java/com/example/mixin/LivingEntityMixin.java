package com.example.mixin;

import com.example.effect.ModEffects;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalDoubleRef;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow public abstract boolean hasStatusEffect(StatusEffect effect);

    @Inject(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;getWorld()Lnet/minecraft/world/World;", ordinal = 0))
    private void reduceGravity(Vec3d movementInput, CallbackInfo ci, @Local(ordinal = 0) LocalDoubleRef g) {
        if (hasStatusEffect(ModEffects.FLOATING)) g.set(0.0);
    }
}