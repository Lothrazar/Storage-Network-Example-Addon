package com.lothrazar.storagenetworkaddon;

import javax.annotation.Nullable;
import mrriegel.storagenetwork.block.cable.BlockCableWithFacing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSimpleCable extends BlockCableWithFacing {

  public BlockSimpleCable(String registryName) {
    super(registryName);
  }

  @Nullable
  @Override
  public TileEntity createNewTileEntity(World worldIn, int meta) {
    return new TileSimpleCable();
  }
}
