package com.example.thesixsevenmod.datagen;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheSixSevenMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_GREENSTONE.get());
        basicItem(ModItems.RAW_RUBY.get());
        basicItem(ModItems.GREENSTONE.get());
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.CHARM_OF_RESILIENCE.get());
        basicItem(ModItems.FRIED_EGG.get());
        basicItem(ModItems.KIWI_BURGER.get());
        basicItem(ModItems.ORE_LOCATOR.get());
    }
}
