package edu.kit.informatik.game;

import edu.kit.informatik.Player;

public class Start {

    private String name;
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
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name player names
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * get start gold
     * @return capital (star gold)
     */
    public int getCapital() {
        return capital;
    }

    /**
     * set start gold
     * @param capital start gold
     */

    public void setCapital(int capital) {
        this.capital = capital;
    }

    /**
     * get amount of players
     * @return player count
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * set amount of players
     * @param playerCount player count
     */
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    /**
     * get gold amount needed for winning
     * @return gold needed for winning
     */
    public int getWinGold() {
        return winGold;
    }

    /**
     * set amount needed for winning
     * @param winGold gold needed for winning
     */
    public void setWinGold(int winGold) {
        this.winGold = winGold;
    }

    /**
     * get seed number for shuffle
     * @return shuffle number
     */
    public int getSeed() {
        return seed;
    }

    /**
     * set seed number
     * @param seed shuffle number
     */
    public void setSeed(int seed) {
        this.seed = seed;
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

        boolean validInput = false;
        Player player = new Player(name, capital);

        while (!validInput) {
            System.out.println("How many players?");
            String input = main.getInput();
            if (!player.isPlayerCountValid(input)) {
                System.out.println("Error: Invalid number");
            } else {
                playerCount = Integer.parseInt(input);
                validInput = true;
            }
        }
        validInput = false;

        while(!validInput) {
            name = "";
            for (int i = 1; i <= playerCount; i++) {
                System.out.println("Enter the name of player " + i + ":");
                String input2 = main.getInput();

                if (!player.isNameValid(input2)) {
                    System.out.println("Error: Invalid name");
                    i--;
                } else {
                    name += input2 + " ";
                }
            }

            validInput = true;
        }
        validInput = false;

        while(!validInput) {
            System.out.println("With how much gold should each player start?");
            String input3 = main.getInput();
            if (!player.isCapitalValid(input3)) {
                System.out.println("Error: Invalid number");
            } else {
                capital = Integer.parseInt(input3);
                validInput = true;
            }
        }
        validInput = false;

        while(!validInput) {
            System.out.println("With how much gold should a player win?");
            String input4 = main.getInput();
            if (!player.isWinGoldValid(input4, capital)) {
                System.out.println("Error: Invalid amount of Gold");
            } else {
                winGold = Integer.parseInt(input4);
                validInput = true;
            }
        }
        validInput = false;

        while (!validInput) {
            System.out.println("Please enter the seed used to shuffle the tiles:");
            String input5 = main.getInput();
            if (!player.isSeedValid(input5)) {
                System.out.println("Error: Invalid number");
            } else {
                seed = Integer.parseInt(input5);
                validInput = true;
            }
        }
    }
}
