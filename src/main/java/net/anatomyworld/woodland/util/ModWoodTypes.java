package net.anatomyworld.woodland.util;

import net.anatomyworld.woodland.WoodLand;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;

public record ModWoodTypes() {
    public static final WoodType KING = WoodTypeRegistry.register(new Identifier(WoodLand.MOD_ID, "king"),ModBlockSetTypes.KING);
}
