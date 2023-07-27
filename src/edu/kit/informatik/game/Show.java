package edu.kit.informatik.game;

import edu.kit.informatik.Market;
import edu.kit.informatik.Player;
import edu.kit.informatik.vegetable.StoredVegetable;
import edu.kit.informatik.vegetable.Vegetable;
import edu.kit.informatik.OutputFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Show {

    private final Player player;
    private final String[] inputSplit;

    public Show(Player player, String[] inputSplit) {
        this.player = player;
        this.inputSplit = inputSplit;
    }

    private String barnVegetables() {
        StringBuilder stringBuilder = new StringBuilder();
        int[] storedVegetableAmount = player.getBarn().getStoredVegetable();

        List<StoredVegetable> storedVegetables = new ArrayList<StoredVegetable>();
        for (Vegetable v : Vegetable.values()) {
            storedVegetables.add(new StoredVegetable(v, storedVegetableAmount[v.vegetableIndex()]));
        }

        Collections.sort(storedVegetables);

        for (StoredVegetable v: storedVegetables) {
            if (storedVegetableAmount[v.getVegetable().vegetableIndex()] > 0) {
                stringBuilder.append(v.getVegetable().pluralVegetable()).
                        append(": ").append(v.getAmount()).append("\n");
            }
        }

        return stringBuilder.toString();
    }
    private String marketPrices(int[] prices, int[] soledVegetable) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < soledVegetable.length; i++) {
            stringBuilder.append(Vegetable.vegetableIndex2(i).pluralVegetable()).
                    append(": ").append(prices[i]).append("\n");
        }
        return stringBuilder.toString();
    }

    private String barnStats() {
        int[] storedVegetable = player.getBarn().getStoredVegetable();
        int sum = storedVegetable[0] + storedVegetable[1] + storedVegetable[2] + storedVegetable[3];

        return "Sum: " + sum + "\n\nGold: " + player.getCapital();
    }

    public boolean execute() {

        if (inputSplit[0].equals("barn")) {

            String vegetables = barnVegetables();
            String stats = barnStats();
            int longest = OutputFormat.calculateLongestLine(vegetables + stats);
            String part1 = OutputFormat.whiteSpaces(longest, vegetables);

            String part2 = "-".repeat(longest)+"\n";
            String part3 = OutputFormat.whiteSpaces(longest, stats);

            System.out.println(part1 + part2 + part3);

            return true;
        } else if (inputSplit[0].equals("market")) {

            Sell sell = new Sell(player, inputSplit);
            int[] soledVegetable = sell.getSoledVegetable();

            Market market = new Market();
            int[] prices = market.price(soledVegetable);
            String output = marketPrices(prices, soledVegetable);
            int longest = OutputFormat.calculateLongestLine(output);
            output = OutputFormat.whiteSpaces(longest, output);
            System.out.println(output);

            return true;
        }
        return false;
    }
}
