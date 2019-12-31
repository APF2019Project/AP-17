package model;

import control.Accessories.Accessory;
import control.BattleClasses.Cell;
import model.PlayerTypes.Player;

import java.util.ArrayList;

public class Zombie extends Card {
    private final int speed;
    private Accessory accessory;
    private Cell location;
    private final int damage;
    private int moves;
    public Zombie(String name, int health, int speed, int damage, boolean water, Player player){
        super(name, health, (1 + speed) * health * 10, water, player);
        this.speed = speed;
        this.damage = damage;
        this.accessory = accessory;
    }
    public Zombie(String name, int health, int speed, int damage, boolean water){
        super(name, health, (1 + speed) * health * 10, water);
        this.speed = speed;
        this.damage = damage;
        this.accessory = accessory;
    }
    public Cell getLocation(){
        return location;
    }

    public int getDamage() {
        return damage;
    }

    public int getMoves() {
        return moves;
    }
    public void increaseMoves(){
        moves++;
    }
    public void resetMoves(){
        moves = 0;
    }

    public Zombie clone(){
        Zombie zombie = new Zombie(this.name, this.health, this .speed, this.damage, this.water);
        zombie.accessory = this.accessory.clone(this);
        return zombie;
    }

    public void decreaseHealth(int amount){
        health -= amount;
    }

    public boolean movedInTurn(){
        if (moves == speed){
            return true;
        }
        return false;
    }
    public Accessory getAccessory() {
        return accessory;
    }

    public void setLocation(Cell location) {
        this.location = location;
    }

    public int getSpeed(){
        return speed;
    }

    public void setAccessory(Accessory accessory){
        this.accessory = accessory;
    }
}
