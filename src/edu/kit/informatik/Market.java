package edu.kit.informatik;

import edu.kit.informatik.vegetable.Vegetable;

import java.util.Arrays;

public class Market {

    private int mushroomPrice;
    private int carrotPrice;
    private int tomatoPrice;
    private int saladPrice;
    private int[] soledVegetable = new int[Vegetable.AMOUNT_OF_VEGETABLE];

    public Market() {
        int[][] mushCarChart = new int[][]{{12, 3}, {15, 2}, {16, 2}, {17, 2}, {20, 1}};
        int[][] tomSalChart = new int[][]{{3, 6}, {5, 5}, {6, 4}, {7, 3}, {9, 2}};
        Arrays.fill(soledVegetable,0);
        mushroomPrice = mushCarChart[2][0];
        carrotPrice = mushCarChart[2][1];
        tomatoPrice = tomSalChart[2][0];
        saladPrice = tomSalChart[2][1];
    }

    public int mushroomCarrotPrice() {
        // 1 carrot und 2 mushroom

        while (soledVegetable[2] >= 2 && soledVegetable[1] >= 2) {
            int remainingM = soledVegetable[2] - 2;
            int remainingC = soledVegetable[1] - 2;
        }
        return 0;
    }
}
