package net.anatomyworld.woodland.datagen;

import net.anatomyworld.woodland.block.ModBlocks;
import net.anatomyworld.woodland.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.data.family.BlockFamilies.register;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        BlockFamily kingFamily = register(ModBlocks.KING_PLANKS)
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
        generateFamily(exporter, kingFamily);
        offerBarkBlockRecipe(exporter, ModBlocks.KING_WOOD, ModBlocks.KING_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_KING_WOOD, ModBlocks.STRIPPED_KING_LOG);
        offerBoatRecipe(exporter, ModItems.KING_BOAT, ModBlocks.KING_PLANKS);
        offerHangingSignRecipe(exporter, ModBlocks.KING_HANGING_SIGN, ModBlocks.STRIPPED_KING_LOG);

    }
}
