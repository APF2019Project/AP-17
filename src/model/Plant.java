package model;

import control.Action.Action;
import control.BattleClasses.Cell;
import model.PlayerTypes.Player;

import java.util.ArrayList;

public class Plant extends Card{
    private final int sunsNeeded;
    private final int cool_down;
    private final int shotDelay;
    private final int shotsPerTurn;
    private final int defendValue;
    private int remainedCooldown = 0;
    private int lastShot = 0;
    private final boolean airShooter;
    private Action specialTalent;
    private final Projectile projectile;
    public Plant(String name, int health, int cooldown, int sunsNeeded, int shotDelay,
                 int shotsPerTurn, int defendValue, boolean water, boolean airShooter,
                 Projectile projectile, Player player){
        super(name, health, sunsNeeded * cooldown * health + 1, water, player);
        this.cool_down = cooldown;
        this.sunsNeeded = sunsNeeded;
        this.shotDelay = shotDelay;
        this.shotsPerTurn = shotsPerTurn;
        this.airShooter = airShooter;
        this.projectile = projectile;
        this.defendValue = defendValue;
    }

    public Plant(String name, int health, int cooldown, int sunsNeeded, int shotDelay,
                 int shotsPerTurn, int defendValue, boolean water, boolean airShooter, Projectile projectile){
        super(name, health, sunsNeeded * cooldown * health + 1, water);
        this.cool_down = cooldown;
        this.sunsNeeded = sunsNeeded;
        this.shotDelay = shotDelay;
        this.shotsPerTurn = shotsPerTurn;
        this.airShooter = airShooter;
        this.specialTalent = specialTalent;
        this.projectile = projectile;
        this.defendValue = defendValue;
        this.remainedCooldown = 0;
    }
    public void setSpecialTalent(Action action){
        this.specialTalent = specialTalent;
    }

    public void defend(Zombie zombie){

    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){
            Plant plant = new Plant(this.getName(), this.getHealth(), this.getCool_down(), this.sunsNeeded,
                    this.shotDelay, this.shotsPerTurn, this.defendValue,
                    this.water, this.airShooter, this.projectile, this.player);
            plant.specialTalent = this.specialTalent.clone(plant);
            return plant;
        }
    }

    public void decreaseHealth(int amount){
        this.health -= amount;
    }


    public int getCool_down() {
        return cool_down;
    }


    public Projectile getProjectile() {
        return projectile;
    }

    public int getShotsPerTurn(){
        return shotsPerTurn;
    }

    public Player getPlayer() {
        return player;
    }

    public int getSunsNeeded(){
        return sunsNeeded;
    }

    public int getRemainedCooldown(){
        return remainedCooldown;
    }

    public Action getSpecialTalent() {
        return specialTalent;
    }

    public void decreaseRemainedCooldown(){
        remainedCooldown--;
    }

    public int getLastShot() {
        return lastShot;
    }
    public void decreaseLastShot(){
        lastShot--;
    }
    public void resetLastShot(){
        lastShot = shotDelay;
    }

    public boolean isAirShooter() {
        return airShooter;
    }
}
