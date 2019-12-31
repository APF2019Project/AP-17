package control.Accessories;

import control.BattleClasses.Map;
import model.Zombie;

public class StrongCar extends Car {
    public StrongCar(Zombie zombie) {
        super(zombie);
    }

    @Override
    public Accessory clone(Zombie zombie) {
        return null;
    }

//    @Override
    public void doAction(Map map) {
        if (zombie.getLocation().getPlant() != null){
            zombie.getLocation().killPlant();
        }
    }
}
