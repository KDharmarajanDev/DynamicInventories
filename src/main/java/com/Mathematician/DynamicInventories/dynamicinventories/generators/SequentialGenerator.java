package com.Mathematician.DynamicInventories.dynamicinventories.generators;

import com.Mathematician.DynamicInventories.DynamicInventoriesMain;
import com.Mathematician.DynamicInventories.dynamicinventories.itemstates.ItemState;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

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
     * currentTask is an integer that is the id of the scheduled task managing this SequentialGenerator
     */
    private int currentTask;

    /**
     * FAKE_TASK_NUMBER is an integer that represents a false number so that when cancelCurrentTask() is called, no real tasks are cancelled.
     */
    private static final int FAKE_TASK_NUMBER = -100000;

    /**
     * onItemStateChangeListener is an OnItemStateChangeListener that gets called when the current ItemState changes.
     */
    private OnItemStateChangeListener onItemStateChangeListener;

    /**
     * OnItemStateChangeListener is an interface that has an onChanged method that is called when the current ItemState changes.
     */
    public interface OnItemStateChangeListener {
        void onChanged(ItemState newItemState);
    }

    /**
     * This is the only constructor for the SequentialGenerator.
     * @param itemStates - an ArrayList of ItemState that represents all possible ItemStates that could be displayed
     * @param slotNumber - an integer that represents the slot in the DynamicInventory that this sequence is displayed.
     * @param listener - an OnItemStateChangeListener that gets called when the current ItemState changes.
     * @param shouldStart - a boolean that represents if the SequentialGenerator should start changing the ItemStates
     */
    public SequentialGenerator(ArrayList<ItemState> itemStates, int slotNumber, OnItemStateChangeListener listener, boolean shouldStart){
        this.itemStates = itemStates;
        this.slotNumber = slotNumber;
        this.onItemStateChangeListener = listener;
        currentIndex = 0;
        onItemStateChangeListener.onChanged(getCurrentState());
        if(shouldStart && itemStates.size() > 1){
            currentTask = createGoToNextStateTask();
        }
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
     * This is a setter that sets the currentIndex.
     * @param index - an integer that represents an index in itemStates (the ArrayList)
     */
    public void setCurrentIndex(int index){
        currentIndex = index;
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
    }

    /**
     * This method converts milliseconds into ticks.
     * @param milliseconds - a long that represents time in milliseconds
     * @return numTicks - a long that represents the amount of milliseconds passed in with units of ticks
     */
    public long millisecondsToTicks(long milliseconds){
        return milliseconds/1000 * 20;
    }

    /**
     * This method schedules a BukkitRunnable that is responsible for handling the call to change to the next ItemState
     */
    public int createGoToNextStateTask(){
        if (getCurrentState().getDuration() == -1){
            return FAKE_TASK_NUMBER;
        }
        return new BukkitRunnable() {
            public void run(){
                goToNextState();
                onItemStateChangeListener.onChanged(getCurrentState());
                currentIndex = createGoToNextStateTask();
            }
        }.runTaskLater(DynamicInventoriesMain.getInstance(), millisecondsToTicks(getCurrentState().getDuration()))
                .getTaskId();
    }

    /**
     * This method cancels the currentTask running
     */
    public void cancelCurrentTask(){
        Bukkit.getScheduler().cancelTask(currentTask);
    }
}
