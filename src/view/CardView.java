package view;

import model.Account;
import model.Card;

import java.util.ArrayList;

public class CardView {
    public static void showNameAndPrice(Card card){
        System.out.println(card.getName() + " " + card.getPrice());
    }
    public static void showName(Card card){
        System.out.println(card.getName());
    }
    public static Card checkCard (String name , ArrayList<Card> cards) {
        for (Card card : cards) {
            if (card.getName().equals(name)) return card ;
        }
        return null ;
    }
    public static void cardDoesntExistsError(){
        System.out.println("Error: card doesn't exists!");
    }
}
