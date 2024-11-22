package io.github.meatwo310.mekanism_enchantable.mixin.armor;

import io.github.meatwo310.mekanism_enchantable.api.IEnchantableItem;
import io.github.meatwo310.mekanism_enchantable.config.CommonConfig;
import mekanism.common.item.gear.ItemHazmatSuitArmor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemHazmatSuitArmor.class, remap = false)
public class ItemHazmatSuitArmorMixin {
    @Inject(method = IEnchantableItem.IS_ENCHANTABLE, at = @At("HEAD"), cancellable = true)
    private void isEnchantable(CallbackInfoReturnable<Boolean> cir) {
        if (!CommonConfig.ARMOR_ENCHANTABLE.get()) return;
        cir.setReturnValue(true);
    }
}
