package net.anatomyworld.woodland.datagen;

import net.anatomyworld.woodland.block.ModBlocks;
import net.anatomyworld.woodland.block.custom.KingCropBlock;
import net.anatomyworld.woodland.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.KING_PLANKS);
        addDrop(ModBlocks.KING_BUTTON);
        addDrop(ModBlocks.KING_STAIRS);
        addDrop(ModBlocks.KING_FENCE);
        addDrop(ModBlocks.KING_TRAPDOOR);
        addDrop(ModBlocks.KING_FENCE_GATE);
        addDrop(ModBlocks.KING_PRESSURE_PLATE);

        addDrop(ModBlocks.KING_DOOR, doorDrops(ModBlocks.KING_DOOR));
        addDrop(ModBlocks.KING_SLAB, slabDrops(ModBlocks.KING_SLAB));

        addDrop(ModBlocks.KING_LOG);
        addDrop(ModBlocks.KING_WOOD);
        addDrop(ModBlocks.STRIPPED_KING_LOG);
        addDrop(ModBlocks.STRIPPED_KING_WOOD);
        addDrop(ModBlocks.KING_SAPLING);

        addDrop(ModBlocks.KING_LEAVES, leavesDrops(ModBlocks.KING_LEAVES, ModBlocks.KING_SAPLING, 0.005f));

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.KING_SAPLING_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(KingCropBlock.AGE, 2));

        addDrop(ModBlocks.KING_SAPLING_CROP, cropDrops(ModBlocks.KING_SAPLING_CROP, Item.fromBlock(ModBlocks.KING_SAPLING), ModItems.KING_SEEDS, builder));

    }
}
