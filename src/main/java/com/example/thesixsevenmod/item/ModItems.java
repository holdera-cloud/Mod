package com.example.thesixsevenmod.item;

import com.example.thesixsevenmod.TheSixSevenMod;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheSixSevenMod.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredItem<Item> GREENSTONE = ITEMS.register("greenstone", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_GREENSTONE = ITEMS.register("raw_greenstone", () -> new Item(new Item.Properties()));

}
