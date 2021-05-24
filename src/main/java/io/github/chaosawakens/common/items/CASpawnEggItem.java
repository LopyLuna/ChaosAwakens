package io.github.chaosawakens.common.items;

import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class CASpawnEggItem extends CASpawnEgg {
    private final Supplier<? extends EntityType<?>> typeGetter;

    public CASpawnEggItem(Supplier<? extends EntityType<?>> typeIn, Properties properties) {
        super(null, properties);
        typeGetter = typeIn;
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundNBT p_208076_1_) {
        return typeGetter.get();
    }

}