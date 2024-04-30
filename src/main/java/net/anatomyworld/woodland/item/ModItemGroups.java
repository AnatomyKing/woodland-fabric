package net.anatomyworld.woodland.item;

import net.anatomyworld.woodland.block.ModBlocks;
import net.anatomyworld.woodland.WoodLand;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup WOODLAND_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(WoodLand.MOD_ID, "woodlandtab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.woodlandtab"))
                    .icon(() -> new ItemStack(ModItems.KING_SEEDS)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KING_SEEDS);
                        entries.add(ModBlocks.KING_PLANKS);
                        entries.add(ModBlocks.KING_STAIRS);
                        entries.add(ModBlocks.KING_SLAB);
                        entries.add(ModBlocks.KING_FENCE);
                        entries.add(ModBlocks.KING_FENCE_GATE);
                        entries.add(ModBlocks.KING_DOOR);
                        entries.add(ModBlocks.KING_PRESSURE_PLATE);
                        entries.add(ModBlocks.KING_BUTTON);
                        entries.add(ModBlocks.KING_LEAVES);
                        entries.add(ModBlocks.KING_WOOD);
                        entries.add(ModBlocks.KING_LOG);
                        entries.add(ModBlocks.STRIPPED_KING_LOG);
                        entries.add(ModBlocks.STRIPPED_KING_WOOD);

                    }).build());

    public static void registerItemGroups() {
        WoodLand.LOGGER.info("Registering Item Groups for " +WoodLand.MOD_ID);
    }
}
