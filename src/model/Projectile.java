package model;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;

import java.util.ArrayList;

public class Projectile {
    protected Cell[] location;
    protected final int damage;
    protected final boolean air;
    protected final int speedDecreasePercent;
    protected final int speedDecreasePercentTurnNumbers;
    protected int moves = 0;
    public Projectile(int damage, int speedDecreasePercent, int speedDecreasePercentTurnNumbers, boolean air, int x, int y, Map map){
        this.damage = damage;
        if (map != null) {
            location = map.getCells()[x][y];
        }
        this.air = air;
        this.speedDecreasePercent = speedDecreasePercent;
        this.speedDecreasePercentTurnNumbers = speedDecreasePercentTurnNumbers;

    }
    public void doAction(Map map){
        if (air){
            if (this.location[1].getZombies().size() != 0){
                attack(this.location[1]);
                location[0].getProjectiles().remove(this);
                return;
            }
        }
        if (this.location[0].getZombies().size() != 0){
            attack(this.location[0]);
            location[0].getProjectiles().remove(this);
            return;
        }
        move(map);
    }
    protected void move(Map map){
        if (moves < 3) {
            if (this.location[0].getY() == Map.getWidth() - 1) {
                this.location[0].getProjectiles().remove(this);
                this.location = null;
            } else {
                Cell[] newCell = map.getCells()[this.location[0].getX()][this.location[0].getY() + 1];
                moves++;
                this.location[0].getProjectiles().remove(this);
                this.location = newCell;
                this.location[0].getProjectiles().add(this);
            }
        }
    }

    public boolean movedInTurn(){
        if (moves == 3){
            return true;
        }
        return false;
    }
    protected void attack(Cell cell){
        int whichZombie = (int) Math.random() % cell.getZombies().size();
        Zombie zombie = cell.getZombies().get(whichZombie);
        zombie.decreaseHealth(damage);
    }
    public Projectile clone(int x, int y, Map map){
            return new Projectile(this.damage, this.speedDecreasePercent, this.speedDecreasePercentTurnNumbers, this.air, x, y, map);
    }
}
