package control.Accessories;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import control.GameModes.GameMode;
import model.Zombie;

public class Accessory {
    Zombie zombie;
    boolean attacked = false;
    public void doAction(Map map, GameMode gameMode){
        attack(map);
        move(map, gameMode);
    }

    private void attack(Map map){
        if (!attacked) {
            if (nextCell(map).getPlant() != null) {
                nextCell(map).getPlant().decreaseHealth(zombie.getDamage());
                map.checkDies();
                if (nextCell(map).getPlant() != null) {
                    nextCell(map).getPlant().defend(zombie);
                }
                map.checkDies();
                attacked = true;
                return;
            }
        }
    }

    public void move(Map map, GameMode gameMode){
        if (zombie.getMoves() < zombie.getSpeed() && nextCell(map).getPlant() == null) {
            if (zombie.getLocation().getY() == 0) {
                gameMode.hasEnded();
                return;
            }
            zombie.getLocation().getZombies().remove(zombie);
            zombie.setLocation(nextCell(map));
            zombie.increaseMoves();
        }
    }

    public Cell nextCell(Map map){
        int x = zombie.getLocation().getX();
        int y = zombie.getLocation().getY();
        return map.getCells()[x][y - 1][0];
    }

    public void put(Map map, int row, int column){
        Cell cell = map.getCells()[row][column][0];
        cell.getZombies().add(zombie);
    }
    public Accessory(Zombie zombie){
        this.zombie = zombie;
    }

    public  Accessory clone(Zombie zombie){
        return null;
    }
}
