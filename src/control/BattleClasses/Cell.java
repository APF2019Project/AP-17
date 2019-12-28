package control.BattleClasses;

import model.Card;
import model.Plant;

import java.util.ArrayList;
import java.util.Calendar;

public class Cell {
    protected int x;
    protected int y;
    protected boolean land;
    protected ArrayList<Card> cards = new ArrayList<>();
    protected Plant plant = null;

    public Cell(int x, int y, boolean land){
        this.x = x;
        this.y = y;
        this.land = land;
    }

    public Plant getPlant() {
        return plant;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
