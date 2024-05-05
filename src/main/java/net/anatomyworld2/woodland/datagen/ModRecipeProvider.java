package net.anatomyworld2.woodland.datagen;

import net.anatomyworld2.woodland.block.ModBlocks;
import net.anatomyworld2.woodland.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.resource.featuretoggle.FeatureFlags;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        BlockFamily kingFamily = new BlockFamily.Builder(ModBlocks.KING_PLANKS)
                .button(ModBlocks.KING_BUTTON)
                .fence(ModBlocks.KING_FENCE)
                .fenceGate(ModBlocks.KING_FENCE_GATE)
                .pressurePlate(ModBlocks.KING_PRESSURE_PLATE)
                .sign(ModBlocks.KING_SIGN, ModBlocks.KING_WALL_SIGN)
                .slab(ModBlocks.KING_SLAB)
                .stairs(ModBlocks.KING_STAIRS)
                .door(ModBlocks.KING_DOOR)
                .trapdoor(ModBlocks.KING_TRAPDOOR)
                .group("wooden")
                .unlockCriterionName("has_planks")
                .build();

        generateFamily(exporter, kingFamily, FeatureFlags.VANILLA_FEATURES);
        offerBarkBlockRecipe(exporter, ModBlocks.KING_WOOD, ModBlocks.KING_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_KING_WOOD, ModBlocks.STRIPPED_KING_LOG);
        offerBoatRecipe(exporter, ModItems.KING_BOAT, ModBlocks.KING_PLANKS);
        offerHangingSignRecipe(exporter, ModBlocks.KING_HANGING_SIGN, ModBlocks.STRIPPED_KING_LOG);
    }
}
