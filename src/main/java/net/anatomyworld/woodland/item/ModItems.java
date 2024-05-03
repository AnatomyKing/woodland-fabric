package net.anatomyworld.woodland.item;

import net.anatomyworld.woodland.WoodLand;
import net.anatomyworld.woodland.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item KING_SEEDS = registerItem("king_seeds",
        new AliasedBlockItem(ModBlocks.KING_SAPLING_CROP, new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(KING_SEEDS);
    }

    public static final Item KING_SIGN = registerItem("king_sign",
            new SignItem(new FabricItemSettings().maxCount(16), ModBlocks.KING_SIGN, ModBlocks.KING_WALL_SIGN));
    public static final Item KING_HANGING_SIGN = registerItem("king_hanging_sign",
            new HangingSignItem(ModBlocks.KING_HANGING_SIGN, ModBlocks.KING_WALL_HANGING_SIGN, new FabricItemSettings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WoodLand.MOD_ID, name), item);
    }


    public static  void registerModItems() {
        WoodLand.LOGGER.info("Register Mod Items for" + WoodLand.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
