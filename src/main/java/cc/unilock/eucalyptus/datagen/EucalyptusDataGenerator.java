package cc.unilock.eucalyptus.datagen;

import cc.unilock.eucalyptus.datagen.provider.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class EucalyptusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		FabricTagProvider.BlockTagProvider blockTagProvider = pack.addProvider(EucalyptusBlockTagProvider::new);
		pack.addProvider((output, registriesFuture) -> new EucalyptusItemTagProvider(output, registriesFuture, blockTagProvider));

		pack.addProvider(EucalyptusBlockLootTableProvider::new);
		pack.addProvider(EucalyptusDynamicRegistryProvider::new);
		pack.addProvider(EucalyptusRecipeProvider::new);
	}
}
