package com.gmail.ellaharding.Moobloom.client.model;// Made with Blockbench 4.8.3

import com.gmail.ellaharding.Moobloom.MoobloomMod;
import com.gmail.ellaharding.Moobloom.entities.MoobloomEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MoobloomEntityModel<T extends MoobloomEntity> extends EntityModel <T> {

	public static final ModelLayerLocation LAYER_LOCATION =
			new ModelLayerLocation(new ResourceLocation(MoobloomMod.MOD_ID, "moobloom_entity"), "main");
	private final ModelParts parts;

	public MoobloomEntityModel(ModelPart root) {
		ModelPart body = root.getChild("body");
		ModelPart body_r1 = body.getChild("body_r1");
		ModelPart head = body.getChild("head");
		ModelPart legs = body.getChild("legs");
		ModelPart frontLeftLeg = legs.getChild("frontLeft");
		ModelPart frontRightLeg = legs.getChild("frontRight");
		ModelPart backLeftLeg = legs.getChild("backLeft");
		ModelPart backRightLeg = legs.getChild("backRight");
		ModelPart flowers = body.getChild("flowers");
		ModelPart flower_r1 = head.getChild("flower_r1");
		ModelPart flower_r2 = flowers.getChild("flower_r2");

		this.parts = new ModelParts(body, head, legs, frontLeftLeg, frontRightLeg, backLeftLeg, backRightLeg, flowers, flower_r1, body_r1, flower_r2);
	}

	public static LayerDefinition createBodyLayer() {
		var meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		//Body
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -9.0F, 12.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		//Legs
		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));
		legs.addOrReplaceChild("frontLeft", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 6.0F, -6.0F));
		legs.addOrReplaceChild("frontRight", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 6.0F, -6.0F));
		legs.addOrReplaceChild("backRight", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 6.0F, 6.0F));
		legs.addOrReplaceChild("backLeft", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 6.0F, 6.0F));

		//Head & head flower
		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 0).addBox(4.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-5.0F, -5.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(52, 7).addBox(-2.0F, -10.0F, -3.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, -9.0F));
		head.addOrReplaceChild("flower_r1", CubeListBuilder.create().texOffs(52, 7).addBox(-13.0F, -9.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 8.0F, 0.0F, -1.5708F, 0.0F));

		//Body flowers
		PartDefinition flowers = body.addOrReplaceChild("flowers", CubeListBuilder.create().texOffs(52, 7).addBox(-1.0F, -28.0F, 5.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(52, 7).addBox(1.0F, -28.0F, -6.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(52, 7).addBox(-5.0F, -28.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		flowers.addOrReplaceChild("flower_r2", CubeListBuilder.create().texOffs(52, 7).addBox(-2.0F, -7.0F, 2.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(52, 7).addBox(-7.0F, -7.0F, -4.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(52, 7).addBox(4.0F, -7.0F, -2.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -21.0F, -1.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.parts.head().yRot = netHeadYaw * Mth.DEG_TO_RAD;
		this.parts.head().xRot = headPitch * Mth.DEG_TO_RAD;

		this.parts.frontLeftLeg().xRot = Mth.cos(limbSwing * 0.6662F) * 1F * limbSwingAmount;
		this.parts.frontRightLeg().xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1F * limbSwingAmount;
		this.parts.backLeftLeg().xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1F * limbSwingAmount;
		this.parts.backRightLeg().xRot = Mth.cos(limbSwing * 0.6662F) * 1F * limbSwingAmount;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		this.parts.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	private record ModelParts(ModelPart body, ModelPart head, ModelPart legs, ModelPart frontLeftLeg, ModelPart frontRightLeg, ModelPart backLeftLeg, ModelPart backRightLeg, ModelPart flowers, ModelPart flower_r1, ModelPart body_r1, ModelPart flower_r2) {}
}