package com.omar.bsaw.item;

import com.omar.bsaw.BSAWMod;
import com.omar.bsaw.util.KeyboardUtil;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.swing.*;
import java.util.List;

public class EmeraldApple extends Item
{


    public EmeraldApple()
    {
        super(new Properties().group(BSAWMod.BSAW_TAB)
                .food(new Food.Builder()
                .hunger(20)
                .saturation(20.5f)
                .effect(() -> new EffectInstance(Effects.REGENERATION, 2400, 99), 1f)
                .effect(() -> new EffectInstance(Effects.ABSORPTION, 2400, 99), .25f)
                .effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 20000000), 1f)
                .effect( () -> new EffectInstance(Effects.STRENGTH, 2400, 4), 1f)
                .build()));
    }

    @Override
    public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip,
                               ITooltipFlag flag)
    {
        if (KeyboardUtil.isHoldingShift())
        {
            tooltip.add(new StringTextComponent ("\u00A74" + "\u00A7k aasasdws" + "\u00A7a OVER 9000! powers... yeah." + "\u00A7b \u00A7k asdasdwd"));
        }
        else
        {
            tooltip.add(new StringTextComponent("Hold Shift For Info :|"));
        }

        super.addInformation(stack, world, tooltip,  flag);
    }

    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return 12000;
    }
}
