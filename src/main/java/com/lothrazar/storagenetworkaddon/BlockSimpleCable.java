package com.lothrazar.storagenetworkaddon;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSimpleCable extends Block implements ITileEntityProvider {

  public BlockSimpleCable(Material materialIn) {
    super(materialIn);
  }

  @Override
  public TileEntity createNewTileEntity(World worldIn, int meta) {
    return new TileSimpleCable();
  }
}
