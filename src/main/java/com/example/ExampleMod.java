package com.example;

import com.example.block.ModBlocks;
import com.example.effect.ModEffects;
import com.example.item.ModItems;
import net.fabricmc.api.ModInitializer;

public class ExampleMod implements ModInitializer {

	@Override
	public void onInitialize() {
		ModEffects.init();
		ModBlocks.init();
		ModItems.init();
	}
}