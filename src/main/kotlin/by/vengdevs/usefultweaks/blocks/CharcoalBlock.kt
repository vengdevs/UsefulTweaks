package by.vengdevs.usefultweaks.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Blocks

object CharcoalBlock {

    val BLOCK: Block = Block(FabricBlockSettings.copyOf(Blocks.COAL_BLOCK))
}