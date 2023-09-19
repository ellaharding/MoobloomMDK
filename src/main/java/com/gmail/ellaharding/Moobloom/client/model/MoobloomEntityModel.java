package com.gmail.ellaharding.Moobloom.client.model;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.gmail.ellaharding.Moobloom.MoobloomMod;
import com.gmail.ellaharding.Moobloom.entities.MoobloomEntity;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class MoobloomEntityModel<T extends MoobloomEntity> extends QuadrupedModel<T> {
	public MoobloomEntityModel(ModelPart p_170515_) {
		super(p_170515_, false, 10.0F, 4.0F, 2.0F, 2.0F, 24);
	}

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MoobloomMod.MOD_ID, "moobloom"), "main");
	public static LayerDefinition createBodyLayer( ) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		int i = 12;
		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F).texOffs(22, 0).addBox("right_horn", -5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F).texOffs(22, 0).addBox("left_horn", 4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 4.0F, -8.0F));
		partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 4).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F).texOffs(52, 0).addBox(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, ((float)Math.PI / 2F), 0.0F, 0.0F));
		CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F);
		partdefinition.addOrReplaceChild("right_hind_leg", cubelistbuilder, PartPose.offset(-4.0F, 12.0F, 7.0F));
		partdefinition.addOrReplaceChild("left_hind_leg", cubelistbuilder, PartPose.offset(4.0F, 12.0F, 7.0F));
		partdefinition.addOrReplaceChild("right_front_leg", cubelistbuilder, PartPose.offset(-4.0F, 12.0F, -6.0F));
		partdefinition.addOrReplaceChild("left_front_leg", cubelistbuilder, PartPose.offset(4.0F, 12.0F, -6.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	public ModelPart getHead() {
		return this.head;
	}
}
