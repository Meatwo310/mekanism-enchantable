package io.github.meatwo310.mekanism_enchantable.config;

import io.github.meatwo310.mekanism_enchantable.MekanismEnchantable;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MekanismEnchantable.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue MEKATOOL_ENCHANTABLE = BUILDER
            .comment("Whether to allow enchanting of Meka-Tool")
            .define("mekaToolEnchantable", true);

    public static final ForgeConfigSpec.IntValue MEKATOOL_ENCHANTABILITY = BUILDER
            .comment("Enchantability of Meka-Tool. Higher values mean better enchantments")
            .defineInRange("mekaToolEnchantability", 15, 1, Integer.MAX_VALUE);

    public static final ForgeConfigSpec.BooleanValue MEKATOOL_ALLOW_ALL_ENCHANTMENTS = BUILDER
            .comment("Whether to allow ALL enchantments on Meka-Tool. Set false to limit to tools and weapons enchantments")
            .define("mekaToolAllowAllEnchantments", false);

    public static final ForgeConfigSpec.BooleanValue ARMOR_ENCHANTABLE = BUILDER
            .comment("Whether to allow enchanting of armors, such as Meka-Suit, (Armored) Jetpack, (Armored) Free Runners, etc.")
            .define("armorEnchantable", true);

    public static final ForgeConfigSpec.IntValue ARMOR_ENCHANTABILITY = BUILDER
            .comment("Enchantability of armors. Higher values mean better enchantments")
            .defineInRange("armorEnchantability", 15, 1, Integer.MAX_VALUE);

    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
