package model;


import java.util.ArrayList;

public class Collection {
    private Account owner;
    private ArrayList<Card> cards = new ArrayList<>();
    

    public ArrayList<Card> getCards() {
        return cards;
    }
    public boolean hasCard(String name) {
        return true ;
    }
}
