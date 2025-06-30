package trilobyte.block

import net.minecraft.world.item.DyeColor
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import trilobyte.TechMod
import java.util.function.Supplier

object ModBlocks {
    val REGISTRY: DeferredRegister.Blocks = DeferredRegister.createBlocks(TechMod.ID)
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(TechMod.ID)

    val CONCRETE = arrayListOf<DeferredBlock<Block>>()

    val CONCRETE_BLOCK: DeferredBlock<Block?> = BLOCKS.register<Block?>(
        "concrete",
        Supplier {
            Block(
                BlockBehaviour.Properties.of()
                    .destroyTime(5.0f)
                    .explosionResistance(72.0f)
            )
        })

    private val DEFAULT_CONCRETE = BlockBehaviour.Properties.of()
        .destroyTime(5.0f)
        .explosionResistance(72.0f)

    init {
        for (color in DyeColor.entries) {
            CONCRETE.add(REGISTRY.register("${color.serializedName}_concrete") { ->
                Block(DEFAULT_CONCRETE)
            })
        }
    }
}