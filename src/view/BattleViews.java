package view;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Zombie;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BattleViews {
    public static void showLawn(Map map){
        Cell[][] cells = map.getCells();
        for (int i = 0; i < Map.getHeight(); i++) {
            for (int j = 0; j < Map.getWidth(); j++) {
                Cell cell = cells[i][j];
                boolean empty = true;
                if (cell.getPlant() != null){
                    empty = false;
                    PlantViews.showPlantNameWithoutNextLine(cell.getPlant());
                }
                ArrayList<Zombie> zombies = cell.getZombies();
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
}
