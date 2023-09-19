package com.gmail.ellaharding.Moobloom;

import com.gmail.ellaharding.Moobloom.init.EntityInit;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(MoobloomMod.MOD_ID)
public class MoobloomMod {
    public static final String MOD_ID = "moobloommod";

    public MoobloomMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        //Add item and create tab inits here as well with same formatting
        EntityInit.ENTITIES.register(bus);
    }
}
