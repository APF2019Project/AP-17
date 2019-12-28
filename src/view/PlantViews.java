package view;


import model.Plant;

public class PlantViews {
    public static void showPlantNameWithoutNextLine(Plant plant){
        System.out.print(plant.getName());
    }
}
