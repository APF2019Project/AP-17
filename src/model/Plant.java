package model;

import control.BattleClasses.Cell;

import java.util.ArrayList;

public class Plant extends Card{
    private static ArrayList<Plant> plants = new ArrayList<>();
    private final int sunsNeeded;
    private final int cool_down;
    private final int shotDelay;
    private int lastShot = 0;
    private boolean isAvailable;
    public Plant(String name, int health, int cooldown, int sunsNeeded, int shotDelay){
        super(name, health, sunsNeeded * cooldown * health + 1);
        this.cool_down = cooldown;
        this.sunsNeeded = sunsNeeded;
        this.shotDelay = shotDelay;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){
            return  new Plant(this.getName(), this.getHealth(), this.getCool_down(), this.sunsNeeded, this.shotDelay);
        }
    }


    public int getCool_down() {
        return cool_down;
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    private final boolean hasCardInFront(){
        int x = location.getX();
        Cell[][] row = map.getCells()[x];
        int y = location.getY();
        for (int i = y; i < row.length; i++) {
            if (!airShooter){
                if (row[i][0].getZombies().size() != 0){
                    return true;
                }
            } else {
                if (row[i][0].getZombies().size() != 0
                        || row[i][1].getZombies().size() != 0){
                    return true;
                }
            }
        }
        return false;
    }
}
