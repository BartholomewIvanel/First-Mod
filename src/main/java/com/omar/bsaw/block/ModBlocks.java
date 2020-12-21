package com.omar.bsaw.block;

import com.omar.bsaw.BSAWMod;
import com.omar.bsaw.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> EMERALD_ALLOY_BLOCK = register("emerald_alloy_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
            .hardnessAndResistance(50f, 1200f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(3)));

    public static final RegistryObject<Block> TITANIUM_ORE = register("titanium_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(80f, 1200f).sound(SoundType.ANCIENT_DEBRIS).harvestLevel(4) .harvestTool(ToolType.PICKAXE)));




    public static void register(){}

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(BSAWMod.BSAW_TAB)));
        return toReturn;
    }
}
