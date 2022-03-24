package com.archasmiel.lightandgloom.util.setup;

import net.minecraft.world.World;

public interface IProxy {

    void init();
    World getClientWorld();

}
