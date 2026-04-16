package alfredo.blocks;

import alfredo.AlFredo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {
	public static final Block PLANT_BOMB = registerBlock("plant_bomb", AbstractBlock.Settings.create().strength(0.25f).sounds(BlockSoundGroup.GRASS));
	
	public static final Block WIRE = registerBlock("wire", AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD));

	private static Block registerBlock(String name, AbstractBlock.Settings block_settings) {
		Identifier id = Identifier.of(AlFredo.MOD_ID, name);
		RegistryKey<Item> itemkey = RegistryKey.of(RegistryKeys.ITEM, id);
		RegistryKey<Block> blockkey = RegistryKey.of(RegistryKeys.BLOCK, id);

		Item.Settings itemsettings = new Item.Settings().registryKey(itemkey);
		Block block = new Block(block_settings.registryKey(blockkey));

		Registry.register(Registries.ITEM, id, new BlockItem(block, itemsettings));
		return Registry.register(Registries.BLOCK, id, block);
	}

	public static void registerModBlocks() {
		AlFredo.LOGGER.info("Registering Mod Blocks for " + AlFredo.MOD_ID);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> {
			entries.add(PLANT_BOMB);
			entries.add(WIRE);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(WIRE);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
			entries.add(PLANT_BOMB);
		});
	}
}
