package com.example.block;

import com.example.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

public class SkyBeaconBlockEntity extends BlockEntity {
    public static final int RANGE = 100;
    public static final int DURATION = 200;
    public SkyBeaconBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlocks.SKY_BEACON_TYPE, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SkyBeaconBlockEntity skyBeaconBlockEntity) {
        if (world.isClient) return;
        if (world.getTime() % 80 == 0)
            applyEffect(world, pos);
    }

    private static void applyEffect(World world, BlockPos pos) {
        int x1 = pos.getX() - RANGE;
        int y1 = pos.getY() - RANGE;
        int z1 = pos.getZ() - RANGE;
        int x2 = pos.getX() + RANGE;
        int y2 = pos.getY() + RANGE;
        int z2 = pos.getZ() + RANGE;
        for (ServerPlayerEntity player : world.getNonSpectatingEntities(ServerPlayerEntity.class, new Box(x1, y1, z1, x2, y2, z2)))
            player.addStatusEffect(new StatusEffectInstance(ModEffects.FLOATING, DURATION, 0, true, true));
        BeaconBlockEntity.playSound(world, pos, SoundEvents.BLOCK_BEACON_AMBIENT);
    }
}