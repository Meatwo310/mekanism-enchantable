package io.github.meatwo310.mekanism_enchantable.mixin.armor;

import io.github.meatwo310.mekanism_enchantable.config.ServerConfig;
import mekanism.common.item.gear.ItemSpecialArmor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemSpecialArmor.class)
public class ItemSpecialArmorMixin {
    // Minecraft's method so remap = true
    @Inject(method = "isEnchantable", at = @At("HEAD"), cancellable = true)
    private void isEnchantable(CallbackInfoReturnable<Boolean> cir) {
        if (!ServerConfig.ARMOR_ENCHANTABLE.get()) return;
        cir.setReturnValue(true);
    }
}
