package io.github.meatwo310.mekanism_enchantable;

import io.github.meatwo310.mekanism_enchantable.config.CommonConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(MekanismEnchantable.MODID)
public class MekanismEnchantable {
    public static final String MODID = "mekanism_enchantable";

    public MekanismEnchantable() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
    }
}
