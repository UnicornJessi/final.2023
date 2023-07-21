package edu.kit.informatik.vegetable;

public class StoredVegetable implements Comparable<StoredVegetable>{

    private Vegetable vegetable;
    private int amount;

    public StoredVegetable(Vegetable vegetable, int amount) {
        this.vegetable = vegetable;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

    @Override
    public int compareTo(StoredVegetable o) {

        if (amount > o.amount) {
            return 1;
        }

        if (amount < o.amount) {
            return -1;
        }

        return vegetable.singleVegetable().compareTo(o.vegetable.singleVegetable());
    }
}
