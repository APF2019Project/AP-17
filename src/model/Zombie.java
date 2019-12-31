package model;
import control.BattleClasses.Cell;
import control.Accessories.Accessory;

import java.util.ArrayList;

public class Zombie extends Card {
    private static ArrayList<Zombie> zombies = new ArrayList<>();
    private int speed;
    private Accessory accessory;
    public Zombie(String name, int health, int speed, int damage){
        super(name, health, (1 + speed) * health * 10);
        this.speed = speed;
        this.damage = damage;
    }

    private Cell location;
    private final int damage;

    public Cell getLocation(){
        return location;
    }

    public int getDamage() {
        return damage;
    }
}
