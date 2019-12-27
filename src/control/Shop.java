package control;

import model.Card;
import view.AccountViews;
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
        else if (command.equals("money")) {
            AccountViews.showMoney(this.account);
        }
        else if (command.matches("buy \\w+")) {
            String[] commandSplit = command.split(" ") ;
            String name = commandSplit[1] ;

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
