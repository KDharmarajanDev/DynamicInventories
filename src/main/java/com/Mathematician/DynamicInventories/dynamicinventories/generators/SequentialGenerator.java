package com.Mathematician.DynamicInventories.dynamicinventories.generators;

import com.Mathematician.DynamicInventories.dynamicinventories.itemstates.ItemState;

import java.util.ArrayList;

public class SequentialGenerator {

    /**
     * itemStates is an ArrayList of ItemStates that stores all possible ItemStates the DynamicInventory may display.
     */
    private ArrayList<ItemState> itemStates;

    /**
     * slotNumber is an integer that represents the slot in the DynamicInventory that this sequence is displayed.
     */
    private int slotNumber;

    /**
     * currentIndex is an internal integer that keeps track of which ItemState is displayed in itemStates.
     */
    private int currentIndex;

    /**
     * lastStartTime is the system time in milliseconds of when the most recent ItemState was displayed.
     */
    private long lastStartTime;

    /**
     * This is the only constructor for the SequentialGenerator.
     * @param itemStates - an ArrayList of ItemState that represents all possible ItemStates that could be displayed
     * @param slotNumber - an integer that represents the slot in the DynamicInventory that this sequence is displayed.
     */
    public SequentialGenerator(ArrayList<ItemState> itemStates, int slotNumber){
        this.itemStates = itemStates;
        this.slotNumber = slotNumber;
        currentIndex = 0;
        lastStartTime = 0;
    }

    /**
     * This is a getter that returns an ArrayList of ItemStates.
     * @return itemStates - an ArrayList of ItemStates that stores all possible ItemStates the DynamicInventory may display.
     */
    public ArrayList<ItemState> getItemStates() {
        return itemStates;
    }

    /**
     * This is a setter that sets itemStates.
     * @param itemStates - an ArrayList of ItemStates that stores all possible ItemStates the DynamicInventory may display.
     */
    public void setItemStates(ArrayList<ItemState> itemStates){
        this.itemStates = itemStates;
    }

    /**
     * This is a getter that returns an integer.
     * @return slotNumber - an integer that represents the slot in the DynamicInventory that this sequence is displayed.
     */
    public int getSlotNumber(){
        return slotNumber;
    }

    /**
     * This is a setter that sets slotNumber.
     * @param slotNumber - an integer that represents the slot in the DynamicInventory that this sequence is displayed.
     */
    public void setSlotNumber(int slotNumber){
        this.slotNumber = slotNumber;
    }

    /**
     * This is a getter that returns the current ItemState of this SequentialGenerator.
     * @return currentState - an ItemState that is the current state of the SequentialGenerator.
     */
    public ItemState getCurrentState(){
        if(itemStates.size() == 0){
            return null;
        }
        return itemStates.get(currentIndex);
    }

    /**
     * This method makes the SequentialGenerator go to the next state. If the currentIndex is at the end of the ArrayList, it wraps around.
     */
    public void goToNextState(){
        if(currentIndex + 1 < itemStates.size()){
            currentIndex = 0;
        } else {
            currentIndex++;
        }
        lastStartTime = System.currentTimeMillis();
    }

    /**
     * This method returns a boolean.
     * @return shouldGoToNextState - a boolean that determines if the SequentialGenerator should advance states based on duration
     */
    public boolean shouldGoToNextState(){
        return itemStates.size() > 0 && getCurrentState().getDuration() != -1 && getCurrentState().getDuration() + lastStartTime < System.currentTimeMillis();
    }
}
