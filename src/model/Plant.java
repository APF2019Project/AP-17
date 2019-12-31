package model;

import control.Action.Action;
import control.BattleClasses.Cell;

import java.util.ArrayList;

public class Plant extends Card{
    private static ArrayList<Plant> plants = new ArrayList<>();
    private final int sunsNeeded;
    private final int cool_down;
    private final int shotDelay;
    private final int shotsPerTurn;
    private final int defentValue;
    private int lastShot = 0;
    private boolean isAvailable;
    protected boolean airShooter;
    private final Action specialTalent;
    private final Projectile projectile;
    public Plant(String name, int health, int cooldown, int sunsNeeded, int shotDelay,
                 int shotsPerTurn, int defentValue, Action specialTalent, Projectile projectile){
        super(name, health, sunsNeeded * cooldown * health + 1);
        this.cool_down = cooldown;
        this.sunsNeeded = sunsNeeded;
        this.shotDelay = shotDelay;
        this.shotsPerTurn = shotsPerTurn;
        this.specialTalent = specialTalent;
        this.projectile = projectile;
        this.defentValue = defentValue;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){
            return  new Plant(this.getName(), this.getHealth(), this.getCool_down(), this.sunsNeeded, this.shotDelay,
                    this.shotsPerTurn, this.defentValue, this.specialTalent, this.projectile);
        }
    }


    public int getCool_down() {
        return cool_down;
    }


    public boolean isAirShooter() {
        return airShooter;
    }

    public Projectile getProjectile() {
        return projectile;
    }

}
