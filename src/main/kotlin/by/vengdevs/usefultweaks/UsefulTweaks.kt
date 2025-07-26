package by.vengdevs.usefultweaks

import by.vengdevs.usefultweaks.blocks.CharcoalBlock
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.fabricmc.fabric.api.registry.FuelRegistry
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory


object UsefulTweaks : ModInitializer {
    private val logger = LoggerFactory.getLogger("UsefulTweaks")

	override fun onInitialize() {
		Registry.register(Registries.BLOCK, Identifier("usefultweaks", "charcoal_block"), CharcoalBlock.BLOCK)
		Registry.register(
			Registries.ITEM, Identifier("usefultweaks", "charcoal_block"),
			BlockItem(CharcoalBlock.BLOCK, FabricItemSettings())
		)

		FuelRegistry.INSTANCE.add(CharcoalBlock.BLOCK.asItem(), 16000)

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
			.register(ModifyEntries { content: FabricItemGroupEntries? ->
                content?.addAfter(
                    Items.COAL_BLOCK,
					CharcoalBlock.BLOCK
                )
			})

		logger.info("Successfully initialized!")
	}
}