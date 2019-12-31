package control.BattleClasses;

import model.Card;
import model.Plant;
import model.Projectile;
import model.Zombie;

import java.util.ArrayList;
import java.util.Calendar;

public class Cell {
    protected int x;
    protected int y;
    protected boolean land;
    protected ArrayList<Zombie> zombies = new ArrayList<>();
    protected Plant plant = null;
    ArrayList<Projectile> projectiles = new ArrayList<>();

    public Cell(int x, int y, boolean land){
        this.x = x;
        this.y = y;
        this.land = land;
    }

    public Plant getPlant() {
        return plant;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void killPlant(){
        plant = null;
    }

    public boolean isLand() {
        return land;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
}
