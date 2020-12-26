package unitedminecrafters.moredoors;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import unitedminecrafters.moredoors.blocks.WindowBlock;
import unitedminecrafters.moredoors.items.WrenchItem;

import java.util.ArrayList;

public class MoreDoors implements ModInitializer {
    public static final ArrayList<Block> WINDOWS = new ArrayList<Block>();
    public static final String[] types = new String[]{
            "dark_oak",
            "spruce",
            "acacia",
            "birch",
            "jungle",
            "oak"
    };


    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("moredoors", "general"),
            () -> new ItemStack(Blocks.COBBLESTONE)
    );

    public static final WrenchItem WRENCH_ITEM = new WrenchItem(new FabricItemSettings().group(ITEM_GROUP));


    @Override
    public void onInitialize() {
        for (String t : types) {
            WindowBlock block = new WindowBlock(FabricBlockSettings.of(Material.WOOD).hardness(1f));
            WINDOWS.add(block);
            Registry.register(Registry.BLOCK, new Identifier("moredoors", t + "_window"), block);
            Registry.register(Registry.ITEM, new Identifier("moredoors", t + "_window"),
                    new BlockItem(block, new Item.Settings().group(ITEM_GROUP)));

        }
        Registry.register(Registry.ITEM, new Identifier("moredoors", "wrench"), WRENCH_ITEM);
    }


    public static String createItemModelJson(Identifier id, String generated) {
        return null;
    }
}
