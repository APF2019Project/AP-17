package control.Accessories;

import model.Zombie;

public class Jumper extends Accessory {
    public Jumper(Zombie zombie) {
        super(zombie);
    }

    @Override
    public Accessory clone(Zombie zombie) {
        return null;
    }
}
