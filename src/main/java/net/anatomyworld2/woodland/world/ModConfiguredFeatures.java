package net.anatomyworld2.woodland.world;

import net.anatomyworld2.woodland.WoodLand;
import net.anatomyworld2.woodland.block.ModBlocks;
import net.anatomyworld2.woodland.world.tree.custom.KingTrunkPlacer;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> KING_TREE = registerKey("king_tree");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {


        register(context, KING_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.KING_LOG),
                new KingTrunkPlacer(
                        5,  // Base height
                        2,  // First random height
                        4,  // Second random height
                        UniformIntProvider.create(2, 3),  // Branch count
                        UniformIntProvider.create(2, 4),  // Branch horizontal length
                        UniformIntProvider.create(-3, 0),  // Branch start offset from top
                        UniformIntProvider.create(-3, 3)  // Branch end offset from top
                ),
                BlockStateProvider.of(ModBlocks.KING_LEAVES),
                new CherryFoliagePlacer(
                        UniformIntProvider.create(3, 4),  // Foliage radius (adjusted range)
                        UniformIntProvider.create(0, 1),   // Foliage offset
                        UniformIntProvider.create(5, 6),   // Foliage height (adjusted range)
                        0.3f,   // Foliage spread density
                        0.9f,   // Foliage height factor
                        0.1f,   // Foliage branch density
                        0.5f    // Foliage leaf density
                ),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(WoodLand.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

