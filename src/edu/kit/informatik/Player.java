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
}
