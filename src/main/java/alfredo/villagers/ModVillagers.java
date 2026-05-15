package alfredo.villagers;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.lang3.StringUtils;

import alfredo.AlFredo;
import alfredo.blocks.ModBlocks;
import alfredo.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> AL_FREDO_POI_KEY = registerPOIKey("al_fredo_poi");
    public static final PointOfInterestType AL_FREDO_POI = registerPOI("al_fredo_poi", ModBlocks.PLANT_BOMB);

    public static final RegistryKey<VillagerProfession> TERRORIST_KEY = RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION,
            Identifier.of(AlFredo.MOD_ID, "terrorist"));
    public static final VillagerProfession TERRORIST = registerProfession("terrorist", AL_FREDO_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(AlFredo.MOD_ID, name),
                new VillagerProfession(Text.literal(StringUtils.capitalize(name)), entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(ModItems.THRUST_BOMB), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_ARMORER));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(AlFredo.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPOIKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(AlFredo.MOD_ID, name));
    }

    public static void registerModVillagers() {
        AlFredo.LOGGER.info("Registering Villagers for " + AlFredo.MOD_ID);

    }
}
