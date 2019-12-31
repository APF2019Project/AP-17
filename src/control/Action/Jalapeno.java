package control.Action;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Plant;

public class Jalapeno extends Action{


    @Override
    public void shoot() {
     if (hasZombieInFront()){
         Cell[][] row = plant.getMap().getCells()[plant.getLocation().getX()];
         for (int i = 0; i < Map.getWidth(); i++) {
             Cell cell  = row[i][0];
             cell.getZombies().clear();
         }
     }
    }

    @Override
    protected boolean hasZombieInFront() {
        return true;
    }
    public Jalapeno(Plant plant) {
        super(plant);
    }

    @Override
    public Action clone(Plant plant) {
        return null;
    }
}
