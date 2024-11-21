package io.github.meatwo310.mekanism_enchantable.mixin;

import io.github.meatwo310.mekanism_enchantable.config.CommonConfig;
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

@Mixin(value = ItemMekaTool.class,
        remap = false // SUPER IMPORTANT
)
public abstract class ItemMekaToolMixin extends ItemMixin {
    @Unique
    private static final Set<EnchantmentCategory> enchantable_mekatools$CATEGORIES = Collections.unmodifiableSet(EnumSet.of(
            //            EnchantmentCategory.BREAKABLE, // TODO: Support this category
            EnchantmentCategory.DIGGER,
            EnchantmentCategory.WEAPON
    ));
    @Unique
    private static final Set<Enchantment> enchantable_mekatools$DENIED = Set.of(
            Enchantments.SILK_TOUCH
    );

    @Inject(method = "isEnchantable(" +
            "Lnet/minecraft/world/item/ItemStack;" +
            ")Z",
            at = @At("HEAD"),
            cancellable = true)
    private void isEnchantable(@NotNull ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!CommonConfig.MEKATOOL_ENCHANTABLE.get()) return;
        cir.setReturnValue(true);
    }

    @Inject(method = "isBookEnchantable(" +
            "Lnet/minecraft/world/item/ItemStack;" +
            "Lnet/minecraft/world/item/ItemStack;" +
            ")Z",
            at = @At("HEAD"),
            cancellable = true)
    private void isBookEnchantable(ItemStack stack, ItemStack book, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(method = "canApplyAtEnchantingTable(" +
            "Lnet/minecraft/world/item/ItemStack;" +
            "Lnet/minecraft/world/item/enchantment/Enchantment;" +
            ")Z",
            at = @At("HEAD"),
            cancellable = true)
    private void canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment, CallbackInfoReturnable<Boolean> cir) {
        if (!CommonConfig.MEKATOOL_ENCHANTABLE.get()) return;
        cir.setReturnValue(CommonConfig.MEKATOOL_ALLOW_ALL_ENCHANTMENTS.get() ||
                (enchantable_mekatools$CATEGORIES.contains(enchantment.category) &&
                        !enchantable_mekatools$DENIED.contains(enchantment))
        );
    }

    @Override
    protected void getEnchantmentValue(CallbackInfoReturnable<Integer> cir) {
        if (!CommonConfig.MEKATOOL_ENCHANTABLE.get()) return;
        cir.setReturnValue(CommonConfig.MEKATOOL_ENCHANTABILITY.get());
    }
}
