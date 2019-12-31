package control.Action;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Plant;
import model.Projectile;

public class Shy extends Action{

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
        if (y >= Map.getWidth() - 3){
            return false;
        }
        if (hasZombieInOwnRow()){
            return true;
        }
        return false;
    }

    public Shy(Plant plant){
        super(plant);
    }
}
