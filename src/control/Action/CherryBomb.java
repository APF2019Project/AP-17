package control.Action;

import control.BattleClasses.Cell;
import model.Plant;

public class CherryBomb extends Action{


    @Override
    protected void shoot() {
        if (hasZombieInFront()){
            Cell cell = plant.getLocation();
            cell.getZombies().clear();
            try {
                cell = plant.getMap().getCells()[plant.getLocation().getX() - 1][plant.getLocation().getY()][0];
                cell.getZombies().clear();
            } catch (Exception e){

            }
            try {
                cell = plant.getMap().getCells()[plant.getLocation().getX() + 1][plant.getLocation().getY()][0];
                cell.getZombies().clear();
            } catch (Exception e){

            }
            try {
                cell = plant.getMap().getCells()[plant.getLocation().getX()][plant.getLocation().getY() - 1][0];
                cell.getZombies().clear();
            } catch (Exception e){

            }
            try {
                cell = plant.getMap().getCells()[plant.getLocation().getX()][plant.getLocation().getY() + 1][0];
                cell.getZombies().clear();
            } catch (Exception e){

            }
            try {
                cell = plant.getMap().getCells()[plant.getLocation().getX() - 1][plant.getLocation().getY() - 1][0];
                cell.getZombies().clear();
            } catch (Exception e){

            }
            try {
                cell = plant.getMap().getCells()[plant.getLocation().getX() - 1][plant.getLocation().getY() + 1][0];
                cell.getZombies().clear();
            } catch (Exception e){

            }
            try {
                cell = plant.getMap().getCells()[plant.getLocation().getX() + 1][plant.getLocation().getY() - 1][0];
                cell.getZombies().clear();
            } catch (Exception e){

            }
            try {
                cell = plant.getMap().getCells()[plant.getLocation().getX() + 1][plant.getLocation().getY() + 1][0];
                cell.getZombies().clear();
            } catch (Exception e){

            }

        }
    }

    @Override
    protected boolean hasZombieInFront() {
        return true;
    }
    public CherryBomb(Plant plant) {
        super(plant);
    }

}
