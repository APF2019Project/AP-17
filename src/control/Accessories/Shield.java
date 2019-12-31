package control.Accessories;

import model.Zombie;

public class Shield extends Accessory {

    public Shield(Zombie zombie, int health) {
        super(zombie);
        this.health = health;
    }
    private int health;

    @Override
    public Accessory clone(Zombie zombie) {
        return null;
    }
}
