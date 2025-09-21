package io.github.meatwo310.mekanism_enchantable;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.Set;

public class MEMixinUtil {
    public static final Set<EnchantmentCategory> ATOMIC_DISASSEMBLER_ALLOWED_CATEGORIES = Set.of(
            //            EnchantmentCategory.BREAKABLE, // TODO: Support this category
            EnchantmentCategory.DIGGER,
            EnchantmentCategory.WEAPON
    );
    public static final Set<Enchantment> ATOMIC_DISASSEMBLER_DENIED_ENCHANTMENTS = Set.of(
            Enchantments.SWEEPING_EDGE
    );

    public static final Set<EnchantmentCategory> MEKA_TOOL_ALLOWED_CATEGORIES = Set.of(
            //            EnchantmentCategory.BREAKABLE, // TODO: Support this category
            EnchantmentCategory.DIGGER,
            EnchantmentCategory.WEAPON
    );
    public static final Set<Enchantment> MEKA_TOOL_DENIED_ENCHANTMENTS = Set.of(
            Enchantments.SWEEPING_EDGE,
            Enchantments.SILK_TOUCH
    );
}
