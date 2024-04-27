package net.anatomyworld.item;

import net.anatomyworld.woodland.WoodLand;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup WOODLAND_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(WoodLand.MOD_ID, "woodlandtab"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.woodlandtab"))
                    .icon(() -> new ItemStack(ModItems.KING_SEEDS)).entries((displayContext, entries) -> {
                        entries.add(ModItems.KING_SEEDS);


                    }).build());

    public static void registerItemGroups() {
        WoodLand.LOGGER.info("Registering Item Groups for " +WoodLand.MOD_ID);
    }
}
