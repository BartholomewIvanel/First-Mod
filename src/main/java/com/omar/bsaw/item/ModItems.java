package com.omar.bsaw.item;


import com.omar.bsaw.BSAWMod;
import com.omar.bsaw.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{

    public static final RegistryObject<Item> EMERALD_ALLOY =
            Registration.ITEMS.register("emerald_alloy_ingot",
                    () -> new Item(new Item.Properties().group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> RAW_EMERALD =
            Registration.ITEMS.register("raw_emerald",
                    () -> new Item(new Item.Properties().group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> TITANIUM_INGOT =
            Registration.ITEMS.register("titanium_ingot",
                    () -> new Item(new Item.Properties().group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> EMERALD_APPLE =
            Registration.ITEMS.register("emerald_apple",
                    () -> new EmeraldApple());

    /* Tools */
    public static final RegistryObject<Item> EMERALD_SHOVEL =
            Registration.ITEMS.register("emerald_shovel",
                    () -> new ShovelItem(ModItemTier.EMERALD, 0, 0,
                            new Item.Properties()
                                    .defaultMaxDamage(3000)
                                    .isImmuneToFire()
                                    .addToolType(ToolType.SHOVEL, 3)
                                    .group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> EMERALD_SWORD =
            Registration.ITEMS.register("emerald_sword",
                    () -> new SwordItem(ModItemTier.EMERALD, 12, 12,
                            new Item.Properties()
                                    .defaultMaxDamage(3000)
                                    .isImmuneToFire()
                                    .group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> EMERALD_PICKAXE =
            Registration.ITEMS.register("emerald_pickaxe",
                    () -> new PickaxeItem(ModItemTier.EMERALD, 0, 0,
                            new Item.Properties()
                                    .defaultMaxDamage(3000)
                                    .isImmuneToFire()
                                    .addToolType(ToolType.PICKAXE, 3)
                                    .group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> EMERALD_AXE =
            Registration.ITEMS.register("emerald_axe",
                    () -> new AxeItem(ModItemTier.EMERALD, 18, 6,
                            new Item.Properties()
                                .defaultMaxDamage(3000)
                                .isImmuneToFire()
                                .addToolType(ToolType.AXE, 3)
                                .group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> EMERALD_HOE =
            Registration.ITEMS.register("emerald_hoe",
                    () -> new HoeItem(ModItemTier.EMERALD, 0, 0,
                            new Item.Properties()
                            .defaultMaxDamage(3000)
                            .isImmuneToFire()
                            .addToolType(ToolType.HOE, 3)
                            .group(BSAWMod.BSAW_TAB)));


    public static void register()
    {

    }

    public enum ModItemTier implements IItemTier{
        EMERALD(3, 99999, 10000000f, 10f, 25,
                Ingredient.fromStacks(new ItemStack(ModItems.EMERALD_ALLOY.get())));


        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }

        @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }



    //Armour
    public static final RegistryObject<Item> EMERALD_HELMET =
            Registration.ITEMS.register("emerald_helmet",
                    () -> new ArmorItem(ModArmourMaterial.EMERALD, EquipmentSlotType.HEAD,
                            new Item.Properties().group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> EMERALD_CHESTPLATE =
            Registration.ITEMS.register("emerald_chestplate",
                    () -> new ArmorItem(ModArmourMaterial.EMERALD, EquipmentSlotType.CHEST,
                            new Item.Properties().group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> EMERALD_LEGGINGS =
            Registration.ITEMS.register("emerald_leggings",
                    () -> new ArmorItem(ModArmourMaterial.EMERALD, EquipmentSlotType.LEGS,
                            new Item.Properties().group(BSAWMod.BSAW_TAB)));

    public static final RegistryObject<Item> EMERALD_BOOTS =
            Registration.ITEMS.register("emerald_boots",
                    () -> new ArmorItem(ModArmourMaterial.EMERALD, EquipmentSlotType.FEET,
                            new Item.Properties().group(BSAWMod.BSAW_TAB)));

    public enum ModArmourMaterial implements IArmorMaterial
    {
        EMERALD(1000, new int[]{ 20, 20, 20, 20 }, 999, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                Ingredient.fromStacks(new ItemStack(ModItems.EMERALD_ALLOY.get())),
                BSAWMod.MOD_ID + ":emerald", 20, 9999);

        private final int durability;
        private final int[] damageReductionArray;
        private final int enchantabilty;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        ModArmourMaterial(int durability, int[] damageReductionArray, int enchantabilty, SoundEvent soundEvent, Ingredient repairMaterial, String name, float toughness, float knockbackResistance) {
            this.durability = durability;
            this.damageReductionArray = damageReductionArray;
            this.enchantabilty = enchantabilty;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }


        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return damageReductionArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return enchantabilty;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public float getToughness() {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }
    }

}
