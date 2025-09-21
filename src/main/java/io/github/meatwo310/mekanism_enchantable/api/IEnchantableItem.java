package io.github.meatwo310.mekanism_enchantable.api;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Interface for items that want to be enchantable.
 * Implement this interface with cancellable {@link Inject} mixins to adjust enchanting behavior.
 */
@SuppressWarnings("unused")
public interface IEnchantableItem {
    void isEnchantable(@NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir);
    void isBookEnchantable(ItemStack stack, ItemStack book, CallbackInfoReturnable<Boolean> cir);
    void canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment, CallbackInfoReturnable<Boolean> cir);
}
