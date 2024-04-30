package net.anatomyworld.woodland.block;

import net.anatomyworld.woodland.WoodLand;
import net.anatomyworld.woodland.block.custom.KingCropBlock;
import net.anatomyworld.woodland.world.tree.KingSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    ///king wood
    public  static final Block KING_PLANKS = registerBlock("king_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
    public  static final Block KING_STAIRS = registerBlock("king_stairs",
            new StairsBlock(ModBlocks.KING_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
    public  static final Block KING_BUTTON = registerBlock("king_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON), BlockSetType.OAK, 10, true));
    public  static final Block KING_SLAB = registerBlock("king_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    public  static final Block KING_PRESSURE_PLATE = registerBlock("king_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
    public  static final Block KING_FENCE = registerBlock("king_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public  static final Block KING_FENCE_GATE = registerBlock("king_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
    public  static final Block KING_DOOR = registerBlock("king_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
    public  static final Block KING_TRAPDOOR = registerBlock("king_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public  static final Block KING_LOG = registerBlock("king_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public  static final Block KING_WOOD = registerBlock("king_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public  static final Block STRIPPED_KING_LOG = registerBlock("stripped_king_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f)));
    public  static final Block STRIPPED_KING_WOOD = registerBlock("stripped_king_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public  static final Block KING_LEAVES = registerBlock("king_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4f).nonOpaque()));

    public  static final Block KING_SAPLING = registerBlock("king_sapling",
            new SaplingBlock(new KingSaplingGenerator(),FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Block KING_SAPLING_CROP = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_sapling_crop"),
            new KingCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(WoodLand.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        WoodLand.LOGGER.info("Registering ModBlocks for " + WoodLand.MOD_ID);
    }
}
