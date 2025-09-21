package io.github.meatwo310.mekanism_enchantable.config;

import io.github.meatwo310.mekanism_enchantable.MekanismEnchantable;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MekanismEnchantable.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ServerConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // Meka-Tool
    public static final ForgeConfigSpec.BooleanValue MEKATOOL_ENCHANTABLE = BUILDER
            .push("mekaTool")
            .comment("Whether to allow enchanting of Meka-Tool")
            .define("enchantable", true);
    public static final ForgeConfigSpec.IntValue MEKATOOL_ENCHANTABILITY = BUILDER
            .comment("Enchantability of Meka-Tool. Higher values mean better enchantments")
            .defineInRange("enchantability", 15, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.BooleanValue MEKATOOL_ALLOW_ALL_ENCHANTMENTS = BUILDER
            .comment("Whether to allow ALL enchantments on Meka-Tool. Set false to limit to tools and weapons enchantments")
            .define("allowAllEnchantments", false);

    // Atomic Disassembler
    public static final ForgeConfigSpec.BooleanValue ATOMIC_DISASSEMBLER_ENCHANTABLE = BUILDER
            .pop().push("atomicDisassembler")
            .comment("Whether to allow enchanting of Atomic Disassembler")
            .define("enchantable", true);
    public static final ForgeConfigSpec.IntValue ATOMIC_DISASSEMBLER_ENCHANTABILITY = BUILDER
            .comment("Enchantability of Atomic Disassembler. Higher values mean better enchantments")
            .defineInRange("enchantability", 15, 1, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.BooleanValue ATOMIC_DISASSEMBLER_ALLOW_ALL_ENCHANTMENTS = BUILDER
            .comment("Whether to allow ALL enchantments on Atomic Disassembler. Set false to limit to tools and weapons enchantments")
            .define("allowAllEnchantments", false);

    // Electric Bow
    public static final ForgeConfigSpec.BooleanValue ELECTRIC_BOW_ENCHANTABLE = BUILDER
            .pop().push("electricBow")
            .comment("Whether to allow enchanting of Electric Bow in Enchanting Table")
            .define("enchantable", true);
    public static final ForgeConfigSpec.IntValue ELECTRIC_BOW_ENCHANTABILITY = BUILDER
            .comment("Enchantability of Electric Bow. Higher values mean better enchantments")
            .defineInRange("enchantability", 15, 1, Integer.MAX_VALUE);


    // Armor
    public static final ForgeConfigSpec.BooleanValue ARMOR_ENCHANTABLE = BUILDER
            .pop().push("armor")
            .comment("Whether to allow enchanting of armors, such as Meka-Suit, Jetpack, Free Runners, etc.")
            .define("enchantable", true);
    public static final ForgeConfigSpec.IntValue ARMOR_ENCHANTABILITY = BUILDER
            .comment("Enchantability of armors. Higher values mean better enchantments")
            .defineInRange("enchantability", 15, 1, Integer.MAX_VALUE);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
