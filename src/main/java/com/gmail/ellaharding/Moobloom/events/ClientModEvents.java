package com.gmail.ellaharding.Moobloom.events;

import com.gmail.ellaharding.Moobloom.MoobloomMod;
import com.gmail.ellaharding.Moobloom.client.model.MoobloomEntityModel;
import com.gmail.ellaharding.Moobloom.client.renderer.MoobloomEntityRenderer;
import com.gmail.ellaharding.Moobloom.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoobloomMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.MOOBLOOM_ENTITY.get(), MoobloomEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MoobloomEntityModel.LAYER_LOCATION, MoobloomEntityModel::createBodyLayer);
    }
}
