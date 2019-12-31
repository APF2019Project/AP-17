package control.Action;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Plant;
import model.Projectile;

public final class Threepeater extends Action {
    public void shoot() {
        if (hasZombieInFront()) {
            Projectile projectile = plant.getProjectile().clone(plant.getLocation().getX(), plant.getLocation().getY()
                    , plant.getMap());
            plant.getMap().getProjectiles().add(projectile);
            if (plant.getLocation().getX() != Map.getHeight() - 1) {
                projectile = plant.getProjectile().clone(plant.getLocation().getX() + 1, plant.getLocation().getY()
                        , plant.getMap());
                plant.getMap().getProjectiles().add(projectile);
            }
            if (plant.getLocation().getX() != 0){
                projectile = plant.getProjectile().clone(plant.getLocation().getX() - 1, plant.getLocation().getY()
                        , plant.getMap());
                plant.getMap().getProjectiles().add(projectile);
            }
        }
    }

    public Threepeater(Plant plant) {
        super(plant);
    }

    protected boolean hasZombieInFront() {
        Cell location = plant.getLocation();
        int x = location.getX();
        Map map = plant.getMap();
        Cell[][] row = map.getCells()[x];
        int y = location.getY();
        for (int i = y; i < Map.getWidth(); i++) {
            if (x == 0) {
                Cell[][] besideRow = map.getCells()[x + 1];
                if (row[i][0].getZombies().size() != 0
                        || besideRow[i][0].getZombies().size() != 0) {
                    return true;
                }
            } else if (x == Map.getHeight() - 1) {
                Cell[][] besideRow = map.getCells()[x - 1];
                if (row[i][0].getZombies().size() != 0
                        || besideRow[i][0].getZombies().size() != 0) {
                    return true;
                }
            } else {
                Cell[][] upperRow = map.getCells()[x - 1];
                Cell[][] downRow = map.getCells()[x + 1];
                if (row[i][0].getZombies().size() != 0
                        || upperRow[i][0].getZombies().size() != 0
                        || downRow[i][0].getZombies().size() != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
