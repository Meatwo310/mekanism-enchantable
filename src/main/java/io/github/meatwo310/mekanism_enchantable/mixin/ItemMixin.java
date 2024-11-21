package io.github.meatwo310.mekanism_enchantable.mixin;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Inject(method = "getEnchantmentValue()I", at = @At("HEAD"), cancellable = true)
    protected void getEnchantmentValue(CallbackInfoReturnable<Integer> cir) {
    }
}
