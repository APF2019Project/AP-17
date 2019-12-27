package model;

import java.util.ArrayList;

public class Plant extends Card{
    private static ArrayList<Plant> plants = new ArrayList<>();
    private final int sunsNeeded;
    private final int cooldown;
    private final int shotDelay;
    private int lastShot = 0;
    private boolean isAvailable;
    public Plant(String name, int health, int cooldown, int sunsNeeded, int shotDelay){
        super(name, health, sunsNeeded * cooldown * health + 1);
        this.cooldown = cooldown;
        this.sunsNeeded = sunsNeeded;
        this.shotDelay = shotDelay;
    }
}
