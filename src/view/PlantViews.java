package view;


import model.Plant;

public class PlantViews {
    public static void showPlantNameWithoutNextLine(Plant plant){
        System.out.print(plant.getName());
    }

    public static void showPlantNameAndPrice(Plant plant){
        System.out.println(plant.getName() + " " + plant.getPrice());
    }
}
