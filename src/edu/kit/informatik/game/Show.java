package edu.kit.informatik.game;

import edu.kit.informatik.Player;
import edu.kit.informatik.vegetable.Vegetable;
import edu.kit.informatik.OutputFormat;


public class Show {

    private Player player;
    private String[] inputSplit;
    private int[] storedVegetable;
    private final Main main;

    public Show(Player player, String[] inputSplit, Main main) {
        this.player = player;
        this.inputSplit = inputSplit;
        this.main = main;
    }

    private StringBuilder barnContent() {
        StringBuilder stringBuilder = new StringBuilder();
        storedVegetable = player.getBarn().getStoredVegetable();
        int sum = storedVegetable[0] + storedVegetable[1] + storedVegetable[2] + storedVegetable[3];
        for (int i = 0; i < 4; i++) {
            if (storedVegetable[i] > 0) {
                stringBuilder.append(Vegetable.vegetableIndex2(i).pluralVegetable()).
                        append(": ").append(storedVegetable[i]).append("\n");
            }
        }
        stringBuilder.append("Sum: ").append(sum).append("\nGold: ").append(player.getCapital());
        return stringBuilder;
    }

    public boolean execute() {

        if (inputSplit[0].equals("barn")) {

            StringBuilder stringBuilder = barnContent();
            int longest = new OutputFormat().calculateLongestLine(stringBuilder);
            stringBuilder = new OutputFormat().whiteSpaces(longest, stringBuilder);
            System.out.println(stringBuilder);
        } else {
            return false;
        }
        return true;
    }
}
