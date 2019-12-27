package model;

import control.Accessories.Car;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards(){
        return cards;
    }

    public Card getCardByName(String name){
        for (Card card :
                cards) {
            if (card.getName().equals(name)) {
                return card;
            }
            }
        return null;
    }
    public boolean hasCard(Card card){
        for (Card cardInHand :
                cards) {
            if (cardInHand.getName().equals(card.getName())){
                return true;
            }
        }
        return false;
    }
    public boolean hasCard(String name){
        for (Card card :
                cards) {
            if (card.getName().equals(name)) {
                return true;
            }
            }
        return false;
    }
}
