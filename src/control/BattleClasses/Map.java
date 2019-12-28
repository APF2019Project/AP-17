package control.BattleClasses;

import java.util.ArrayList;

public class Map {
    private static ArrayList<Map> maps = new ArrayList<>();
    private static final int HEIGHT = 6;
    private static final int WIDTH = 19;
    private Cell[][] cell = new Cell[HEIGHT][WIDTH];

    public Map(String type){
        if (type.equals("day")){
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    cell[i][j] = new Cell(i, j, true);
                }
            }
        }
    }
}
