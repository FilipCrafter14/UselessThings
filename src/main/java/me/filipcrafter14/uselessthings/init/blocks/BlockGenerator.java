package me.filipcrafter14.uselessthings.init.blocks;

import me.filipcrafter14.uselessthings.tiles.TileEntitySimpleGenerator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.awt.*;

public class BlockGenerator extends BlockBase {


    public BlockGenerator() {
        super();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }



    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntitySimpleGenerator();
    }


}
