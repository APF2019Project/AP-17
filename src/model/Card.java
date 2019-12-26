package model;

import control.BattleClasses.Cell;

import java.util.ArrayList;

public abstract class Card {
    private static ArrayList<Card> cards = new ArrayList<>();
    private String name;
    private Cell location;
    private int price;
    private int health;
    private int cooldown;

    public Card(String name, int price, int cooldown){
        this.name = name;
        this.price = price;
        this.cooldown = cooldown;
    }
}