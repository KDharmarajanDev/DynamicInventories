package com.Mathematician.DynamicInventories.dynamicinventories.generators;

import com.Mathematician.DynamicInventories.dynamicinventories.itemstates.ItemState;

import java.util.ArrayList;

public class RandomGenerator extends SequentialGenerator {

    /**
     * This is the only constructor for the RandomGenerator.
     *
     * @param itemStates - an ArrayList of ItemState that represents all possible ItemStates that could be displayed
     * @param slotNumber - an integer that represents the slot in the DynamicInventory that this sequence is displayed.
     */
    public RandomGenerator(ArrayList<ItemState> itemStates, int slotNumber) {
        super(itemStates, slotNumber);
    }

    /**
     * This is a getter that returns a random ItemState of this RandomGenerator.
     * @return currentState - an ItemState that is the random selection of the RandomGenerator.
     */
    @Override
    public ItemState getCurrentState(){
        if(super.getItemStates().size() == 0){
            return null;
        }
        return super.getItemStates().get((int) (Math.random() * super.getItemStates().size()));
    }
}
