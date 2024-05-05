package net.anatomyworld2.woodland.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.anatomyworld2.woodland.WoodLand;
import net.anatomyworld2.woodland.block.ModBlocks;
import net.anatomyworld2.woodland.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModBoats {
    public static final Identifier KING_BOAT_ID = new Identifier(WoodLand.MOD_ID, "king_boat");
    public static final Identifier KING_CHEST_BOAT_ID = new Identifier(WoodLand.MOD_ID, "king_chest_boat");

    public static final RegistryKey<TerraformBoatType> KING_BOAT_KEY = TerraformBoatTypeRegistry.createKey(KING_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType kingBoat = new TerraformBoatType.Builder()
                .item(ModItems.KING_BOAT)
                .chestItem(ModItems.KING_CHEST_BOAT)
                .planks(ModBlocks.KING_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE,KING_BOAT_KEY, kingBoat);
    }
}
