package com.example.block;

import com.example.Reference;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModBlocks {
    public static final Block SKY_BEACON = register("sky_beacon", new SkyBeaconBlock(FabricBlockSettings.copy(Blocks.BEACON)));
    public static final BlockEntityType<SkyBeaconBlockEntity> SKY_BEACON_TYPE = BlockEntityType.create(Reference.id("sky_beacon").toString(), BlockEntityType.Builder.create(SkyBeaconBlockEntity::new, SKY_BEACON));

    private static Block register(String name, Block block) {
        return Registry.register(Registries.BLOCK, Reference.id(name), block);
    }

    public static void init() {

    }
}