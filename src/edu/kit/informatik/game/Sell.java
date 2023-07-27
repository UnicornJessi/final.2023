package edu.kit.informatik.game;

import edu.kit.informatik.Market;
import edu.kit.informatik.Player;
import edu.kit.informatik.vegetable.Vegetable;

import java.util.Arrays;

public class Sell {
    private int[] soledVegetable = new int[Vegetable.AMOUNT_OF_VEGETABLE];
    private final String[] inputSplit;
    private final Player player;
    int gold = 0;
    int sumVeg = 0;

    public Sell(Player player, String[] inputSplit) {
        Arrays.fill(soledVegetable,0);
        this.player = player;
        this.inputSplit = inputSplit;
    }

    public void setSoledVegetable(int[] soledVegetable) {
        this.soledVegetable = soledVegetable;
    }

    public int[] getSoledVegetable() {
        return soledVegetable;
    }

    private void sellVegetable(int[] prices, int[] storedVegetable, int i) {
        if (storedVegetable[i] > 0) {
            gold += prices[i];
            sumVeg++;
            storedVegetable[i]--;
            soledVegetable[i]++;
        }
    }

    private void sellAll(int[] prices,int[] storedVegetable, int i) {
        if (storedVegetable[i] >= 1) {
            gold += prices[i] * storedVegetable[i];
            sumVeg += storedVegetable[i];
            soledVegetable[i] = storedVegetable[i];
            storedVegetable[i] = 0;
        }
    }
    //TODO: Was wenn kein vegetable nach sell?

    public void execute() {
        Market market = new Market();
        int[] prices = market.price(soledVegetable); //0 mush 1 car 2 sal 3 tom
        int[] storedVegetable = player.getBarn().getStoredVegetable();

        if (inputSplit[0].equals("all")) {
            for (int i = 0; i < storedVegetable.length; i++) {
                switch (i) {
                    case 0 -> sellAll(prices, storedVegetable, 0);
                    case 1 -> sellAll(prices, storedVegetable, 1);
                    case 2 -> sellAll(prices, storedVegetable, 2);
                    case 3 -> sellAll(prices, storedVegetable, 3);
                }
            }
        } else {
            for (String s : inputSplit) {
                switch (s) {
                    case "mushroom" -> sellVegetable(prices, storedVegetable, 0);
                    case "carrot" -> sellVegetable(prices, storedVegetable, 1);
                    case "salad" -> sellVegetable(prices, storedVegetable, 2);
                    case "tomato" -> sellVegetable(prices, storedVegetable, 3);
                }
            }
        }
        player.setCapital(gold);
        player.getBarn().setStoredVegetable(storedVegetable);

        if (sumVeg <= 1) {
            System.out.println("You have sold " + sumVeg + " vegetable for " + gold + " gold.");
        } else {
            System.out.println("You have sold " + sumVeg + " vegetables for " + gold + " gold.");
        }
    }
}
