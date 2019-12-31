package control.Action;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Plant;
import model.Projectile;
import model.ReverseProjectile;

public class SplitPea  extends Action{
    private ReverseProjectile reverseProjectile;
//    private ReverseProjectile reverseProjectile = new ReverseProjectile();
    @Override
    public void shoot() {
        if (hasZombieInFront()){
            Projectile projectile = plant.getProjectile().clone(plant.getLocation().getX(), plant.getLocation().getY()
                    , plant.getMap());
            plant.getLocation().getProjectiles().add(projectile);
        }
        if (hasZombieInBack()){
            ReverseProjectile newReverseProjectile =  reverseProjectile.clone(plant.getLocation().getX(),
                    plant.getLocation().getY(), plant.getMap());
            plant.getLocation().getProjectiles().add(newReverseProjectile);
        }
    }

    @Override
    protected boolean hasZombieInFront() {
        if (hasZombieInOwnRow()){
            return true;
        } else {
            return false;
        }
    }

    private boolean hasZombieInBack(){
        Cell location = plant.getLocation();
        int x = location.getX();
        Map map = plant.getMap();
        Cell[][] row = map.getCells()[x];
        int y = location.getY();
        for (int i = y; i >= 0; i--) {
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

    public SplitPea(Plant plant){
        super(plant);
    }

    @Override
    public Action clone(Plant plant) {
        return null;
    }
}
