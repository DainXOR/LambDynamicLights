/*
 * Copyright © 2021 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of LambDynamicLights.
 *
 * Licensed under the Lambda License. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.lambdynlights.config;

import com.electronwill.nightconfig.core.Config;
import dev.lambdaurora.spruceui.SpruceTexts;
import dev.lambdaurora.spruceui.option.SpruceBooleanOption;
import dev.lambdaurora.spruceui.option.SpruceOption;
import net.minecraft.TextFormatting;
import net.minecraft.network.chat.Text;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Supplier;

public final class LightSourceSettingEntry extends BooleanSettingEntry {
	public LightSourceSettingEntry(String key, boolean defaultValue, @Nullable Config config, @Nullable Text tooltip) {
		super(key, defaultValue, config, tooltip);
	}

	public LightSourceSettingEntry(String key, boolean defaultValue, @Nullable Config config) {
		super(key, defaultValue, config);
	}

	@Override
	protected SpruceOption buildOption(@Nullable Text tooltip) {
		return new Option(
				this.getOptionKey(),
				this::get,
				this::set,
				tooltip
		);
	}

	public static final class Option extends SpruceBooleanOption {
		public Option(String key, Supplier<Boolean> getter, Consumer<Boolean> setter, @Nullable Text tooltip) {
			super(key, getter, setter, tooltip, true);
		}

		@Override
		public Text getDisplayText() {
			boolean value = this.get();
			return SpruceTexts.getToggleText(value).copy()
					.withStyle(value ? TextFormatting.GREEN : TextFormatting.RED);
		}
	}
}
