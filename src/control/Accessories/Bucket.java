package control.Accessories;

import model.Zombie;

public class Bucket extends Accessory {
    public Bucket(Zombie zombie) {
        super(zombie);
    }

    @Override
    public Accessory clone(Zombie zombie) {
        return null;
    }
}
