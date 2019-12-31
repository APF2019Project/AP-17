package view;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Zombie;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BattleViews {
    public static void showLawn(Map map){
        Cell[][][] cells = map.getCells();
        for (int i = 0; i < Map.getHeight(); i++) {
            for (int j = 0; j < Map.getWidth(); j++) {
                Cell[] cell = cells[i][j];
                boolean empty = true;
                if (cell[0].getPlant() != null){
                    empty = false;
                    PlantViews.showPlantNameWithoutNextLine(cell[0].getPlant());
                }
                if (cell[1].getPlant() != null){
                    empty = false;
                    PlantViews.showPlantNameWithoutNextLine(cell[1].getPlant());
                }
                ArrayList<Zombie> zombies = cell[0].getZombies();
                for (Zombie zombie :
                        zombies) {
                    empty = false;
                    CardView.showName(zombie);
                }
                zombies = cell[1].getZombies();
                for (Zombie zombie :
                        zombies) {
                    empty = false;
                    CardView.showName(zombie);
                }
                if (empty){
                    System.out.print("_");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static void plantDoesntExistsError(){
        System.out.println("Error: Plant doesn't exists!");
    }

    public static void invalidRowNumberError(){
        System.out.println("Error: invalid row number!");
    }

    public static void invalidColumnNumberError(){
        System.out.println("Error: invalid column number!");
    }

    public static void WaterLandError(){
        System.out.println("Water & Land Error: this can't be placed in this cell!");
    }

    public static void cellIsFullError(){
        System.out.println("Error: cell is full!");
    }

    public static void cellIsEmpptyError(){
        System.out.println("Error: cell is empty");
    }

    public static void notEnoughSunsError(){
        System.out.println("Error: not enough suns!");
    }

    public static void cooldownRemainedError(){
        System.out.println("Error: cooldown Remained");
    }
}
