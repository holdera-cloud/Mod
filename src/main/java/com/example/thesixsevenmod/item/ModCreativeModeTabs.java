package com.example.thesixsevenmod.item;

import com.example.thesixsevenmod.TheSixSevenMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheSixSevenMod.MODID);

    public static void register(IEventBus eventBus) {

        CREATIVE_MOD_TAB.register(eventBus);
    }
}