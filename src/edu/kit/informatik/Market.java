package edu.kit.informatik;

import edu.kit.informatik.vegetable.Vegetable;

import java.util.Arrays;

public class Market {

    private int mushroomPrice;
    private int carrotPrice;
    private int tomatoPrice;
    private int saladPrice;
    int[][] mushCarChart = new int[][]{{12, 3}, {15, 2}, {16, 2}, {17, 2}, {20, 1}};
    int[][] tomSalChart = new int[][]{{3, 6}, {5, 5}, {6, 4}, {7, 3}, {9, 2}};

    public Market() {
        mushroomPrice = mushCarChart[2][0];
        carrotPrice = mushCarChart[2][1];
        tomatoPrice = tomSalChart[2][0];
        saladPrice = tomSalChart[2][1];
    }

    public int[] price(int[] soledVegetable) {
        // 0 mush 1 car 2 sal 3 tom
        int j = 1;

        if (soledVegetable[0] - soledVegetable[1] >= 2) {
            for (int i = 2; i <= soledVegetable[0] - soledVegetable[1]; i++) {
                mushroomPrice = mushCarChart[2 + j][0];
                carrotPrice = mushCarChart[2 + j][1];
                i = i + 2;
                j++;
            }
        } else if (soledVegetable[1] - soledVegetable[0] >= 2) {
            for (int i = 2; i <= soledVegetable[1] - soledVegetable[0]; i++) {
                mushroomPrice = mushCarChart[2 - j][0];
                carrotPrice = mushCarChart[2 - j][1];
                i = i + 2;
                j++;
            }
        }

        j = 1;

        if (soledVegetable[3] - soledVegetable[2] >= 2) {
            for (int i = 2; i <= soledVegetable[3] - soledVegetable[2]; i++) {
                tomatoPrice = mushCarChart[2 + j][0];
                saladPrice = mushCarChart[2 + j][1];
                i = i + 2;
                j++;
            }
        } else if (soledVegetable[2] - soledVegetable[3] >= 2) {
            for (int i = 2; i <= soledVegetable[2] - soledVegetable[3]; i++) {
                tomatoPrice = mushCarChart[2 - j][0];
                saladPrice = mushCarChart[2 - j][1];
                i = i + 2;
                j++;
            }
        }

        return new int[] {mushroomPrice, carrotPrice, saladPrice, tomatoPrice};
    }

}
