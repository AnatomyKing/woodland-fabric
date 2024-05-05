package net.anatomyworld.woodland.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.anatomyworld.woodland.world.tree.ModTrunkPlacerTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class KingTrunkPlacer extends TrunkPlacer {
    private final IntProvider branchCount;
    private final IntProvider branchHorizontalLength;
    private final UniformIntProvider branchStartOffsetFromTop;
    private final UniformIntProvider secondBranchStartOffsetFromTop;
    private final IntProvider branchEndOffsetFromTop;

    public static final Codec<KingTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            fillTrunkPlacerFields(instance).and(instance.group(
                    IntProvider.createValidatingCodec(1, 3).fieldOf("branch_count").forGetter(tp -> tp.branchCount),
                    IntProvider.createValidatingCodec(2, 16).fieldOf("branch_horizontal_length").forGetter(tp -> tp.branchHorizontalLength),
                    IntProvider.createValidatingCodec(-16, 0, UniformIntProvider.CODEC).fieldOf("branch_start_offset_from_top").forGetter(tp -> tp.branchStartOffsetFromTop),
                    IntProvider.createValidatingCodec(-16, 16).fieldOf("branch_end_offset_from_top").forGetter(tp -> tp.branchEndOffsetFromTop)
            )).apply(instance, KingTrunkPlacer::new));

    public KingTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight, IntProvider branchCount, IntProvider branchHorizontalLength, UniformIntProvider branchStartOffsetFromTop, IntProvider branchEndOffsetFromTop) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.branchCount = branchCount;
        this.branchHorizontalLength = branchHorizontalLength;
        this.branchStartOffsetFromTop = branchStartOffsetFromTop;
        this.secondBranchStartOffsetFromTop = UniformIntProvider.create(branchStartOffsetFromTop.getMin(), branchStartOffsetFromTop.getMax() - 1);
        this.branchEndOffsetFromTop = branchEndOffsetFromTop;
    }

    @Override
    public TrunkPlacerType<?> getType() {
        return ModTrunkPlacerTypes.KING_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        setToDirt(world, replacer, random, startPos.down(), config);
        int i = Math.max(0, height - 1 + branchStartOffsetFromTop.get(random));
        int j = Math.max(0, height - 1 + secondBranchStartOffsetFromTop.get(random));
        if (j >= i) {
            ++j;
        }
        boolean bl = branchCount.get(random) == 3;
        boolean bl2 = branchCount.get(random) >= 2;
        int l = bl ? height : (bl2 ? Math.max(i, j) + 1 : i + 1);
        for (int m = 0; m < l; ++m) {
            getAndSetState(world, replacer, random, startPos.up(m), config);
        }
        ArrayList<FoliagePlacer.TreeNode> list = new ArrayList<>();
        if (bl) {
            list.add(new FoliagePlacer.TreeNode(startPos.up(l), 0, false));
        }
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        Function<BlockState, BlockState> function = state -> state.withIfExists(PillarBlock.AXIS, direction.getAxis());
        list.add(generateBranch(world, replacer, random, height, startPos, config, function, direction, i, i < l - 1, mutable));
        if (bl2) {
            list.add(generateBranch(world, replacer, random, height, startPos, config, function, direction.getOpposite(), j, j < l - 1, mutable));
        }
        return list;
    }

    private FoliagePlacer.TreeNode generateBranch(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config, Function<BlockState, BlockState> withAxisFunction, Direction direction, int branchStartOffset, boolean branchBelowHeight, BlockPos.Mutable mutablePos) {
        mutablePos.set(startPos).move(Direction.UP, branchStartOffset);
        int i = height - 1 + branchEndOffsetFromTop.get(random);
        boolean bl = branchBelowHeight || i < branchStartOffset;
        int j = branchHorizontalLength.get(random) + (bl ? 1 : 0);
        BlockPos blockPos = startPos.offset(direction, j).up(i);
        int k = bl ? 2 : 1;
        for (int l = 0; l < k; ++l) {
            getAndSetState(world, replacer, random, mutablePos.move(direction), config, withAxisFunction);
        }
        Direction direction2 = blockPos.getY() > mutablePos.getY() ? Direction.UP : Direction.DOWN;
        while (mutablePos.getX() != blockPos.getX() || mutablePos.getZ() != blockPos.getZ() || mutablePos.getY() != blockPos.getY()) {
            float f = (float) Math.abs(blockPos.getY() - mutablePos.getY()) / (float) (Math.abs(blockPos.getX() - mutablePos.getX()) + Math.abs(blockPos.getZ() - mutablePos.getZ()));
            boolean bl2 = random.nextFloat() < f;
            mutablePos.move(bl2 ? direction2 : direction);
            getAndSetState(world, replacer, random, mutablePos, config, bl2 ? Function.identity() : withAxisFunction);
        }
        return new FoliagePlacer.TreeNode(blockPos.up(), 0, false);
    }
}