package com.lothrazar.storagenetworkaddon;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class AddonRegistry {

  private static List<Item> itemList = new ArrayList<Item>();
  private static List<Block> blocks = new ArrayList<Block>();

  public AddonRegistry() {
  }

  @SubscribeEvent
  public void onRegistryEvent(RegistryEvent.Register<Block> event) {
    event.getRegistry().registerAll(blocks.toArray(new Block[0]));
    GameRegistry.registerTileEntity(TileSimpleCable.class,
        new ResourceLocation(ExampleMod.MODID, "simple_cable_te"));
  }

  @SubscribeEvent
  public void registerItems(RegistryEvent.Register<Item> event) {
    for (Item item : itemList) {
      event.getRegistry().register(item);
    }
  }

  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public void registerModels(ModelRegistryEvent event) {
    String name;
    Item item;
    for (Block block : blocks) {
      item = Item.getItemFromBlock(block);
      name = block.getUnlocalizedName().replaceAll("tile.", "");
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
      ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name));
    }
  }

  public void addBlock(BlockSimpleCable block, String name) {
    //    block.setUnlocalizedName(name).setRegistryName(
    //        new ResourceLocation(ExampleMod.MODID, name));
    block.setCreativeTab(CreativeTabs.REDSTONE);
    blocks.add(block);
    ItemBlock ib = new ItemBlock(block);
    ib.setRegistryName(block.getRegistryName());
    addItem(ib);
  }

  private void addItem(ItemBlock ib) {
    itemList.add(ib);
  }
}
