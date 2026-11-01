package alfredo.blocks.custom;

import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.MapCodec;

import alfredo.blocks.entity.custom.PlantBombBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

@SuppressWarnings("unused")// technical redundant superinterface or smth or other
public class PlantBombBlock extends BlockWithEntity implements BlockEntityProvider {
	private static final VoxelShape SHAPE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
	public static final MapCodec<PlantBombBlock> CODEC = PlantBombBlock.createCodec(PlantBombBlock::new);

	public PlantBombBlock(Settings settings) {
		super(settings);
	}


	@Override
	protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	@Override
	protected MapCodec<? extends BlockWithEntity> getCodec() {
		return CODEC;
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new PlantBombBlockEntity(pos, state);
	}

	@Override
	protected BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}

	//@Override
	//protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
	//	BlockEntity block_entity = world.getBlockEntity(pos);
	//	if (block_entity instanceof PlantBombBlockEntity)
	//		world.updateComparators(pos, this);
//
	//	super.onStateReplaced(state, world, pos, moved);
	//}
	
	@Override
	protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
			PlayerEntity player, Hand hand, BlockHitResult hit) {
		
		if (world.getBlockEntity(pos) instanceof PlantBombBlockEntity plantbomb_blockentity) {
			if (!world.isClient()) player.openHandledScreen(plantbomb_blockentity);
		}
		
		return ActionResult.SUCCESS;
	}
}