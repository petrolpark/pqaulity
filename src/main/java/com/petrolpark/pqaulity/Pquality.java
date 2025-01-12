package com.petrolpark.pqaulity;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import com.petrolpark.pqaulity.core.RegisteredQuality;
import com.petrolpark.registrate.PetrolparkRegistrate;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryBuilder;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Pquality.MOD_ID)
public class Pquality
{
    public static final String MOD_ID = "pquality";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final PetrolparkRegistrate REGISTRATE = new PetrolparkRegistrate(MOD_ID);

    public static final ResourceKey<Registry<RegisteredQuality>> QUALITY_REGISTRY = REGISTRATE.makeRegistry("quality", RegistryBuilder::new);
    
    public Pquality() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::init);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Config
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, PqualityConfig.serverSpec);
    };

    public void init(final FMLCommonSetupEvent event) {

    };
}
