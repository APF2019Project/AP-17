package model;

import control.BattleClasses.Cell;

import java.util.ArrayList;

public abstract class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private final String name;
    private Cell location;
    private final int price;
    private final int health;

    public Card(String name, int health, int price) {
        this.name = name;
        this.health = health;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
