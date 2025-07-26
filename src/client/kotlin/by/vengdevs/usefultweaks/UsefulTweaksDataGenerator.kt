package by.vengdevs.usefultweaks

import by.vengdevs.usefultweaks.blocks.CharcoalBlock
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.server.recipe.RecipeJsonProvider
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder
import net.minecraft.item.Items
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.util.Identifier
import java.util.function.Consumer

object UsefulTweaksDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()
		pack.addProvider(::RecipeGenerator)
	}
}

class RecipeGenerator(output: FabricDataOutput) : FabricRecipeProvider(output) {
	override fun generate(exporter: Consumer<RecipeJsonProvider>) {
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CharcoalBlock.BLOCK, 1)
			.pattern("CCC")
			.pattern("CCC")
			.pattern("CCC")
			.input('C', Items.CHARCOAL)
			.criterion("has_charcoal", conditionsFromItem(Items.CHARCOAL))
			.offerTo(exporter, Identifier("usefultweaks", "charcoal_block_from_charcoal"))

		ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CHARCOAL, 9)
			.input(CharcoalBlock.BLOCK)
			.criterion("has_charcoal_block", conditionsFromItem(CharcoalBlock.BLOCK))
			.offerTo(exporter, Identifier("usefultweaks", "charcoal_from_charcoal_block"))
	}
}