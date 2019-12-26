package model;

import java.util.ArrayList;

public class Plant extends Card{
    private static ArrayList<Plant> plants = new ArrayList<>();
    private int sun;
    private int cooldown;
    private boolean isAvailable;
    public Plant(String name, int health, int cooldown, int sun){
        super(name, health, sun * cooldown * health + 1);
        this.cooldown = cooldown;
        this.sun = sun;
    }
}
