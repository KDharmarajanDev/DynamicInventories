package com.Mathematician.DynamicInventories.dynamicinventories.itemstates;

import org.bukkit.inventory.ItemStack;

public class UnlockableItemState extends ItemState {

    /**
     * unlockedItem is an ItemStack that is displayed when this is unlocked. This will replace the lockedItem when this is unlocked.
     */
    private ItemStack unlockedItem;

    /**
     * This boolean isUnlocked is responsible for maintaining if this state is unlocked or not. If isUnlocked is true, this is unlocked.
     */
    private boolean isUnlocked;

    /**
     * This is the only constructor for UnlockableItemState.
     * @param lockedItem - an ItemStack that will be displayed in the DynamicInventory when this state is locked. This ItemStack will be stored in the superclass.
     * @param unlockedItem - an ItemStack that will be displayed in the DynamicInventory when this state is unlocked.
     */
    public UnlockableItemState(ItemStack lockedItem, ItemStack unlockedItem){
        super(lockedItem);
        isUnlocked = false;
        this.unlockedItem = unlockedItem;
    }

    /**
     * This getter is responsible for determining what is returned to the DynamicInventory to display.
     * @return item - an ItemStack that will be displayed in the DynamicInventory.
     */
    @Override
    public ItemStack getItemStack(){
        if(isUnlocked){
            return unlockedItem;
        }
        return super.getItemStack();
    }

    /**
     * This is a getter that returns an ItemStack.
     * @return unlockedItem - an ItemStack that will be displayed in the DynamicInventory when this state is unlocked.
     */
    public ItemStack getUnlockedItem() {
        return unlockedItem;
    }

    /**
     * This is a setter that sets unlockedItem.
     * @param unlockedItem - an ItemStack that will be displayed in the DynamicInventory when this state is unlocked.
     */
    public void setUnlockedItem(ItemStack unlockedItem){
        this.unlockedItem = unlockedItem;
    }

    /**
     * This is a getter that returns isUnlocked.
     * @return isUnlocked - isUnlocked is responsible for maintaining if this state is unlocked or not. If isUnlocked is true, this is unlocked.
     */
    public boolean isUnlocked(){
        return isUnlocked;
    }

    /**
     * This is a setter that sets isUnlocked.
     * @param isUnlocked - isUnlocked is responsible for maintaining if this state is unlocked or not. If isUnlocked is true, this is unlocked.
     */
    public void setUnlocked(boolean isUnlocked){
        this.isUnlocked = isUnlocked;
    }
}
