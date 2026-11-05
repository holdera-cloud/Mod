package com.example.thesixsevenmod.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class ItemOreLocator extends Item {


    public ItemOreLocator() {
        super(new Item.Properties()
                .durability(128)
                .stacksTo(1)
        );
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(player.getItemInHand(usedHand));


    }

    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {

        if (livingEntity instanceof ServerPlayer player) {

            int scanRadius = 8;
            int maxValue = 0;
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

            for(int x = player.getBlockX()-scanRadius; x <= player.getBlockX()+scanRadius; x++){
                for(int y = player.getBlockY()-scanRadius; y <= player.getBlockY()+scanRadius; y++){
                    for(int z = player.getBlockZ()-scanRadius; z <= player.getBlockZ()+scanRadius; z++){

                        pos = pos.set(x, y, z);
                        Block block = level.getBlockState(pos).getBlock();

                        if (block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE) {
                            maxValue = Math.max(maxValue, 10);
                        }
                        if(block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE) {
                            maxValue = Math.max(maxValue, 9);
                        }
                        if (block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE) {
                            maxValue = Math.max(maxValue, 8);
                        }
                        if (block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE) {
                            maxValue = Math.max(maxValue, 7);
                        }
                        if (block == Blocks.COAL_ORE || block == Blocks.DEEPSLATE_COAL_ORE) {
                            maxValue = Math.max(maxValue, 6);
                        }
                        if (block == Blocks.LAPIS_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE) {
                            maxValue = Math.max(maxValue, 5);
                        }
                        if(block == Blocks.REDSTONE_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE) {
                            maxValue = Math.max(maxValue, 4);
                        }

                    }
                }
            }


            player.getCooldowns().addCooldown(stack.getItem(), 200);
            stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
            return stack;
        }
        return stack;

    }



}
