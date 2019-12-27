package model;


import control.Accessories.Car;
import control.Menu;
import control.PlayMenu;
import view.CardView;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection {
    private Account owner;
    private ArrayList<Zombie> zombies = new ArrayList<>();
    private ArrayList<Plant> plants = new ArrayList<>();
    public ArrayList<Zombie> getZombies(){
        return zombies;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }


    public Plant getPlantByName(String name){
        for (Plant plant :
                plants) {
            if (plant.getName().equals(name)) {
                return plant;
            }
            }
        return null;
    }
    public Zombie getZombieByName(String name){
        for (Zombie zombie :
                zombies) {
            if (zombie.getName().equals(name)){
                return zombie;
            }
        }
        return null;
    }
}
