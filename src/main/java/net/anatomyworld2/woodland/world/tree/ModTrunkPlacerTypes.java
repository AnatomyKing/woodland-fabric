package net.anatomyworld2.woodland.world.tree;

import net.anatomyworld2.woodland.WoodLand;
import net.anatomyworld2.woodland.mixin.TrunkPlacerTypeMixin;
import net.anatomyworld2.woodland.world.tree.custom.KingTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> KING_TRUNK_PLACER = TrunkPlacerTypeMixin.callRegister("king_trunk_placer", KingTrunkPlacer.CODEC);

    public static void register() {
     WoodLand.LOGGER.info("Registering Trunk Placers for " + WoodLand.MOD_ID);
    }
}
