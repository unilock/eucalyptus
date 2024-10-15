package cc.unilock.eucalyptus.datagen.provider;

import cc.unilock.eucalyptus.Eucalyptus;
import cc.unilock.eucalyptus.registry.EucalyptusConfiguredFeatures;
import cc.unilock.eucalyptus.registry.EucalyptusPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EucalyptusDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	public EucalyptusDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup, Entries entries) {
		EucalyptusConfiguredFeatures.populate(entries);
		EucalyptusPlacedFeatures.populate(entries);
	}

	@Override
	public String getName() {
		return Eucalyptus.MOD_ID;
	}
}
