package com.bida.worktasks.ThirdTask;

import java.util.ArrayList;
import java.util.List;

public class Chest {
    private String keyForOpening;
    private List<String> keys;
    private int chestIndex;
    private boolean isReal;

    public Chest(String keys, int chestIndex){
        isReal = true;
        this.chestIndex = chestIndex;
        this.keys = new ArrayList<>();
        String[] numbers = keys.split(" ");
        this.keyForOpening = numbers[0];
        for (int i = 0; i < Integer.parseInt(numbers[1]); i++){
            this.keys.add(numbers[i + 2]);
        }
    }

    public Chest(){
        this.keys = new ArrayList<>();
        this.chestIndex = 0;
        this.keyForOpening = "";
        isReal = false;
    }

    public String getKeyForOpening() {
        return keyForOpening;
    }

    public List<String> getKeys() {
        return keys;
    }

    public int getAmountOfKeys(){
        return isReal ? keys.size() : -1;
    }

    public int getChestIndex() {
        return chestIndex;
    }
}
