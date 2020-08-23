package com.Mathematician.DynamicInventories.dynamicinventories.itemstates;

import org.bukkit.inventory.ItemStack;

public class ItemState {

    /**
     * item is the Minecraft item that is shown in the DynamicInventory within this ItemState
     */
    private ItemStack item;

    /**
     * This is the only constructor for the ItemState.
     * @param item - an ItemStack that will be shown in the DynamicInventory when this state is displayed
     */
    public ItemState(ItemStack item){
        this.item = item;
    }

    /**
     * This is a getter that returns an ItemStack.
     * @return item - an ItemStack that will be shown in the DynamicInventory when this state is displayed
     */
    public ItemStack getItemStack(){
        return item;
    }

    /**
     * This is a getter that sets item.
     * @param item - an ItemStack that will be shown in the DynamicInventory when this state is displayed
     */
    public void setItem(ItemStack item){
        this.item = item;
    }

}
