package alfredo.blocks;

import alfredo.AlFredo;
import alfredo.blocks.custom.PlantBombBlock;
import alfredo.blocks.custom.WireBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
	public static final Block PLANT_BOMB = registerBlock("plant_bomb", AbstractBlock.Settings.create().strength(0.25f).sounds(BlockSoundGroup.GRASS).nonOpaque());
	
	public static final Block WIRE = registerBlock("wire", AbstractBlock.Settings.create().sounds(BlockSoundGroup.WOOD).nonOpaque());

	private static Block registerBlock(String name, AbstractBlock.Settings block_settings) {
		Block block;
		Identifier id = Identifier.of(AlFredo.MOD_ID, name);
		RegistryKey<Item> itemkey = RegistryKey.of(RegistryKeys.ITEM, id);
		RegistryKey<Block> blockkey = RegistryKey.of(RegistryKeys.BLOCK, id);

		Item.Settings itemsettings = new Item.Settings().registryKey(itemkey);
		if (name.equals("plant_bomb")) {
			block = new PlantBombBlock(block_settings.registryKey(blockkey));
			AlFredo.LOGGER.info("Initialized PBB");}
		else if (name.equals("wire")) block = new WireBlock(block_settings.registryKey(blockkey));
		else block = new Block(block_settings);

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
