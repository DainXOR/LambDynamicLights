/*
 * Copyright © 2021 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of LambDynamicLights.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.lambdynlights.config;

import com.electronwill.nightconfig.core.Config;
import dev.lambdaurora.spruceui.option.SpruceIntegerInputOption;
import dev.lambdaurora.spruceui.option.SpruceOption;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class IntegerSettingEntry extends SettingEntry<Integer> {
    public IntegerSettingEntry(String key, int defaultValue, @Nullable Config config, @Nullable Text tooltip) {
        super(key, defaultValue, config, tooltip);
    }

    public IntegerSettingEntry(String key, int defaultValue, @Nullable Config config) {
        super(key, defaultValue, config);
    }

    @Override
    protected void deserialize(Object obj) {
    }

    @Override
    protected Object serialize() {
        return this.get();
    }

    @Override
    public void load(Config config) {
        this.config = config;
        this.set(this.config.getOrElse(this.key(), this.get()));
    }

    @Override
    public IntegerSettingEntry withOnSet(@Nullable Consumer<Integer> onSet) {
        this.onSet = onSet;
        return this;
    }

    @Override
    protected SpruceOption buildOption(@Nullable Text tooltip) {
        return new SpruceIntegerInputOption(
                this.getOptionKey(),
                this::get,
                this::set,
                tooltip
        );
    }
}