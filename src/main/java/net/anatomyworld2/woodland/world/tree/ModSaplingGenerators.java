package net.anatomyworld2.woodland.world.tree;

import net.anatomyworld2.woodland.world.ModConfiguredFeatures;
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
