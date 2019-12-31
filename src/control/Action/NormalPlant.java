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
        if (hasZombieInOwnRow()){
            return true;
        }
        return false;
    }
    public NormalPlant(Plant plant){
        super(plant);
    }

}
