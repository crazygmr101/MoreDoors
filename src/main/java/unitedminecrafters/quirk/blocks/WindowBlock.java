package unitedminecrafters.quirk.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WindowBlock extends HorizontalFacingBlock {
    public WindowBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(Properties.HORIZONTAL_FACING));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch (state.get(Properties.HORIZONTAL_FACING)) {
            case NORTH:
                return VoxelShapes.cuboid(0f, 0f, 0.75, 1, 1, 0.875);
            case SOUTH:
                return VoxelShapes.cuboid(0f, 0f, 0.125, 1, 1, 0.25);
            case EAST:
                return VoxelShapes.cuboid(0.125, 0f, 0f, 0.25, 1, 1);
            case WEST:
                return VoxelShapes.cuboid(0.75, 0f, 0f, 0.875, 1, 1);
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerFacing());
    }
}
