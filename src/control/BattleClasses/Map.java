package control.BattleClasses;

import model.Projectile;

import java.util.ArrayList;

public class Map {
    private static ArrayList<Map> maps = new ArrayList<>();
    private static final int HEIGHT = 6;
    private static final int WIDTH = 19;
    private Cell[][][] cells = new Cell[HEIGHT][WIDTH][2];
    private ArrayList<Projectile> projectiles = new ArrayList<>();

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

    public Cell[][][] getCells() {
        return cells;
    }
    public static int getHeight(){
        return HEIGHT;
    }
    public static int getWidth(){
        return WIDTH;
    }

    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
}
