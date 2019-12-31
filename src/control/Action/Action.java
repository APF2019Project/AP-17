package control.Action;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Plant;

public abstract class Action {
    protected Plant plant;

    protected abstract void shoot();

    protected abstract boolean hasZombieInFront();

    public Action(Plant plant) {
        this.plant = plant;
    }

    protected final boolean hasZombieInOwnRow() {
        Cell location = plant.getLocation();
        int x = location.getX();
        Map map = plant.getMap();
        Cell[][] row = map.getCells()[x];
        int y = location.getY();
        for (int i = y; i < row.length; i++) {
            if (!plant.isAirShooter()) {
                if (isZombieInCell(row[i][0])) {
                    return true;
                }
            } else {
                if (isZombieInCell(row[i][0])
                        || isZombieInCell(row[i][1])){
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean isZombieInCell(Cell cell) {
        if (cell.getZombies().size() != 0){
            return true;
        }
        return false;
    }
}
