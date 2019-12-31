package control.GameModes;

import control.BattleClasses.Cell;
import control.BattleClasses.Map;
import control.Shop;
import model.Hand;
import model.Plant;
import model.PlayerTypes.Player;
import model.Projectile;
import model.Zombie;
import view.BattleViews;
import view.PlayerViews;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class Day extends GameMode {
    private static final int WAVE_NUMBERS = 3;
    private int wavesCame = 0;
    private int ranodmNumberToIncreaseSuns;
    private int increaseSunNumbers;
    private int nextWave = 3;
    private int randomZombiesNumberForEachWave;
    public Plant selectedPlant;

    @Override
    public void handleCommand(String command, Scanner scanner) throws IOException {
        if (allowsCommand(command)) {
            if (command.equals("show lawn")) {
                BattleViews.showLawn(map);
            }
        } else if (command.equals("show hand")) {
            PlayerViews.showHandForPlants(planter);
        } else if (command.matches("select \\d+")) {
            String[] commandSplit = command.split(" ");
            String name = commandSplit[1];
            selectedPlant = select(name);
        } else if (command.matches("plant \\d+, \\d+")) {
            String[] commandSplit = command.split(" ");
            int row = Integer.parseInt(commandSplit[1].substring(0, commandSplit.length - 1));
            int column = Integer.parseInt(commandSplit[2]);
            selectedPlant.getSpecialTalent().plant(row, column, map, this);
        } else if (command.matches("remove \\d+, \\d+")) {
            String[] commandSplit = command.split(" ");
            int row = Integer.parseInt(commandSplit[1].substring(0, commandSplit.length - 1));
            int column = Integer.parseInt(commandSplit[2]);
            remove(row, column);
        } else if (command.equals("end turn")) {
            if (turn == nextWave) {
                makeWave();
            }
            map.shootPlants();
            while (!map.areAllZombiesMovedInTurn() || !map.areAllProjectilesMovedInTurn()) {
                map.doActionZombies(this);
                map.moveAllProjectiles();
            }
            if (map.areAllZombiesDead()){
                nextWave = turn + 7;
            }
        }
    }


    @Override
    public void handleWin() {

    }

    @Override
    public void preProcess() {
        setRandomNumbers();
    }

    private void setRandomNumbers() {
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

    private Plant select(String name) {
        Hand hand = planter.getHand();
        Plant plant = (Plant) hand.getCardByName(name);
        if (plant == null) {
            BattleViews.plantDoesntExistsError();
            return null;
        }
        if (plant.getSunsNeeded() > planter.getSuns()){
            BattleViews.notEnoughSunsError();
            return null;
        }
        if (plant.getRemainedCooldown() != 0){
            BattleViews.cooldownRemainedError();
            return null;
        }
        return (Plant) plant.clone();
    }

    private void remove(int row, int column) {
        Cell cell = map.getCells()[row][column][0];
        if (cell.getPlant() == null) {
            BattleViews.cellIsEmpptyError();
            return;
        }
        cell.setPlant(null);
    }

    private void makeWave() {
        randomZombiesNumberForEachWave = ((int) Math.random()) % 7 + 4;
        ArrayList<Zombie> zombies = Shop.getZombies();
        ArrayList<Zombie> waveZombies = new ArrayList<>();
        for (int i = 0; i < randomZombiesNumberForEachWave; i++) {
            while (true) {
                int randomNumber = ((int) Math.random()) % zombies.size();
                if (!zombies.get(randomNumber).isWater()) {
                    waveZombies.add(zombies.get(randomNumber).clone());
                    break;
                }
            }
        }
        for (int i = 0; i < waveZombies.size(); i++) {
            int randomNumberForSelectingRow = ((int) Math.random()) % Map.getHeight();
            waveZombies.get(i).getAccessory().put(map, randomNumberForSelectingRow, Map.getWidth() - 1);
        }
    }

}
