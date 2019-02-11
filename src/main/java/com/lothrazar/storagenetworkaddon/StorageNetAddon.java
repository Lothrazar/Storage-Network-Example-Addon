package com.lothrazar.storagenetworkaddon;

import org.apache.logging.log4j.Logger;
import com.lothrazar.storagenetworkaddon.block.BlockSimpleCable;
import com.lothrazar.storagenetworkaddon.block.TileSimpleCable;
import com.lothrazar.storagenetworkaddon.registry.AddonRegistry;
import mrriegel.storagenetwork.block.cable.TesrCable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StorageNetAddon.MODID, certificateFingerprint = "@FINGERPRINT@", updateJSON = "https://raw.githubusercontent.com/Lothrazar/Storage-Network-Example-Addon/master/update.json")
public class StorageNetAddon {

  public static final String MODID = "storagenetworkaddon";
  private static Logger logger;
  private AddonRegistry registry;
  private BlockSimpleCable simple_cable;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
    registry = new AddonRegistry();
    MinecraftForge.EVENT_BUS.register(registry);
    simple_cable = new BlockSimpleCable("simple_cable");
    registry.addBlock(simple_cable, "simple_cable");

    ClientRegistry.bindTileEntitySpecialRenderer(TileSimpleCable.class, new TesrCable());
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    ResourceLocation simple = new ResourceLocation(MODID, "textures/tile/simple.png");
    TesrCable.addCableRender(simple_cable, simple);
  }
}
