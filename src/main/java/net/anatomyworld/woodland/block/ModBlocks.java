package net.anatomyworld.woodland.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.anatomyworld.woodland.WoodLand;
import net.anatomyworld.woodland.block.custom.KingCropBlock;
import net.anatomyworld.woodland.world.tree.KingSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
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
            new KingCropBlock(FabricBlockSettings.copyOf(Blocks.TORCHFLOWER_CROP)));

    public static final Identifier KING_SIGN_TEXTURE = new Identifier(WoodLand.MOD_ID,"entity/signs/king");
    public static final Identifier KING_HANGING_SIGN_TEXTURE = new Identifier(WoodLand.MOD_ID,"entity/signs/hanging/king");
    public static final Identifier KING_HANGING_GUI_SIGN_TEXTURE = new Identifier(WoodLand.MOD_ID,"textures/gui/hanging_signs/king");

    public static final Block STANDING_KING_SIGN = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_standing_sign"),
            new TerraformSignBlock(KING_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block WALL_KING_SIGN = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_wall_sign"),
            new TerraformWallSignBlock(KING_SIGN_TEXTURE,FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block HANGING_KING_SIGN = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_hanging_sign"),
            new TerraformHangingSignBlock(KING_HANGING_SIGN_TEXTURE,KING_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block WALL_HANGING_KING_SIGN = Registry.register(Registries.BLOCK, new Identifier(WoodLand.MOD_ID, "king_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(KING_HANGING_SIGN_TEXTURE,KING_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));

    public static final BlockFamily KING_FAMILY = BlockFamilies.register(ModBlocks.KING_PLANKS)
            .sign(ModBlocks.STANDING_KING_SIGN,ModBlocks.WALL_KING_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

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
