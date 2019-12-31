package control.GameModes;

import control.Accessories.Car;
import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import model.Card;
import model.Hand;
import model.Plant;
import model.PlayerTypes.Player;
import view.BattleViews;
import view.PlayerViews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class Day extends GameModes {
    private static final int WAVE_NUMBERS = 3;
    private int wavesCame = 0;
    private int ranodmNumberToIncreaseSuns;
    private int increaseSunNumbers;
    private int nextWave = 3;
    private int randomZombieNumbersForEachWave;
    public Plant selectedPlant;

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)) {
            if (command.equals("show lawn")) {
                BattleViews.showLawn(map);
            }
        } else if (command.equals("show hand")){
            PlayerViews.showHandForPlants(planter);
        } else if (command.matches("select \\d+")){
            String[] commandSplit = command.split(" ");
            String name = commandSplit[1];
            selectedPlant = select(name);
            if (selectedPlant == null){
                BattleViews.plantDoesntExistsError();
            }
        } else if (command.matches("plant \\d+, \\d+")){
            String[] commandSplit = command.split(" ");
            int row = Integer.parseInt(commandSplit[1].substring(0, commandSplit.length - 1));
            int column = Integer.parseInt(commandSplit[2]);
            selectedPlant.getSpecialTalent().plant(row, column, map, this);
        } else if (command.matches("remove \\d+, \\d+")){
            String[] commandSplit = command.split(" ");
            int row = Integer.parseInt(commandSplit[1].substring(0, commandSplit.length - 1));
            int column = Integer.parseInt(commandSplit[2]);
            remove(row, column);
        }
    }


    @Override
    public void handleWin() {

    }

    @Override
    public void preProcess() {
        setRandomNumbers();
        randomZombieNumbersForEachWave = ((int) Math.random()) % 7 + 4;
    }

    private void setRandomNumbers(){
        increaseSunNumbers = ((int) Math.random()) % 4 + 2;
        ranodmNumberToIncreaseSuns = ((int) Math.random()) % 2;
    }


    @Override
    protected boolean allowsCommand(String command) {
        return true;
    }

    public Day(Player planter, Player zombieLeader, Map map) {
        super(planter, zombieLeader, map);
        preProcess();
    }

    private void selectWave(){

    }

    private Plant select(String name){
        Hand hand = planter.getHand();
        Plant plant = (Plant) hand.getCardByName(name);
        return (Plant) plant.clone();
    }
    private void remove(int row, int column){
        Cell cell = map.getCells()[row][column][0];
        if (cell.getPlant() == null){
            BattleViews.cellIsEmpptyError();
            return;
        }
        cell.setPlant(null);
    }


}
