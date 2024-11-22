package io.github.meatwo310.mekanism_enchantable.api;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("unused")
public interface IEnchantableItem {
    String IS_ENCHANTABLE = "isEnchantable(Lnet/minecraft/world/item/ItemStack;)Z";
    String IS_BOOK_ENCHANTABLE = "isBookEnchantable(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Z";
    String CAN_APPLY_AT_ENCHANTING_TABLE = "canApplyAtEnchantingTable(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/enchantment/Enchantment;)Z";

    void isEnchantable(@NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir);
    void isBookEnchantable(ItemStack stack, ItemStack book, CallbackInfoReturnable<Boolean> cir);
    void canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment, CallbackInfoReturnable<Boolean> cir);
}
