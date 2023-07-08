package edu.kit.informatik;

import edu.kit.informatik.tiles.Barn;

public class Player {

    private String name;
    private int capital;
    private int playerCount;
    private int winGold;
    private final Barn barn;

    public Player(String name, int capital) {
        this.name = name;
        this.capital = capital;
        barn = new Barn();
    }

    public Barn getBarn() {
        return barn;
    }

    public int getCapital() {
        return capital;
    }
    public void setCapital(int capital) {
        this.capital = capital;
    }

    /**
     * checking if name input is valid
     * @param input user input
     * @return true if it's a valid name false if not
     */
    public boolean isNameValid(String input) {

        return input.matches("[A-Za-z]+");
    }
    /**
     * checking if player count input is valid
     * @param input user input
     * @return true if it's a valid number false if not
     */
    public boolean isPlayerCountValid(String input) {

        return input.matches("[0-9]+")
                && Integer.parseInt(input) >= 1;
    }

    /**
     * checking if capital input is valid
     * @param input user input
     * @return true if it's a valid number false if not
     */
    public boolean isCapitalValid(String input) {

        return input.matches("[0-9]+")
                && Integer.parseInt(input) >= 0;
    }

    /**
     * checking if gold input is valid
     * @param input user input
     * @return true if it's a valid number false if not
     */
    public boolean isWinGoldValid(String input, int capital) {
        return input.matches("[0-9]+")
                && Integer.parseInt(input) >= 0
                && Integer.parseInt(input) > capital;
    }

    /**
     * checking if seed input is valid
     * @param input user input
     * @return true if it's a valid number false if not
     */
    public boolean isSeedValid(String input) {
        return input.matches("[0-9]+")
                && Integer.parseInt(input) >= -2147483648
                && Integer.parseInt(input) <= 2147483647;
    }

}
