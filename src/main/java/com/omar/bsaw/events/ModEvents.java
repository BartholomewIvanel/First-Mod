package com.omar.bsaw.events;

import com.omar.bsaw.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import sun.rmi.runtime.Log;

import java.util.Collection;

public class ModEvents
{
    @SubscribeEvent
    public void onEmeraldSheep(AttackEntityEvent event) throws InterruptedException {
        if (event.getPlayer().getHeldItemMainhand().getItem() == ModItems.EMERALD_APPLE.get())
        {
            if (event.getTarget().isAlive())
            {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof SheepEntity)
                {
                    PlayerEntity player = event.getPlayer();
                    //Delete whats held in main hand
                    player.getHeldItemMainhand().shrink(1);
                    String msg = TextFormatting.GOLD + "You fed it the emerald apple...";
                    if (!player.world.isRemote)
                    {
                        target.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 99, 99));
                        target.addPotionEffect(new EffectInstance(Effects.GLOWING, 99, 99));
                        String msg2 = TextFormatting.DARK_RED + "HOW COULD YOU THE SHEEP IS DEAD!";
                        player.sendMessage(new StringTextComponent(msg2), player.getUniqueID());
                    }
                }
            }
        }
    }
}
