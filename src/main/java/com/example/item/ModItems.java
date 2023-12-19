package com.example.item;

import com.example.Reference;
import com.example.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final BlockItem SKY_BEACON = register("sky_beacon", ModBlocks.SKY_BEACON);

    private static BlockItem register(String name, Block block) {
        return Registry.register(Registries.ITEM, Reference.id(name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(SKY_BEACON));
    }
}