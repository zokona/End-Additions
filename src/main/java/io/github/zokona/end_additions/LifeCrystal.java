package io.github.zokona.end_additions;

import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.item.TooltipConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class LifeCrystal extends Item {
	public LifeCrystal(Settings settings) {
		super(settings);
	}

	public static void heal(ServerPlayerEntity player) {
		if (player.getHealth() < player.getMaxHealth()) {
			player.setHealth(player.getHealth() + 3);
		}
	}

	@Override
	public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipConfig config) {
		tooltip.add(Text.translatable("itemTooltip.end_additions.life_crystal").formatted(Formatting.WHITE));
	}
}
