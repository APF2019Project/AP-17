package model;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;

import java.util.ArrayList;

public class Projectile {
    protected Cell[] location;
    protected final int damage;
    protected final boolean air;
    protected final int speedDecreasePercent;
    Projectile(int damage, int speedDecreasePercent, boolean air, int x, int y, Map map){
        this.damage = damage;
        location = map.getCells()[x][y];
        this.air = air;
        this.speedDecreasePercent = speedDecreasePercent;

    }
    public static void moveAllProjcetiles( Map map){
        ArrayList<Projectile> projectiles = map.getProjectiles();
        for (Projectile projectile :
                projectiles) {
            projectile.move(map);
        }
    }
    protected void move(Map map){
        ArrayList<Projectile> projectiles = map.getProjectiles();
        if (this.location[0].getY() == Map.getWidth() - 1){
            projectiles.remove(this);
            this.location = null;
        } else {
            Cell[] newCell = map.getCells()[this.location[0].getX()][this.location[0].getY() + 1];
            this.location = newCell;
        }
    }
    public Projectile clone(int x, int y, Map map){
            return new Projectile(this.damage, this.speedDecreasePercent, this.air, x, y, map);
    }
}
