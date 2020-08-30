package com.Mathematician.DynamicInventories;

import org.bukkit.plugin.java.JavaPlugin;

public class DynamicInventoriesMain extends JavaPlugin {

    private static DynamicInventoriesMain instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable(){

    }

    public static DynamicInventoriesMain getInstance(){
        return instance;
    }
}
