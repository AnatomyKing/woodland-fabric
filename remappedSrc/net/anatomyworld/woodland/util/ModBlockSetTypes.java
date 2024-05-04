package net.anatomyworld.woodland.util;

import net.minecraft.block.BlockSetType;

public class ModBlockSetTypes {
    public static final BlockSetType KING = ModBlockSetTypes.register(new BlockSetType("king"));

    private static BlockSetType register(BlockSetType blockSetType) {
        return blockSetType;
    }
}
