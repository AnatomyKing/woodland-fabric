package net.anatomyworld.woodland.util;

import net.anatomyworld.woodland.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    private static final Identifier SNIFFER_DIGGING_ID =
            new Identifier("minecraft", "gameplay/sniffer_digging");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && SNIFFER_DIGGING_ID.equals(id)) {
                tableBuilder.modifyPools(builder -> builder.with(ItemEntry.builder(ModItems.KING_SEEDS)));
            }
        });
    }
}
