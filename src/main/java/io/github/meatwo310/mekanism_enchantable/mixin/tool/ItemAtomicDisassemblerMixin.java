package io.github.meatwo310.mekanism_enchantable.mixin.tool;

import io.github.meatwo310.mekanism_enchantable.MEMixinUtil;
import io.github.meatwo310.mekanism_enchantable.config.ServerConfig;
import io.github.meatwo310.mekanism_enchantable.mixin.ItemMixin;
import mekanism.common.item.gear.ItemAtomicDisassembler;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemAtomicDisassembler.class)
public class ItemAtomicDisassemblerMixin extends ItemMixin {
    // Minecraft's method so remap = true
    @Inject(method = "isEnchantable", at = @At("HEAD"), cancellable = true)
    public void isEnchantable(@NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!ServerConfig.ATOMIC_DISASSEMBLER_ENCHANTABLE.get()) return;
        cir.setReturnValue(true);
    }

    // Forge's method so remap = false
    @Inject(method = "isBookEnchantable", at = @At("HEAD"), cancellable = true, remap = false)
    public void isBookEnchantable(ItemStack stack, ItemStack book, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    // Forge's method so remap = false
    @Inject(method = "canApplyAtEnchantingTable", at = @At("HEAD"), cancellable = true, remap = false)
    public void canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment, CallbackInfoReturnable<Boolean> cir) {
        if (!ServerConfig.ATOMIC_DISASSEMBLER_ENCHANTABLE.get()) return;
        if (ServerConfig.ATOMIC_DISASSEMBLER_ALLOW_ALL_ENCHANTMENTS.get())
            cir.setReturnValue(true);

        if (!MEMixinUtil.ATOMIC_DISASSEMBLER_ALLOWED_CATEGORIES.contains(enchantment.category)) return;
        if (MEMixinUtil.ATOMIC_DISASSEMBLER_DENIED_ENCHANTMENTS.contains(enchantment)) return;
        cir.setReturnValue(true);
    }

    // ItemAtomicDisassembler doesn't implement getEnchantmentValue, so inject to Item directly
    @Override
    protected void getEnchantmentValue(CallbackInfoReturnable<Integer> cir) {
        if (!ServerConfig.ATOMIC_DISASSEMBLER_ENCHANTABLE.get()) return;
        cir.setReturnValue(ServerConfig.ATOMIC_DISASSEMBLER_ENCHANTABILITY.get());
    }
}
