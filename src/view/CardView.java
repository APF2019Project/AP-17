package view;

import model.Account;
import model.Card;

public class CardView {
    public static void showNameAndPrice(Card card){
        System.out.println(card.getName() + " " + card.getPrice());
    }
}
