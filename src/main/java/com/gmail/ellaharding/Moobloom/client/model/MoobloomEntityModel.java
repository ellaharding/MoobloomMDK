package com.gmail.ellaharding.Moobloom.client.model;// Made with Blockbench 4.8.3

import com.gmail.ellaharding.Moobloom.MoobloomMod;
import com.gmail.ellaharding.Moobloom.entities.MoobloomEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
public class MoobloomEntityModel<T extends MoobloomEntity> extends EntityModel<T> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MoobloomMod.MOD_ID, "moobloom_entity"), "main");
	private final ModelPart legs;
	private final ModelPart head;
	private final ModelPart flowers;
	private final ModelPart bb_main;

	public MoobloomEntityModel(ModelPart root) {
		this.legs = root.getChild("legs");
		this.head = root.getChild("head");
		this.flowers = root.getChild("flowers");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(0, 16).addBox(4.0F, -12.0F, -8.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(4.0F, -12.0F, 4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-4.0F, -12.0F, 4.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-4.0F, -12.0F, -8.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 24.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(22, 0).addBox(4.0F, -25.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-4.0F, -24.0F, -15.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(22, 0).addBox(-5.0F, -25.0F, -13.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition flowers = partdefinition.addOrReplaceChild("flowers", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition flowerbunch4 = flowers.addOrReplaceChild("flowerbunch4", CubeListBuilder.create().texOffs(52, 7).addBox(-1.0F, -9.0F, -11.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -21.0F, -1.0F));

		PartDefinition flower_r1 = flowerbunch4.addOrReplaceChild("flower_r1", CubeListBuilder.create().texOffs(52, 7).addBox(-13.0F, -9.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition flowerbunch3 = flowers.addOrReplaceChild("flowerbunch3", CubeListBuilder.create().texOffs(52, 7).addBox(0.0F, -7.0F, 6.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -21.0F, -1.0F));

		PartDefinition flower_r2 = flowerbunch3.addOrReplaceChild("flower_r2", CubeListBuilder.create().texOffs(52, 7).addBox(4.0F, -7.0F, -2.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition flowerbunch2 = flowers.addOrReplaceChild("flowerbunch2", CubeListBuilder.create().texOffs(52, 7).addBox(2.0F, -7.0F, -5.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -21.0F, -1.0F));

		PartDefinition flower_r3 = flowerbunch2.addOrReplaceChild("flower_r3", CubeListBuilder.create().texOffs(52, 7).addBox(-7.0F, -7.0F, -4.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition flowerbunch = flowers.addOrReplaceChild("flowerbunch", CubeListBuilder.create().texOffs(52, 7).addBox(-4.0F, -7.0F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -21.0F, -1.0F));

		PartDefinition flower_r4 = flowerbunch.addOrReplaceChild("flower_r4", CubeListBuilder.create().texOffs(52, 7).addBox(-2.0F, -7.0F, 2.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body_r1 = bb_main.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(18, 4).mirror().addBox(-4.0F, -9.0F, 12.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		legs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		flowers.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}