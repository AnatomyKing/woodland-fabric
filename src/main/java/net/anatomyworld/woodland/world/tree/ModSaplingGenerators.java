package net.anatomyworld.woodland.world.tree;

import net.anatomyworld.woodland.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static  final SaplingGenerator KINGSAP =
            new SaplingGenerator("kingsap", 0f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(ModConfiguredFeatures.KING_TREE),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty());
}
