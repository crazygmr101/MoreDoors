package unitedminecrafters.moredoors.items;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class WrenchItem extends Item {
    public WrenchItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        @Nullable HitResult hit = MinecraftClient.getInstance().crosshairTarget;
        if (hit == null || hit.getType() != HitResult.Type.BLOCK)
            return TypedActionResult.success(user.getStackInHand(hand));
        world.setBlockState(
                ((BlockHitResult)hit).getBlockPos(),
                world.getBlockState(((BlockHitResult)hit).getBlockPos()).rotate(user.isSneaking() ? BlockRotation.CLOCKWISE_90: BlockRotation.COUNTERCLOCKWISE_90)
        );
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
