package control.Action;

import model.Plant;

public class SunProducer  extends Action{

    @Override
    public void shoot() {
        if (hasZombieInFront()){
            plant.getPlayer().inceraseSuns(plant.getShotsPerTurn());
        }
    }

    @Override
    protected boolean hasZombieInFront() {
        return true;
    }
    public SunProducer(Plant plant) {
        super(plant);
    }

    @Override
    public Action clone(Plant plant) {
        return null;
    }
}
