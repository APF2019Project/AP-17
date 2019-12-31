package control.Accessories;

import control.BattleClasses.Map;
import model.Zombie;

public class ThornProof extends Accessory {
//    @Override
    public void doAction(Map map) {
        if (zombie.getLocation().getPlant() != null){
            zombie.getLocation().getPlant().decreaseHealth(zombie.getDamage());
            map.checkDies();
        }
    }

    public ThornProof(Zombie zombie){
        super(zombie);
    }

    @Override
    public Accessory clone(Zombie zombie) {
        return null;
    }
}
