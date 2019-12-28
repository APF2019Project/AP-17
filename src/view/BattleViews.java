package view;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;

public class BattleViews {
    public static void showLawn(Map map){
        Cell[][] cells = map.getCells();
        for (int i = 0; i < Map.getHeight(); i++) {
            for (int j = 0; j < Map.getWidth(); j++) {
                Cell cell = cells[i][j];
                if (cell.getPlant() != null){
                    System.out.println(cell.ge);
                }
            }
            System.out.println();
        }
    }
}
