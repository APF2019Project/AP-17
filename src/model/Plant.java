package model;

import java.util.ArrayList;

public class Plant extends Card{
    private static ArrayList<Plant> plants = new ArrayList<>();
    private int cooldown;
    private boolean isAvailable;
    public Plant(){
        super();
    }
}
