package io.github.meatwo310.mekanism_enchantable.mixin.tool;

import io.github.meatwo310.mekanism_enchantable.config.ServerConfig;
import io.github.meatwo310.mekanism_enchantable.mixin.ItemMixin;
import mekanism.common.item.gear.ItemElectricBow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemElectricBow.class)
public class ItemElectricBowMixin extends ItemMixin {
    // ItemElectricBow doesn't implement getEnchantmentValue, so inject to Item directly
    @Override
    public void getEnchantmentValue(CallbackInfoReturnable<Integer> cir) {
        if (!ServerConfig.ELECTRIC_BOW_ENCHANTABLE.get()) return;
        cir.setReturnValue(ServerConfig.ELECTRIC_BOW_ENCHANTABILITY.get());
    }

    // ItemElectricBow doesn't implement isEnchantable, so inject to Item directly
    @Override
    protected void isEnchantable(CallbackInfoReturnable<Boolean> cir) {
        if (!ServerConfig.ELECTRIC_BOW_ENCHANTABLE.get()) return;
        cir.setReturnValue(true);
    }
}
