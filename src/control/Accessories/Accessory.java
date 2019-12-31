package control.Accessories;

import control.BattleClasses.Map;
import model.Zombie;

public abstract class Accessory {
    Zombie zombie;
    public void doAction( Map map){
        if (zombie.getLocation().getPlant() != null){
            zombie.getLocation().getPlant().decreaseHealth(zombie.getDamage());
            map.checkDies();
            zombie.getLocation().getPlant().defend(zombie);
        }
    }
    public void move(Map map){

    }
    public Accessory(Zombie zombie){
        this.zombie = zombie;
    }
}
