package io.github.zokona.end_additions;

import net.fabricmc.fabric.api.item.v1.EquipmentSlotProvider;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;

public class EndAdditionsItems {
	public static final LifeCrystal LIFE_CRYSTAL = new LifeCrystal(new Item.Settings().maxCount(1));

	public static void register(ModContainer mod) {
		final RegistryKey<ItemGroup> END_ADDITIONS_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(mod.metadata().id(), "item_group"));
		final ItemGroup END_ADDITIONS_GROUP = FabricItemGroup.builder()
			.name(Text.translatable("itemGroup.end_additions.end_additions"))
			.build();

		Registry.register(Registries.ITEM_GROUP, END_ADDITIONS_GROUP_KEY, END_ADDITIONS_GROUP);
		Registry.register(Registries.ITEM, Identifier.of(mod.metadata().id(), "life_crystal"), LIFE_CRYSTAL);

		ItemGroupEvents.modifyEntriesEvent(END_ADDITIONS_GROUP_KEY).register(entries -> {
			entries.addItem(LIFE_CRYSTAL);
		});
	}
}
