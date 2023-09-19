package com.gmail.ellaharding.Moobloom.entities;

import com.gmail.ellaharding.Moobloom.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;

public class MoobloomEntity extends MushroomCow {

    public MoobloomEntity(EntityType<? extends MushroomCow> type, Level level) {
        super(type, level);
    }

    public MoobloomEntity(Level level, double x, double y, double z) {
        this(EntityInit.MOOBLOOM_ENTITY.get(),level);
        setPos(x,y,z);
    }

    public MoobloomEntity(Level level, BlockPos position) {
        this(level, position.getX(), position.getY(),position.getZ());
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
        // Fix for tempting by flower this.goalSelector.addGoal(7, new TemptGoal(this,1.0, Ingredient.of(ItemLike.), false));
        //research brains for more complex AI
    }

    public static boolean canSpawn(EntityType<MoobloomEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos position, RandomSource random) {
        return Cow.checkAnimalSpawnRules(entityType, level, spawnType, position, random);
    }




}
