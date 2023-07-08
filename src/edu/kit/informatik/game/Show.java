package edu.kit.informatik.game;

import edu.kit.informatik.Player;
import edu.kit.informatik.vegetable.Vegetable;

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


    public boolean execute() {

        if (inputSplit[0].equals("barn")) {

            storedVegetable = player.getBarn().getStoredVegetable();
            int sum = storedVegetable[0] + storedVegetable[1] + storedVegetable[2] + storedVegetable[3];

            if (player.getBarn().getSpoilCountdown() != 0) {
                System.out.println("Barn (spoils in " + player.getBarn().getSpoilCountdown() + " turns)");

                if (storedVegetable[0] > 0) {
                    System.out.println(Vegetable.SALAD.pluralVegetable() + ":\t\t" + storedVegetable[0]);
                }
                if (storedVegetable[1] > 0) {
                    System.out.println(Vegetable.CARROT.pluralVegetable() + ":\t" + storedVegetable[1]);
                }
                if (storedVegetable[2] > 0) {
                    System.out.println(Vegetable.MUSHROOM.pluralVegetable() + ":\t" + storedVegetable[2]);
                }
                if (storedVegetable[3] > 0) {
                    System.out.println(Vegetable.TOMATO.pluralVegetable() + ":\t" + storedVegetable[3]);
                }
                System.out.println("------------\n"
                        + "Sum:\t\t" + sum
                        + "\n\nGold:\t\t" + player.getCapital());

            } else {
                System.out.println("Barn\n------------\n"
                        + "Sum:\t\t" + sum
                        + "\n\nGold:\t\t" + player.getCapital());
            }
        } else {
            return false;
        }
        return true;
    }
}
