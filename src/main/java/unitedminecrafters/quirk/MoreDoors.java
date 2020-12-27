package unitedminecrafters.quirk;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import unitedminecrafters.quirk.blocks.WindowBlock;
import unitedminecrafters.quirk.items.WrenchItem;
import unitedminecrafters.quirk.tools.ReinforcedAxeItem;
import unitedminecrafters.quirk.tools.ReinforcedHoeItem;
import unitedminecrafters.quirk.tools.ReinforcedIronMaterial;
import unitedminecrafters.quirk.tools.ReinforcedPickaxeItem;

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
            new Identifier("quirk", "general"),
            () -> new ItemStack(Blocks.COBBLESTONE)
    );

    public static final WrenchItem WRENCH_ITEM = new WrenchItem(new FabricItemSettings().group(ITEM_GROUP));
    public static final Item WINDOW_PIECE_ITEM = new Item(new FabricItemSettings().group(ITEM_GROUP));
    public static final ToolItem REINFORCED_AXE =
            new ReinforcedAxeItem(ReinforcedIronMaterial.INSTANCE, 0, 1,
                    new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem REINFORCED_SWORD =
            new SwordItem(ReinforcedIronMaterial.INSTANCE, 0, 1,
                    new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem REINFORCED_SHOVEL =
            new ShovelItem(ReinforcedIronMaterial.INSTANCE, 0, 1,
                    new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem REINFORCED_HOE =
            new ReinforcedHoeItem(ReinforcedIronMaterial.INSTANCE, 0, 1,
                    new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem REINFORCED_PICKAXE =
            new ReinforcedPickaxeItem(ReinforcedIronMaterial.INSTANCE, 0, 1,
                    new Item.Settings().group(ItemGroup.TOOLS));


    @Override
    public void onInitialize() {
        for (String t : types) {
            WindowBlock block = new WindowBlock(FabricBlockSettings.of(Material.WOOD).hardness(1f));
            WINDOWS.add(block);
            Registry.register(Registry.BLOCK, new Identifier("quirk", t + "_window"), block);
            Registry.register(Registry.ITEM, new Identifier("quirk", t + "_window"),
                    new BlockItem(block, new Item.Settings().group(ITEM_GROUP)));

        }
        Registry.register(Registry.ITEM, new Identifier("quirk", "wrench"), WRENCH_ITEM);
        Registry.register(Registry.ITEM, new Identifier("quirk", "window_part"), WINDOW_PIECE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("quirk", "reinforced_axe"), REINFORCED_AXE);
        Registry.register(Registry.ITEM, new Identifier("quirk", "reinforced_sword"), REINFORCED_SWORD);
        Registry.register(Registry.ITEM, new Identifier("quirk", "reinforced_shovel"), REINFORCED_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("quirk", "reinforced_hoe"), REINFORCED_HOE);
        Registry.register(Registry.ITEM, new Identifier("quirk", "reinforced_pickaxe"), REINFORCED_PICKAXE);
    }


    public static String createItemModelJson(Identifier id, String generated) {
        return null;
    }
}
