package alfredo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import alfredo.blocks.ModBlocks;
import alfredo.entities.ModEntities;
import alfredo.items.ModItems;
import alfredo.villagers.ModVillagers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.util.Identifier;

public class AlFredo implements ModInitializer {
	public static final String MOD_ID = "al-fredo";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModVillagers.registerModVillagers();

		TradeOfferHelper.registerVillagerOffers(ModVillagers.TERRORIST_KEY, 1, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
				new TradedItem(Items.EMERALD, 3),
				new ItemStack(ModItems.THRUST_BOMB, 2), 7, 2, 0.04f));
			
		});
		TradeOfferHelper.registerVillagerOffers(ModVillagers.TERRORIST_KEY, 2, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
				new TradedItem(Items.REDSTONE, 5),
				new ItemStack(ModBlocks.WIRE, 2), 7, 3, 0.04f));
			factories.add((world, entity, random) -> new TradeOffer(
				new TradedItem(ModItems.THRUST_BOMB, 5),
				new ItemStack(ModBlocks.PLANT_BOMB, 2), 7, 4, 0.04f));
			
		});
		TradeOfferHelper.registerWanderingTraderOffers(factories -> {
			factories.addAll(Identifier.of(AlFredo.MOD_ID, "wire_for_redstone"), (world, entity, random) -> new TradeOffer(
				new TradedItem(ModBlocks.WIRE, 5),
				new ItemStack(Items.REDSTONE, 2), 7, 3, 0.04f));
		});
	}
}