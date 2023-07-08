package edu.kit.informatik.tiles;

import edu.kit.informatik.vegetable.Vegetable;

import java.util.Arrays;

public class Barn {

    //TODO: Start vegetable
    //TODO: add vegetable
    //TODO: Spoil countdown
    //TODO: vegetable stored
    private int spoilCountdown;

    private int[] storedVegetable = new int[Vegetable.AMOUNT_OF_VEGETABLE];

    public Barn() {
        Arrays.fill(storedVegetable,1);
        this.spoilCountdown = 6;

        //TODO: Spoil countdown not here T_T
    }

    public int getSpoilCountdown() {
        return spoilCountdown;
    }
    public void setSpoilCountdown(int spoilCountdown) {
        this.spoilCountdown = spoilCountdown;
    }

    public int[] getStoredVegetable() {
        return storedVegetable;
    }

    public void setStoredVegetable(int[] storedVegetable) {
        this.storedVegetable = storedVegetable;
    }

    public void addVegetable(Vegetable vegetable, int amount) {
        storedVegetable[vegetable.vegetableIndex()] += amount;
    }

    public int spoilCountdown(int spoilCountdown) {
        spoilCountdown -= 1;
        return spoilCountdown;
    }

}
