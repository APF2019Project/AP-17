package control.Action;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import control.GameModes.Day;
import model.Plant;
import view.BattleViews;

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
    public void plant(int row, int column, Map map, Day day){
        if (row > Map.getHeight()){
            BattleViews.invalidRowNumberError();
            return;
        }
        if (column > Map.getWidth()){
            BattleViews.invalidColumnNumberError();
            return;
        }
        Cell cell = map.getCells()[row][column][0];
        if ((!day.selectedPlant.isWater() && !cell.isLand())
        || day.selectedPlant.isWater() || cell.isLand()){
            BattleViews.WaterLandError();
            return;
        }
        if (cell.getPlant() != null){
            BattleViews.cellIsFullError();
        }
        cell.setPlant(day.selectedPlant);
    }
    protected final boolean isZombieInCell(Cell cell) {
        if (cell.getZombies().size() != 0){
            return true;
        }
        return false;
    }
}
