package edu.kit.informatik.game;

import edu.kit.informatik.Player;

public class Start {

    private String[] names;
    private int capital;
    private int playerCount;
    private int winGold;
    private int seed;
    private final Main main;

    /**
     * Game Start
     * @param main
     */

    public Start(Main main) {
        this.main = main;
    }

    /**
     * get name
     * @return name
     */
    public String[] getNames() {
        return names;
    }

    /**
     * get start gold
     * @return capital (star gold)
     */
    public int getCapital() {
        return capital;
    }

    /**
     * get amount of players
     * @return player count
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * get gold amount needed for winning
     * @return gold needed for winning
     */
    public int getWinGold() {
        return winGold;
    }


    /**
     * get seed number for shuffle
     * @return shuffle number
     */
    public int getSeed() {
        return seed;
    }

    /**
     * Start of game.
     */
    public void execute() {

        System.out.println("""
                                           _.-^-._    .--.   \s
                                        .-'   _   '-. |__|   \s
                                       /     |_|     \\|  |   \s
                                      /               \\  |   \s
                                     /|     _____     |\\ |   \s
                                      |    |==|==|    |  |   \s
                  |---|---|---|---|---|    |--|--|    |  |   \s
                  |---|---|---|---|---|    |==|==|    |  |   \s
                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                ^^^^^^^^^^^^^^^ QUEENS FARMING ^^^^^^^^^^^^^^^
                ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                """);


        playerCount = getValue("How many players?", 1, Integer.MAX_VALUE);

        names = getNamesInput();

        capital = getValue("With how much gold should each player start?", 0, Integer.MAX_VALUE);

        winGold = getValue("With how much gold should a player win?", capital, Integer.MAX_VALUE);

        seed = getValue("Please enter the seed used to shuffle the tiles:",
                Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private String[] getNamesInput() {
        names = new String[playerCount];

        for (int i = 0; i < playerCount; i++) {
            System.out.println("Enter the name of player " + (i + 1) + ":");
            String input = main.getInput();

            if (!input.matches("[A-Za-z]+")) {
                System.out.println("Error: Invalid name");
                i--;
            } else {
                names[i] = input;
            }
        }
        return names;
    }

    private int getValue(String message, int minValue, int maxValue) {
        while (true) {
            System.out.println(message);
            String input = main.getInput();
            try {
                int result = Integer.parseInt(input);
                if (result>= minValue && result <= maxValue) {
                    return result;
                } else {
                    System.out.println("Error: Invalid number.");
                }
            }
            catch(NumberFormatException e) {
                System.out.println("Error: Invalid number format.");
            }
        }
    }
}
