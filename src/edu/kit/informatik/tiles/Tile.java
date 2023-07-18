package edu.kit.informatik.tiles;

import edu.kit.informatik.game.Main;

public class Tile {
    private final Main main;

    public Tile(Main main) {
       this.main = main;
    }

    public int amountOfTile(int amount) {
        return amount * main.start.getPlayerCount();
    }


}
