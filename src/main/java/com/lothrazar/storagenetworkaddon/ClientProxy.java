package com.lothrazar.storagenetworkaddon;

import com.lothrazar.storagenetworkaddon.block.TileSimpleCable;
import mrriegel.storagenetwork.block.cable.TesrCable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

  @Override
  public void preInit(FMLPreInitializationEvent event) {
    super.preInit(event);
    ClientRegistry.bindTileEntitySpecialRenderer(TileSimpleCable.class, new TesrCable());
  }

  @Override
  public void init(FMLInitializationEvent event) {
    super.init(event);
    ResourceLocation simple = new ResourceLocation(StorageNetAddon.MODID, "textures/tile/simple.png");
    TesrCable.addCableRender(StorageNetAddon.instance.simple_cable, simple);
  }
}
