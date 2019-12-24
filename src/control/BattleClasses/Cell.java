package control.BattleClasses;

import model.Card;
import model.Plant;

import java.util.ArrayList;
import java.util.Calendar;

public class Cell {
    protected int x;
    protected int y;
    protected boolean land;
    protected ArrayList<Card> cards = new ArrayList<>();
    protected Plant plant;
}
