package alfredo.blocks.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import alfredo.blocks.entity.ModBlockEntities;
import alfredo.screens.custom.PlantBombScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PlantBombBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos> {
	public PlantBombBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.PLANTBOMB_BE, pos, state);
	}

	@Nullable
	@Override
	public Packet<ClientPlayPacketListener> toUpdatePacket() {
		return BlockEntityUpdateS2CPacket.create(this);
	}
	@Override
	public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registry_lookup) {
		return createNbt(registry_lookup);
	}

	@Override
	public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
		return this.pos;
	}
	@Override
	public Text getDisplayName() {
		return Text.literal("Plant Bomb");
	}
	@Nullable
	@Override
	public ScreenHandler createMenu(int syncID, PlayerInventory player_inventory, PlayerEntity player) {
		return new PlantBombScreenHandler(syncID, player_inventory, this.pos);
	}
}