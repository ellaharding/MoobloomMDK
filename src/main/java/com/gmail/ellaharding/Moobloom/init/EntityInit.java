package com.gmail.ellaharding.Moobloom.init;

import com.gmail.ellaharding.Moobloom.MoobloomMod;
import com.gmail.ellaharding.Moobloom.entities.MoobloomEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoobloomMod.MOD_ID);

    public static final RegistryObject<EntityType<MoobloomEntity>> MOOBLOOM_ENTITY = ENTITIES.register("moobloom",
            () -> EntityType.Builder.<MoobloomEntity>of(MoobloomEntity::new, MobCategory.CREATURE)
                    .build(new ResourceLocation(MoobloomMod.MOD_ID,"moobloom").toString()));
}


//23.2