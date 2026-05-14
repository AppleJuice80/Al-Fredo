package alfredo.datagen;

import java.util.concurrent.CompletableFuture;

import alfredo.AlFredo;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registries_future) {
        super(output, registries_future);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapper_lookup) {
        getTagBuilder(BlockTags.PICKAXE_MINEABLE).add(Identifier.of(AlFredo.MOD_ID, "plant_bomb"));
    }
}
