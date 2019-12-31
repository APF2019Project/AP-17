package control.Accessories;

import model.Zombie;

public class WeakCar extends Car {
    public WeakCar(Zombie zombie) {
        super(zombie);
    }

    @Override
    public Accessory clone(Zombie zombie) {
        return null;
    }
}
