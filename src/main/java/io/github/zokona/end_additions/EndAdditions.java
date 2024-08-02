package io.github.zokona.end_additions;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EndAdditions implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("End Additions");

	@Override
	public void onInitialize(ModContainer mod) {
		ServerLivingEntityEvents.ALLOW_DEATH.register((entity, damageSource, damageAmount) -> {
			if (damageSource.getAttacker() instanceof ServerPlayerEntity) {
				if (((ServerPlayerEntity)damageSource.getAttacker()).getInventory().offHand.get(0).getItem() == EndAdditionsItems.LIFE_CRYSTAL) {
					LifeCrystal.heal((ServerPlayerEntity)damageSource.getAttacker());
				}
			}

			return true;
		});

		EndAdditionsItems.register(mod);
	}
}
