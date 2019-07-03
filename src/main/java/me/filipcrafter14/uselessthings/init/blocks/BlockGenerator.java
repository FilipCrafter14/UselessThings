package me.filipcrafter14.uselessthings.init.blocks;

import me.filipcrafter14.uselessthings.init.BlockBase;
import me.filipcrafter14.uselessthings.tiles.TileEntitySimpleGenerator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockGenerator extends BlockBase {

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    public TileEntity createTileEntity(IBlockReader world) {
        return new TileEntitySimpleGenerator();
    }


}
