package net.anatomyworld.woodland.datagen;

import net.anatomyworld.woodland.block.ModBlocks;
import net.anatomyworld.woodland.block.custom.KingCropBlock;
import net.anatomyworld.woodland.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool kingPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KING_PLANKS);

        kingPool.stairs(ModBlocks.KING_STAIRS);
        kingPool.slab(ModBlocks.KING_SLAB);
        kingPool.button(ModBlocks.KING_BUTTON);
        kingPool.pressurePlate(ModBlocks.KING_PRESSURE_PLATE);
        kingPool.fence(ModBlocks.KING_FENCE);
        kingPool.fenceGate(ModBlocks.KING_FENCE_GATE);


        blockStateModelGenerator.registerDoor(ModBlocks.KING_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.KING_TRAPDOOR);

        blockStateModelGenerator.registerLog(ModBlocks.KING_LOG).log(ModBlocks.KING_LOG).wood(ModBlocks.KING_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_KING_LOG).log(ModBlocks.STRIPPED_KING_LOG).wood(ModBlocks.STRIPPED_KING_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KING_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.KING_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.KING_SAPLING_CROP, BlockStateModelGenerator.TintType.NOT_TINTED, KingCropBlock.AGE, 0, 1, 2);

//        BlockStateModelGenerator.BlockTexturePool king_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KING_PLANKS);
//        king_pool.family(ModBlocks.KING_FAMILY);
    }



    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        itemModelGenerator.register(ModItems.HANGING_KING_SIGN, Models.GENERATED);

    }
}
