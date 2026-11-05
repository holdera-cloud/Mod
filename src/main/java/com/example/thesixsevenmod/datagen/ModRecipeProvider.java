package com.example.thesixsevenmod.datagen;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.block.ModBlocks;
import com.example.thesixsevenmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput){
        List<ItemLike> GREENSTONE_SMELTABLES = List.of(ModItems.RAW_GREENSTONE.get(),
                ModBlocks.POLISHED_GREENSTONE_BLOCK.get(),
                ModBlocks.RAW_GREENSTONE_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.POLISHED_GREENSTONE_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModBlocks.POLISHED_GREENSTONE_BLOCK.get())
                .unlockedBy(getHasName(ModItems.GREENSTONE.get()), has(ModItems.GREENSTONE.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GREENSTONE.get(), 9)
                .requires(ModBlocks.POLISHED_GREENSTONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.POLISHED_GREENSTONE_BLOCK.get()), has(ModBlocks.POLISHED_GREENSTONE_BLOCK.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GREENSTONE.get(), 32)
                .requires(ModBlocks.POLISHED_GREENSTONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.POLISHED_GREENSTONE_BLOCK.get()), has(ModBlocks.POLISHED_GREENSTONE_BLOCK.get()))
                .save(pRecipeOutput, TheSixSevenMod.MODID + ":greenstone_from_magic_block");

        oreSmelting(pRecipeOutput, GREENSTONE_SMELTABLES, RecipeCategory.MISC, ModItems.GREENSTONE.get(), 0.25f, 200, "greenstone");
        oreBlasting(pRecipeOutput, GREENSTONE_SMELTABLES, RecipeCategory.MISC, ModItems.GREENSTONE.get(), 0.25f, 100, "greenstone");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TheSixSevenMod.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
