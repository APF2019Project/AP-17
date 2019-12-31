package model;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;

import java.util.ArrayList;

public final class ReverseProjectile extends Projectile{
    public ReverseProjectile(int damage, int speedDecreasePercent, int speedDecreasePercentTurnNumbers, boolean air, int x, int y, Map map){
        super(damage, speedDecreasePercent, speedDecreasePercentTurnNumbers, air, x, y, map);
    }
    protected void move(Map map){
        if (this.location[0].getY() == 0){
            location[0].getProjectiles().remove(this);
            this.location = null;
        } else {
            Cell[] newCell = map.getCells()[this.location[0].getX()][this.location[0].getY() - 1];
            this.location = newCell;
        }
    }
    public ReverseProjectile clone(int x, int y, Map map){
        return new ReverseProjectile(this.damage, this.speedDecreasePercent, this.speedDecreasePercentTurnNumbers, this.air, x, y, map);
    }
}
