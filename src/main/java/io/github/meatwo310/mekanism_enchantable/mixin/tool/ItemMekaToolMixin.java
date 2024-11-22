package io.github.meatwo310.mekanism_enchantable.mixin.tool;

import io.github.meatwo310.mekanism_enchantable.api.IEnchantableItem;
import io.github.meatwo310.mekanism_enchantable.config.CommonConfig;
import io.github.meatwo310.mekanism_enchantable.mixin.ItemMixin;
import mekanism.common.item.gear.ItemMekaTool;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@Mixin(value = ItemMekaTool.class, remap = false)
public class ItemMekaToolMixin extends ItemMixin implements IEnchantableItem {
    @Unique
    private static final Set<EnchantmentCategory> enchantable_mekatools$ALLOWED = Collections.unmodifiableSet(EnumSet.of(
            //            EnchantmentCategory.BREAKABLE, // TODO: Support this category
            EnchantmentCategory.DIGGER,
            EnchantmentCategory.WEAPON
    ));

    @Unique
    private static final Set<Enchantment> enchantable_mekatools$DENIED = Set.of(
            Enchantments.SWEEPING_EDGE,
            Enchantments.SILK_TOUCH
    );

    @Override
    @Inject(method = IEnchantableItem.IS_ENCHANTABLE, at = @At("HEAD"), cancellable = true)
    public void isEnchantable(@NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!CommonConfig.MEKATOOL_ENCHANTABLE.get()) return;
        cir.setReturnValue(true);
    }

    @Override
    @Inject(method = IEnchantableItem.IS_BOOK_ENCHANTABLE, at = @At("HEAD"), cancellable = true)
    public void isBookEnchantable(ItemStack stack, ItemStack book, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Override
    @Inject(method = IEnchantableItem.CAN_APPLY_AT_ENCHANTING_TABLE, at = @At("HEAD"), cancellable = true)
    public void canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment, CallbackInfoReturnable<Boolean> cir) {
        if (!CommonConfig.MEKATOOL_ENCHANTABLE.get()) return;
        if (CommonConfig.MEKATOOL_ALLOW_ALL_ENCHANTMENTS.get())
            cir.setReturnValue(true);

        if (!enchantable_mekatools$ALLOWED.contains(enchantment.category)) return;
        if (enchantable_mekatools$DENIED.contains(enchantment)) return;
        cir.setReturnValue(true);
    }

    @Override
    protected void getEnchantmentValue(CallbackInfoReturnable<Integer> cir) {
        if (!CommonConfig.MEKATOOL_ENCHANTABLE.get()) return;
        cir.setReturnValue(CommonConfig.MEKATOOL_ENCHANTABILITY.get());
    }
}
