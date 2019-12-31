package model;

import control.Accessories.Car;
import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.PlayerTypes.Player;

import java.util.ArrayList;

public abstract class Card {
    protected final String name;
    protected Cell location;
    protected final int price;
    protected final int maxHealth;
    protected int health;
    protected Player player;
    protected Map map;
    protected final boolean water;

    public Card(String name, int maxHealth, int price, boolean water, Player player) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.price = price;
        this.water = water;
        this.player = player;
    }
    public Card(String name, int maxHealth, int price, boolean water) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.price = price;
        this.water = water;
    }



    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Cell getLocation() {
        return location;
    }

    public Map getMap() {
        return map;
    }

    public boolean isWater() {
        return water;
    }
}
