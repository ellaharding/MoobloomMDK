package com.gmail.ellaharding.Moobloom.init;

import com.gmail.ellaharding.Moobloom.MoobloomMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoobloomMod.MOD_ID);

    public static final RegistryObject<Item> MOOBLOOM_SPAWN_EGG = ITEMS.register("moobloom_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityInit.MOOBLOOM_ENTITY,0xfaca02,0xf3e060,new Item.Properties()));
}
