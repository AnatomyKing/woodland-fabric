package net.anatomyworld.woodland;

import net.anatomyworld.woodland.block.ModBlocks;
import net.anatomyworld.woodland.item.ModItemGroups;
import net.anatomyworld.woodland.item.ModItems;
import net.anatomyworld.woodland.util.ModLootTableModifiers;
import net.anatomyworld.woodland.world.gen.ModWorldGeneration;
import net.anatomyworld.woodland.world.tree.ModTrunkPlacerTypes;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WoodLand implements ModInitializer {
	public static  final String MOD_ID = "woodland";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		StrippableBlockRegistry.register(ModBlocks.KING_LOG, ModBlocks.STRIPPED_KING_LOG);
		StrippableBlockRegistry.register(ModBlocks.KING_WOOD, ModBlocks.STRIPPED_KING_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.KING_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.KING_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_KING_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_KING_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.KING_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.KING_LEAVES, 30, 60);

		ModWorldGeneration.generateModWorldGen();
		ModLootTableModifiers.modifyLootTables();
		ModTrunkPlacerTypes.register();
	}
}