package cc.unilock.eucalyptus.datagen.provider;

import cc.unilock.eucalyptus.registry.EucalyptusBlockFamilies;
import cc.unilock.eucalyptus.registry.EucalyptusBlocks;
import cc.unilock.eucalyptus.registry.EucalyptusTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import java.util.function.Consumer;

public class EucalyptusRecipeProvider extends FabricRecipeProvider {
	public EucalyptusRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> consumer) {
		generateFamily(consumer, EucalyptusBlockFamilies.EUCALYPTUS);

		offerPlanksRecipe(consumer, EucalyptusBlocks.EUCALYPTUS_PLANKS, EucalyptusTags.Items.EUCALYPTUS_LOGS, 4);
		offerBarkBlockRecipe(consumer, EucalyptusBlocks.EUCALYPTUS_WOOD, EucalyptusBlocks.EUCALYPTUS_LOG);
		offerBarkBlockRecipe(consumer, EucalyptusBlocks.STRIPPED_EUCALYPTUS_WOOD, EucalyptusBlocks.STRIPPED_EUCALYPTUS_LOG);
//		offerBoatRecipe(consumer, Items.OAK_BOAT, Blocks.OAK_PLANKS);
//		offerChestBoatRecipe(consumer, Items.OAK_CHEST_BOAT, Items.OAK_BOAT);
//		offerHangingSignRecipe(consumer, Items.OAK_HANGING_SIGN, Blocks.STRIPPED_OAK_LOG);
	}
}
