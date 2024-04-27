package net.anatomyworld.item;

import net.anatomyworld.woodland.WoodLand;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WoodLand.MOD_ID, name), item);
    }


    public static  void registerModItems() {
        WoodLand.LOGGER.info("Register Mod Items for" + WoodLand.MOD_ID);
    }
}
