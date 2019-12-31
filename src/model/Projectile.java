package model;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;

import java.util.ArrayList;

public class Projectile {
    private Cell[] location;
    private final int damage;
    private final boolean air;
    private final int speedDecreasePercent;
    Projectile(int damage, int speedDecreasePercent, boolean air, int x, int y, Map map){
        this.damage = damage;
        location = map.getCells()[x][y];
        this.air = air;
        this.speedDecreasePercent = speedDecreasePercent;

    }
    public static void moveAllProjcetiles(ArrayList<Projectile> projectiles, Map map){
        for (Projectile projectile :
                projectiles) {
            if (projectile.location[0].getY() == Map.getWidth() - 1){
                projectiles.remove(projectile);
                projectile.location = null;
                continue;
            }
            Cell[] newCell = map.getCells()[projectile.location[0].getX()][projectile.location[0].getY() + 1];
            projectile.location = newCell;
        }
    }
    public Projectile clone(int x, int y, Map map){
            return new Projectile(this.damage, this.speedDecreasePercent, this.air, x, y, map);
    }
}
