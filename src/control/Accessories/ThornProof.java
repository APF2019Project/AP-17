package control.Accessories;

public class ThornProof extends Accessory {
    public void doAction(Zombie zombie, Map map) {
        if (zombie.getLocation().getPlant() != null){
            zombie.getLocation().getPlant().decreaseHealth(zombie.getDamage());
            map.checkDies();
        }
    }
}
