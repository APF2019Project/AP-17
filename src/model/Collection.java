package model;


import control.Menu;
import view.CardView;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection {
    private Account owner;
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return cards;
    }
    public boolean hasCard(String name) {
        return true ;
    }
    public void handleCommand (String command , Scanner scanner) {
        if (command.equals("show hand")) {
            for (Card card : this.owner.getHandCards()) {
                CardView.showName(card);
            }
        }
        else if (command.equals("show collection")) {
            for (Card card : this.owner.getCollection().getCards()) {
                if (!this.owner.getHandCards().contains(card)) {
                    CardView.showName(card);
                }
            }
        }
        else if (command.matches("select \\w+")) {
            String[] commandSplit = command.split(" ") ;
            String cardName = commandSplit[1] ;
            if (CardView.checkCard(cardName , this.owner.getCollection().getCards()) != null) {
                Card card = CardView.checkCard(cardName , this.owner.getCollection().getCards()) ;
                this.owner.getHandCards().add(card);
                this.owner.getCollection().getCards().remove(card) ;
            }
        }
        else if (command.matches("remove \\w+")) {
            String[] commandSplit = command.split(" ") ;
            String cardName = commandSplit[1] ;
            if (CardView.checkCard(cardName , this.owner.getHandCards()) != null) {
                Card card = CardView.checkCard(cardName , this.owner.getHandCards()) ;
                this.owner.getHandCards().remove(card);
                this.owner.getCollection().getCards().add(card) ;
            }
        }
        else if (command.equals("play")) {
            Menu.currentMenu = playMenu ;
        }
    }
}
