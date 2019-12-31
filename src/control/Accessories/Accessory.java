package control.Accessories;

import control.BattleClasses.Map;
import model.Zombie;

public abstract class Accessory {
    public void doAction(Zombie zombie, Map map){
        if (zombie.getLocation().getPlant() != null){
            zombie.getLocation().getPlant().decreaseHealth(zombie.getDamage());
            map.checkDies();
            zombie.getLocation().getPlant().defend(zombie);
        }
    }
    public void move(Zombie zombie, Map map){

    }
}
