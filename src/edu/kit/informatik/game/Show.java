package edu.kit.informatik.game;

import edu.kit.informatik.Player;
import edu.kit.informatik.vegetable.Vegetable;
import edu.kit.informatik.OutputFormat;


public class Show {

    private Player player;
    private String[] inputSplit;
    private final Main main;

    public Show(Player player, String[] inputSplit, Main main) {
        this.player = player;
        this.inputSplit = inputSplit;
        this.main = main;
    }

    private String barnVegetables() {
        StringBuilder stringBuilder = new StringBuilder();
        int[] storedVegetable = player.getBarn().getStoredVegetable();
        for (int i = 0; i < 4; i++) {
            if (storedVegetable[i] > 0) {
                stringBuilder.append(Vegetable.vegetableIndex2(i).pluralVegetable()).
                        append(": ").append(storedVegetable[i]).append("\n");
            }
        }

        return stringBuilder.toString();
    }

    private String barnStats() {
        int[] storedVegetable = player.getBarn().getStoredVegetable();
        int sum = storedVegetable[0] + storedVegetable[1] + storedVegetable[2] + storedVegetable[3];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sum: ").append(sum).append("\nGold: ").append(player.getCapital());

        return stringBuilder.toString();
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
        } else {
            return false;
        }
        return true;
    }
}
