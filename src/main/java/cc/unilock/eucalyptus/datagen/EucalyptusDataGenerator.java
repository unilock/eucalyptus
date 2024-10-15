package cc.unilock.eucalyptus.datagen;

import cc.unilock.eucalyptus.datagen.provider.EucalyptusDynamicRegistryProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EucalyptusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EucalyptusDynamicRegistryProvider::new);
	}
}
