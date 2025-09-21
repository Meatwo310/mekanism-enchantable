package io.github.meatwo310.mekanism_enchantable.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings({"CancellableInjectionUsage"})
@Mixin(Item.class)
public abstract class ItemMixin {
    /**
     * Empty method to override enchantment value by other mixins that extend this class.
     * @param cir Callback info returnable to set the enchantment value
     */
    @Inject(method = "getEnchantmentValue", at = @At("HEAD"), cancellable = true)
    protected void getEnchantmentValue(CallbackInfoReturnable<Integer> cir) {}

    /**
     * Empty method to override enchantability by other mixins that extend this class.
     * @param cir Callback info returnable to set if the item is enchantable
     */
    @Inject(method = "isEnchantable", at = @At("HEAD"), cancellable = true)
    protected void isEnchantable(CallbackInfoReturnable<Boolean> cir) {}
}
