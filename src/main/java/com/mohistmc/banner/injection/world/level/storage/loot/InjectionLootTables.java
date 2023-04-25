package com.mohistmc.banner.injection.world.level.storage.loot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Map;

public interface InjectionLootTables {

    default Map<LootTable, ResourceLocation> bridge$lootTableToKey() {
        return null;
    }

    default void banner$setLootTableToKey(Map<LootTable, ResourceLocation> lootTableToKey) {
    }
}
