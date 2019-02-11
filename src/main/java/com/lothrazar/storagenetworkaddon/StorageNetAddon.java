package com.lothrazar.storagenetworkaddon;

import org.apache.logging.log4j.Logger;
import com.lothrazar.storagenetworkaddon.block.BlockSimpleCable;
import com.lothrazar.storagenetworkaddon.registry.AddonRegistry;
import mrriegel.storagenetwork.block.cable.TesrCable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StorageNetAddon.MODID, certificateFingerprint = "@FINGERPRINT@", updateJSON = "https://raw.githubusercontent.com/Lothrazar/Storage-Network-Example-Addon/master/update.json")
public class StorageNetAddon {

  public static final String MODID = "storagenetworkaddon";
  private static Logger logger;
  private AddonRegistry registry;
  private BlockSimpleCable simple_cable;
  @Instance(StorageNetAddon.MODID)
  public static StorageNetAddon instance;
  @SidedProxy(clientSide = "com.lothrazar.storagenetworkaddon.ClientProxy", serverSide = "com.lothrazar.storagenetworkaddon.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
    registry = new AddonRegistry();
    MinecraftForge.EVENT_BUS.register(registry);
    simple_cable = new BlockSimpleCable("simple_cable");
    registry.addBlock(simple_cable, "simple_cable");
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    ResourceLocation simple = new ResourceLocation(MODID, "textures/tile/simple.png");
    TesrCable.addCableRender(simple_cable, simple);
  }
}
