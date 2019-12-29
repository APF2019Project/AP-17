package model;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;

import java.util.ArrayList;

public class Projectile {
    private Cell[] location;
    private final int DAMAGE = 1;
    private final boolean air;
    Projectile(boolean air, int x, int y, boolean land, Map map){
        location = map.getCells()[x][y];
        this.air = air;
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
}
