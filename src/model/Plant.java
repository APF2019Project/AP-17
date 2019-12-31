package model;

import control.Action.Action;
import control.BattleClasses.Cell;
import model.PlayerTypes.Player;

import java.util.ArrayList;

public class Plant extends Card{
    private Player player;
    private final int sunsNeeded;
    private final int cool_down;
    private final int shotDelay;
    private final int shotsPerTurn;
    private final int defendValue;
    private int lastShot;
    private boolean isAvailable;
    protected boolean airShooter;
    private final Action specialTalent;
    private final Projectile projectile;
    public Plant(Player player,String name, int health, int cooldown, int sunsNeeded, int shotDelay,
                 int shotsPerTurn, int defendValue, int lastShot, Action specialTalent, Projectile projectile){
        super(name, health, sunsNeeded * cooldown * health + 1);
        this.player = player;
        this.cool_down = cooldown;
        this.sunsNeeded = sunsNeeded;
        this.shotDelay = shotDelay;
        this.shotsPerTurn = shotsPerTurn;
        this.specialTalent = specialTalent;
        this.projectile = projectile;
        this.defendValue = defendValue;
        this.lastShot = lastShot;
    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){
            return  new Plant(this.player, this.getName(), this.getHealth(), this.getCool_down(), this.sunsNeeded, this.shotDelay,
                    this.shotsPerTurn, this.defendValue, this.lastShot, this.specialTalent, this.projectile);
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

    public int getShotsPerTurn(){
        return shotsPerTurn;
    }

    public Player getPlayer() {
        return player;
    }
    public void decreaseHealth(int amount){
        this.health -= amount;
    }
    public void defend(Zombie zombie){

    }
}
