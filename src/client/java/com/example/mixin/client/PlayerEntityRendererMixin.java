package com.example.mixin.client;

import com.example.effect.ModEffects;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
    @ModifyExpressionValue(method = "setupTransforms(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/client/util/math/MatrixStack;FFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/AbstractClientPlayerEntity;isTouchingWater()Z"))
    private boolean fakeTouchingWater(boolean original, @Local(argsOnly = true) AbstractClientPlayerEntity player) {
        return player.hasStatusEffect(ModEffects.FLOATING) || original;
    }
}