package unitedminecrafters.quirk.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;

public class ReinforcedIronMaterial implements ToolMaterial {

    public static ReinforcedIronMaterial INSTANCE = new ReinforcedIronMaterial();

    @Override
    public int getDurability() {
        return (ToolMaterials.IRON.getDurability() + ToolMaterials.DIAMOND.getDurability()) / 2;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return (ToolMaterials.IRON.getMiningSpeedMultiplier() + ToolMaterials.DIAMOND.getMiningSpeedMultiplier()) / 2;
    }

    @Override
    public float getAttackDamage() {
        return (ToolMaterials.IRON.getAttackDamage() + ToolMaterials.DIAMOND.getAttackDamage()) / 2;
    }

    @Override
    public int getMiningLevel() {
        return (ToolMaterials.IRON.getMiningLevel() + ToolMaterials.DIAMOND.getMiningLevel()) / 2;
    }

    @Override
    public int getEnchantability() {
        return (ToolMaterials.IRON.getEnchantability() + ToolMaterials.DIAMOND.getEnchantability()) / 2;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }
}
