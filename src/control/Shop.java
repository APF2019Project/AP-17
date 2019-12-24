package control;

import model.Card;
import view.CardView;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop extends Menu {

    private static ArrayList<Card> cards = new ArrayList<Card>() ;

    public void handleCommand(String command, Scanner scanner){
        if (command.equals("show shop")) {
            for (Card card: cards) {
                if (! this.account.getCollection().hasCard(card.getName())) {
                    CardView.showNameAndPrice(card);
                }
            }
        }
    }
    public void exit(){

    }
    public void enterMenu(String menu) {

    }
    public boolean allowsCommand(String command){
      return true ;
    }
    public void showMenu() {

    }
    public void help(){

    }


}
