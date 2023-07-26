package edu.kit.informatik.vegetable;

public enum Vegetable {
    MUSHROOM,
    CARROT,
    SALAD,
    TOMATO;

    public static final int AMOUNT_OF_VEGETABLE = 4;


    public String pluralVegetable() {
        return switch (this) {
            case SALAD -> "salads";
            case CARROT -> "carrots";
            case MUSHROOM -> "mushrooms";
            case TOMATO -> "tomatoes";
            default -> "";
        };
    }
    
    public String singleVegetable() {
        return switch (this) {
            case SALAD -> "salad";
            case CARROT -> "carrot";
            case MUSHROOM -> "mushroom";
            case TOMATO -> "tomato";
            default -> "";
        };
    }

    public int vegetableIndex() {
        return switch (this) {
            case MUSHROOM -> 0;
            case CARROT -> 1;
            case SALAD -> 2;
            case TOMATO -> 3;
        };
    }

    public static Vegetable vegetableIndex2(int number) {

        return switch (number) {
            case 0 -> MUSHROOM;
            case 1 -> CARROT;
            case 2 -> SALAD;
            case 3 -> TOMATO;
            default -> null;
        };
    }

}
