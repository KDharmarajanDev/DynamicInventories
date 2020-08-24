package com.Mathematician.DynamicInventories.dynamicinventories.itemstates;

import org.bukkit.inventory.ItemStack;

public class ItemState {

    /**
     * item is the Minecraft item that is shown in the DynamicInventory within this ItemState
     */
    private ItemStack item;

    /**
     * duration is a long that represents the length of time in milliseconds that this ItemState will be shown for. -1 represents an infinite amount of time.
     */
    private long duration;

    /**
     * This is the only constructor for the ItemState.
     * @param item - an ItemStack that will be shown in the DynamicInventory when this state is displayed
     * @param duration - a long that represents the length of time in milliseconds that this ItemState will be shown for. -1 represents an infinite amount of time.
     */
    public ItemState(ItemStack item, long duration){
        this.item = item;
        this.duration = duration;
    }

    /**
     * This is a getter that returns an ItemStack.
     * @return item - an ItemStack that will be shown in the DynamicInventory when this state is displayed
     */
    public ItemStack getItemStack(){
        return item;
    }

    /**
     * This is a setter that sets item (the ItemStack).
     * @param item - an ItemStack that will be shown in the DynamicInventory when this state is displayed
     */
    public void setItem(ItemStack item){
        this.item = item;
    }

    /**
     * This is a getter that returns a long (duration).
     * @return duration - a long that represents the length of time in milliseconds that this ItemState will be shown for. -1 represents an infinite amount of time.
     */
    public long getDuration(){
        return duration;
    }

    /**
     * This is a setter that sets duration (long).
     * @param duration - a long that represents the length of time in milliseconds that this ItemState will be shown for. -1 represents an infinite amount of time.
     */
    public void setDuration(long duration){
        this.duration = duration;
    }
}
