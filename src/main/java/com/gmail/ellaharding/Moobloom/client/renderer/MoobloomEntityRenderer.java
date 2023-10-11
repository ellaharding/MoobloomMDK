package com.gmail.ellaharding.Moobloom.client.renderer;

import com.gmail.ellaharding.Moobloom.MoobloomMod;
import com.gmail.ellaharding.Moobloom.client.model.MoobloomEntityModel;
import com.gmail.ellaharding.Moobloom.entities.MoobloomEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MoobloomEntityRenderer extends MobRenderer<MoobloomEntity,MoobloomEntityModel<MoobloomEntity>> {

    public static final ResourceLocation TEXTURE =
            new ResourceLocation(MoobloomMod.MOD_ID, "textures/entity/moobloom.png");
    public MoobloomEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx,new MoobloomEntityModel(ctx.bakeLayer(MoobloomEntityModel.LAYER_LOCATION)),1.0f);
    }
    @Override
    public ResourceLocation getTextureLocation(MoobloomEntity entity) {
        return TEXTURE;
    }


}
