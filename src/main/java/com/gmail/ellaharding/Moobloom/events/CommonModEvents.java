package com.gmail.ellaharding.Moobloom.events;

import com.gmail.ellaharding.Moobloom.MoobloomMod;
import com.gmail.ellaharding.Moobloom.entities.MoobloomEntity;
import com.gmail.ellaharding.Moobloom.init.EntityInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoobloomMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(EntityInit.MOOBLOOM_ENTITY.get(), MoobloomEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event){
        event.register(
                EntityInit.MOOBLOOM_ENTITY.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.WORLD_SURFACE,
                MoobloomEntity::canSpawn,
                SpawnPlacementRegisterEvent.Operation.OR);
    }
}
