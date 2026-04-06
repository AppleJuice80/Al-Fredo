package alfredo.items;

import alfredo.AlFredo;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item THRUST_BOMB = registerItem("thrust_bomb");
    public static final Item PLANT_BOMB = registerItem("plant_bomb");

    public static final Item NEW_AND_IMPROVED_STATE_OF_THE_ART_LIFE_VEST = registerItem(
            "new_and_improved_state_of_the_art_life_vest");

    private static Item registerItem(String name) {
        Identifier id = Identifier.of(AlFredo.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().registryKey(key);

        return Registry.register(Registries.ITEM, id, new Item(settings));
    }

    public static void registerModItems() {
        AlFredo.LOGGER.info("Registering Mod Items for " + AlFredo.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(THRUST_BOMB);
            entries.add(NEW_AND_IMPROVED_STATE_OF_THE_ART_LIFE_VEST);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PLANT_BOMB);
        });
    }
}
