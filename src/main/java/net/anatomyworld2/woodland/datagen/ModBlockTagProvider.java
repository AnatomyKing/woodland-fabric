package net.anatomyworld2.woodland.datagen;

import net.anatomyworld2.woodland.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.KING_PLANKS)
                .add(ModBlocks.KING_LOG)
                .add(ModBlocks.KING_WOOD)
                .add(ModBlocks.STRIPPED_KING_LOG)
                .add(ModBlocks.STRIPPED_KING_WOOD);


        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.KING_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.KING_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.KING_LOG)
                .add(ModBlocks.KING_WOOD)
                .add(ModBlocks.STRIPPED_KING_LOG)
                .add(ModBlocks.STRIPPED_KING_WOOD);


    }
}