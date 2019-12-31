package control.Action;

import model.Plant;

public abstract class Action {
    protected Plant plant;
    protected abstract void shoot();
    protected abstract boolean hasZombieInFront();
    public Action(Plant plant){
        this.plant = plant;
    }
}
