package net.anatomyworld2.woodland.block;

//import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
//import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
//import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
//import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.anatomyworld2.woodland.WoodLand;
import net.anatomyworld2.woodland.block.custom.*;
import net.anatomyworld2.woodland.util.ModWoodTypes;
import net.anatomyworld2.woodland.world.tree.ModSaplingGenerators;
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
            new ButtonBlock(BlockSetType.OAK, 10,FabricBlockSettings.copyOf(Blocks.OAK_BUTTON)));
    public  static final Block KING_SLAB = registerBlock("king_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
    public static final Block KING_PRESSURE_PLATE = registerBlock("king_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, // Corrected order
                    FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)));
    public  static final Block KING_FENCE = registerBlock("king_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
    public  static final Block KING_FENCE_GATE = registerBlock("king_fence_gate",
            new FenceGateBlock(WoodType.OAK,FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)));
    public  static final Block KING_DOOR = registerBlock("king_door",
            new DoorBlock(BlockSetType.OAK,FabricBlockSettings.copyOf(Blocks.OAK_DOOR)));
    public  static final Block KING_TRAPDOOR = registerBlock("king_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK,FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)));

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
            new SaplingBlock(ModSaplingGenerators.KINGSAP,FabricBlockSettings.copyOf(Blocks.OAK_SAPLING)));

    public static final Block KING_SAPLING_CROP = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_sapling_crop"),
            new KingCropBlock(FabricBlockSettings.copyOf(Blocks.TORCHFLOWER_CROP)));

    public static final Block KING_SIGN = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_sign"),
            new ModSignBlock(FabricBlockSettings.copyOf(Blocks.OAK_SIGN), ModWoodTypes.KING));
    public static final Block KING_WALL_SIGN = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_wall_sign"),
            new ModWallSignBlock(ModWoodTypes.KING,FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).dropsLike(ModBlocks.KING_SIGN)));
    public static final Block KING_HANGING_SIGN = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_hanging_sign"),
            new ModHangingSignBlock(ModWoodTypes.KING,FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block KING_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_wall_hanging_sign"),
            new ModWallHangingSignBlock(ModWoodTypes.KING,FabricBlockSettings.copyOf(Blocks.OAK_SIGN).dropsLike(ModBlocks.KING_HANGING_SIGN)));

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
