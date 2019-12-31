package control.BattleClasses;

import control.GameModes.GameMode;
import model.Plant;
import model.Projectile;
import model.Zombie;

import java.util.ArrayList;

public class Map {
    private static final int HEIGHT = 6;
    private static final int WIDTH = 19;
    private Cell[][][] cells = new Cell[HEIGHT][WIDTH][2];

    public Map(String type){
        if (type.equals("day")){
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    cells[i][j][0] = new Cell(i, j, true);
                    cells[i][j][1] = new Cell(i, j, true);
                }
            }
        }
    }
    public void checkDies(){

    }
    public void shootPlants(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell cell = cells[i][j][0];
                Plant plant = cell.getPlant();
                if (plant.getLastShot() == 0) {
                    for (int k = 0; k < plant.getShotsPerTurn(); k++) {
                        plant.getSpecialTalent().shoot();
                    }
                    plant.resetLastShot();
                } else {
                    plant.decreaseLastShot();
                }
            }
        }
    }

    public boolean areAllZombiesMovedInTurn(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell cell = cells[i][j][0];
                for (int k = 0; k < cell.getZombies().size(); k++) {
                    Zombie zombie = cell.getZombies().get(k);
                    if (!zombie.movedInTurn()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean areAllProjectilesMovedInTurn(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell cell = cells[i][j][0];
                for (int k = 0; k < cell.getProjectiles().size(); k++) {
                    Projectile projectile = cell.getProjectiles().get(k);
                    if (!projectile.movedInTurn()){
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }
    public boolean areAllZombiesDead(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell cell = cells[i][j][0];
                if (cell.getZombies().size() != 0){
                    return false;
                }
                cell = cells[i][j][1];
                if (cell.getZombies().size() != 0){
                    return false;
                }
            }
        }
        return true;
    }
    public void moveAllProjectiles(){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell cell = cells[i][j][0];
                for (int k = 0; k < cell.getProjectiles().size(); k++) {
                    Projectile projectile = cell.getProjectiles().get(k);
                    projectile.doAction(this);
                }
            }
        }
    }
    public void doActionZombies(GameMode gameMode){
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                Cell cell = cells[i][j][0];
                for (int k = 0; k < cell.getZombies().size(); k++) {
                    Zombie zombie = cell.getZombies().get(k);
                    zombie.getAccessory().doAction(this, gameMode);
                }
                cell = cells[i][j][1];
                for (int k = 0; k < cell.getZombies().size(); k++) {
                    Zombie zombie = cell.getZombies().get(k);
                    zombie.getAccessory().doAction(this, gameMode);
                }
            }
        }
    }

    public Cell[][][] getCells() {
        return cells;
    }
    public static int getHeight(){
        return HEIGHT;
    }
    public static int getWidth(){
        return WIDTH;
    }
}
