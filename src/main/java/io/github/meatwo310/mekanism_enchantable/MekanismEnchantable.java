package io.github.meatwo310.mekanism_enchantable;

import io.github.meatwo310.mekanism_enchantable.config.ServerConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MekanismEnchantable.MODID)
public class MekanismEnchantable {
    public static final String MODID = "mekanism_enchantable";

    public MekanismEnchantable(FMLJavaModLoadingContext ctx) {
        ctx.registerConfig(ModConfig.Type.SERVER, ServerConfig.SPEC);
    }
}
