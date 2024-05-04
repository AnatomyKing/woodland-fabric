package net.anatomyworld.woodland.block.entity;

import net.anatomyworld.woodland.WoodLand;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.anatomyworld.woodland.block.ModBlocks.*;

public class ModBlockEntities {

    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(WoodLand.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new,
                    KING_SIGN, KING_WALL_SIGN
            ).build());

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register
            (Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(WoodLand.MOD_ID, "mod_hanging_sign_entity"),
                    FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new,
                            KING_HANGING_SIGN, KING_WALL_HANGING_SIGN
                    ).build());


    public static void registerBlockEntities() {
        WoodLand.LOGGER.info("Registering Block Entities for " + WoodLand.MOD_ID);
    }
}