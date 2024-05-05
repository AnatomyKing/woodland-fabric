package net.anatomyworld.woodland.util;

import net.anatomyworld.woodland.WoodLand;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.block.WoodType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public record ModWoodTypes() {
    public static final WoodType KING = new WoodTypeBuilder()
            .soundGroup(BlockSoundGroup.WOOD) // Customize sound group if needed
            .hangingSignSoundGroup(BlockSoundGroup.HANGING_SIGN) // Customize hanging sign sound group if needed
            .fenceGateCloseSound(SoundEvents.BLOCK_FENCE_GATE_CLOSE) // Customize fence gate close sound if needed
            .fenceGateOpenSound(SoundEvents.BLOCK_FENCE_GATE_OPEN) // Customize fence gate open sound if needed
            .build(new Identifier(WoodLand.MOD_ID, "king"), ModBlockSetTypes.KING);
}
