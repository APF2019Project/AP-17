package control.Accessories;

import model.Zombie;

public class Football extends Accessory {


    public Football(Zombie zombie) {
        super(zombie);
    }

    @Override
    public Accessory clone(Zombie zombie) {
        return null;
    }
}
