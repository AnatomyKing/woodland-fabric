package net.anatomyworld.woodland.item;

import net.anatomyworld.woodland.WoodLand;
import net.anatomyworld.woodland.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item KING_SEEDS = registerItem("king_seeds",
        new AliasedBlockItem(ModBlocks.KING_SAPLING_CROP, new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(KING_SEEDS);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WoodLand.MOD_ID, name), item);
    }


    public static  void registerModItems() {
        WoodLand.LOGGER.info("Register Mod Items for" + WoodLand.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
