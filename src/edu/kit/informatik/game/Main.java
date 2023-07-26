package edu.kit.informatik.game;

import edu.kit.informatik.Player;

import java.util.Scanner;

public class Main {

    private String command;
    private String[] inputSplit;
    private String[] playerNames;
    private int amount;
    private int capital;
    private int playerCount;
    private int winGold;
    private long seed;
    private int spoilCountdown;
    private int moves;
    public Player[] players;
    public Start start;
    private final Scanner scanner;

    /**
     * In and Output handler.
     *
     * @author ununm
     */

    public Main() {
        scanner = new Scanner(System.in);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.loop();
    }

    /**
     * Getting player input.
     * @return input
     */
    public String getInput() {
        return scanner.nextLine();
    }

    /**
     * get player commands.
     */

    public void getCommand() {
        String input = scanner.nextLine();
        inputSplit = input.split(" ");
        command = inputSplit[0];

        if (input.length() != command.length()) {
            inputSplit = input.substring(command.length() + 1).split(" ");
        }
    }
    /**
     * Main loop for the game.
     */
    public void loop() {

        start = new Start(this);
        start.execute();
        playerCount = start.getPlayerCount();
        playerNames = start.getNames();
        capital = start.getCapital();
        winGold = start.getWinGold();
        seed = start.getSeed();

        //TODO: Shuffle
        players = new Player[playerCount];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i], capital);
        }
        //TODO: jeden spieler testen ob win

        while (true) {

            for (int i = 0; i < playerNames.length; i++) {
                System.out.println("It is " + playerNames[i] + "'s turn!");
                moves = 0;

                while (moves != 2) {
                    getCommand();
                    if (command.equals("show")) {
                        if (!new Show(players[i], inputSplit, this).execute()) {
                            System.out.println("Error: Command does not exist");
                        }
                    } else if (command.equals("sell")) {
                        if (!new Sell(this, players[i], inputSplit).execute()) {
                            System.out.println("Error: Command does not exist");
                        }
                    } else {
                        System.out.println("Error: Command does not exist");
                    }
                }
            }
        }
    }
}
