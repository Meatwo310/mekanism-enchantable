package io.github.meatwo310.mekanism_enchantable.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings({"deprecation", "CancellableInjectionUsage"})
@Mixin(Item.class)
public abstract class ItemMixin {
    /**
     * This method forces the return value of {@link Item#getEnchantmentValue()}.
     * Classes that extend this class should override this method to change the return value.
     * @param cir Callback info returnable
     */
    @Inject(method = "getEnchantmentValue()I", at = @At("HEAD"), cancellable = true)
    protected void getEnchantmentValue(CallbackInfoReturnable<Integer> cir) {}
}
