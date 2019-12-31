package control.Action;

import model.Plant;

public class SunProducer  extends Action{

    @Override
    protected void shoot() {
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
}
