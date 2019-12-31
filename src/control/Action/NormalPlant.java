package control.Action;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Plant;
import model.Projectile;

public final class NormalPlant extends Action {
    @Override
    protected void shoot() {
        if (hasZombieInFront()){
            Projectile projectile = plant.getProjectile().clone(plant.getLocation().getX(), plant.getLocation().getY()
                    , plant.getMap());
            plant.getMap().getProjectiles().add(projectile);
        }
    }

    @Override
    protected boolean hasZombieInFront() {
        Cell location = plant.getLocation();
        int x = location.getX();
        Map map = plant.getMap();
        Cell[][] row = map.getCells()[x];
        int y = location.getY();
        for (int i = y; i < row.length; i++) {
            if (!plant.isAirShooter()) {
                if (row[i][0].getZombies().size() != 0) {
                    return true;
                }
            } else {
                if (row[i][0].getZombies().size() != 0
                        || row[i][1].getZombies().size() != 0) {
                    return true;
                }
            }
        }
        return false;
    }
    public NormalPlant(Plant plant){
        super(plant);
    }

}
