package com.lothrazar.storagenetworkaddon;

import mrriegel.storagenetwork.api.ICableStorage;
import mrriegel.storagenetwork.data.EnumFilterDirection;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class TileSimpleCable extends TileEntity implements ICableStorage {

  @Override
  public BlockPos getConnectedInventory() {
    //for testing: always only connects to the block above
    return this.pos.up();
  }

  @Override
  public IItemHandler getInventory() {
    TileEntity tile = world.getTileEntity(getConnectedInventory());
    if (tile.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN)) {
      return tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.DOWN);
    }
    return null;
  }


  @Override
  public int getPriority() {
    return 0;
  }

  @Override
  public boolean canTransfer(ItemStack arg0, EnumFilterDirection arg1) {
    return true;
  }

  @Override
  public boolean isStorageCable() {
    return true;
  }
}
