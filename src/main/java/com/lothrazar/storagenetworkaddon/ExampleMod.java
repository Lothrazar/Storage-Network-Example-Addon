package com.lothrazar.storagenetworkaddon;

import org.apache.logging.log4j.Logger;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID)
public class ExampleMod {

  public static final String MODID = "storagenetworkaddon";
  private static Logger logger;
  private AddonRegistry registry;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    registry = new AddonRegistry();
    MinecraftForge.EVENT_BUS.register(registry);
    registry.addBlock(new BlockSimpleCable(Material.ROCK), "simple_cable");
    logger = event.getModLog();

  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    // some example code
    logger.info("storagenetworkaddon DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
  }
}
