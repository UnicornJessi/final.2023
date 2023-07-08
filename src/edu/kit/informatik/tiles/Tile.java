package edu.kit.informatik.tiles;

import edu.kit.informatik.game.Main;

public class Tile {

    private int playerCount;
    private int amount;
    private final Main main;

    public Tile(Main main) {
       this.main = main;
    }

    public int amountOfTile(int amount) {
        playerCount = main.start.getPlayerCount();
        return amount * playerCount;
    }


}
