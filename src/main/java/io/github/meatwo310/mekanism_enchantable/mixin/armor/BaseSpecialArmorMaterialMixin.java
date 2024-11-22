package io.github.meatwo310.mekanism_enchantable.mixin.armor;

import io.github.meatwo310.mekanism_enchantable.config.CommonConfig;
import mekanism.common.item.gear.BaseSpecialArmorMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BaseSpecialArmorMaterial.class, remap = false)
public abstract class BaseSpecialArmorMaterialMixin {
    @Inject(method = "getEnchantmentValue", at = @At("HEAD"), cancellable = true)
    private void getEnchantmentValue(CallbackInfoReturnable<Integer> cir) {
        if (!CommonConfig.ARMOR_ENCHANTABLE.get()) return;
        cir.setReturnValue(CommonConfig.ARMOR_ENCHANTABILITY.get());
    }
}
