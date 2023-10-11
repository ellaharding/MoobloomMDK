package com.gmail.ellaharding.Moobloom.entities;

import com.gmail.ellaharding.Moobloom.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class MoobloomEntity extends MushroomCow {

    public MoobloomEntity(EntityType<? extends MushroomCow> type, Level level) {
        super(type, level);
    }

    public MoobloomEntity(Level level, double x, double y, double z) {
        this(EntityInit.MOOBLOOM_ENTITY.get(),level);
        setPos(x,y,z);
    }

    @Override
    public MushroomCow getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return new MoobloomEntity(level, position().x, position().y, position().z);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25));
        this.goalSelector.addGoal(2, new BreedGoal(this,1));
        this.goalSelector.addGoal(3, new FollowParentGoal(this,1.1));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this,1));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class,6.0f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new TemptGoal(this,1.0, Ingredient.of(ItemTags.FLOWERS), false));
    }
    @Override
    public boolean isFood(ItemStack stack) {
        // Eventually work out how to make this be any flower type
        return stack.getItem() == Items.DANDELION;
    }

    public static boolean canSpawn(EntityType<MoobloomEntity> entityType,
                                   LevelAccessor level,
                                   MobSpawnType spawnType,
                                   BlockPos position,
                                   RandomSource random) {
        return checkAnimalSpawnRules(entityType, level, spawnType, position, random);
    }
}