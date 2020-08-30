package com.Mathematician.DynamicInventories.dynamicinventories.generators;

import com.Mathematician.DynamicInventories.dynamicinventories.itemstates.ItemState;

import java.util.ArrayList;

public class RandomGenerator extends SequentialGenerator {

    /**
     * This is the only constructor for the RandomGenerator.
     * @param itemStates - an ArrayList of ItemState that represents all possible ItemStates that could be displayed
     * @param slotNumber - an integer that represents the slot in the DynamicInventory that this sequence is displayed.
     * @param listener - an OnItemStateChangeListener that gets called when the current ItemState changes.
     * @param shouldStart - a boolean that represents if the SequentialGenerator should start changing the ItemStates
     */
    public RandomGenerator(ArrayList<ItemState> itemStates, int slotNumber, OnItemStateChangeListener listener, boolean shouldStart) {
        super(itemStates, slotNumber, listener, shouldStart);
    }

    /**
     * This method randomly selects an ItemState and sets it to be the current ItemState.
     */
    @Override
    public void goToNextState(){
        super.setCurrentIndex((int) (Math.random() * super.getItemStates().size()));
    }
}
