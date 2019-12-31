package model;

import control.Action.Action;
import model.PlayerTypes.Player;

public class Plant extends Card{
    private Player player;
    private final int sunsNeeded;
    private final int cool_down;
    private final int shotDelay;
    private final int shotsPerTurn;
    private final int defendValue;
    private int remainedCooldown;
    private boolean isAvailable;
    protected boolean airShooter;
    private final Action specialTalent;
    private final Projectile projectile;
    public Plant(Player player,String name, int health, int cooldown, int sunsNeeded, int shotDelay,
                 int shotsPerTurn, int defendValue, Action specialTalent, Projectile projectile){
        super(name, health, sunsNeeded * cooldown * health + 1);
        this.player = player;
        this.cool_down = cooldown;
        this.sunsNeeded = sunsNeeded;
        this.shotDelay = shotDelay;
        this.shotsPerTurn = shotsPerTurn;
        this.specialTalent = specialTalent;
        this.projectile = projectile;
        this.defendValue = defendValue;
        this.remainedCooldown = 0;
    }

    public void defend(Zombie zombie){

    }

    @Override
    public Object clone(){
        try {
            return super.clone();
        } catch (CloneNotSupportedException e){
            return  new Plant(this.player, this.getName(), this.getHealth(), this.getCool_down(), this.sunsNeeded, this.shotDelay,
                    this.shotsPerTurn, this.defendValue, this.specialTalent, this.projectile);
        }
    }

    public void decreaseHealth(int amount){
        this.health -= amount;
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

    public int getSunsNeeded(){
        return sunsNeeded;
    }

    public int getRemainedCooldown(){
        return remainedCooldown;
    }

    public Action getSpecialTalent() {
        return specialTalent;
    }
}
