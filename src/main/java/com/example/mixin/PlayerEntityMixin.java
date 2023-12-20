package com.example.mixin;

import com.example.effect.ModEffects;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @WrapOperation(method = "updateSwimming", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;updateSwimming()V"))
    private void swimIfFloating(PlayerEntity instance, Operation<Void> original) {
        original.call(instance);
        if (!hasStatusEffect(ModEffects.FLOATING)) return;
        setSwimming(!hasVehicle());
    }

    @ModifyArg(method = "updatePose", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;setPose(Lnet/minecraft/entity/EntityPose;)V"), index = 0)
    private EntityPose setSwimmingPose(EntityPose par1) {
        return !hasStatusEffect(ModEffects.FLOATING) ? par1 : EntityPose.SWIMMING;
    }
}