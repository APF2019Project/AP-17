package control;

import model.Card;
import model.Plant;
import model.Zombie;
import view.AccountViews;
import view.CardView;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop extends Menu {
    public static Shop shop = new Shop();
    private static ArrayList<Zombie> zombies = new ArrayList<>() ;
    private static ArrayList<Plant> plants = new ArrayList<>();

    public void handleCommand(String command, Scanner scanner){
//        if (command.equals("show shop")) {
//            for (Card card: cards) {
//                if (! this.account.getCollection().hasCard(card.getName())) {
//                    CardView.showNameAndPrice(card);
//                }
//            }
//        }
//        else if (command.equals("money")) {
//            AccountViews.showMoney(this.account);
//        }
//        else if (command.matches("buy \\w+")) {
//            String[] commandSplit = command.split(" ") ;
//            String name = commandSplit[1] ;
//            if (checkCard(name) != null) {
//                Card card = checkCard(name) ;
//                if(this.account.getShopCoins() >= card.getPrice()) {
//                    this.account.getCollection().getCards().add(card);
//                }
//            }
//        }
//        else if (command.equals("show collection")) {
//            for(Card card : this.account.getCollection().getCards()) {
//                CardView.showName(card);
//            }
//        }
    }

    public boolean allowsCommand(String command){
      return true ;
    }
    public void showMenu() {

    }
    public void help(){

    }
    public static ArrayList<Zombie> getZombies(){
        return zombies;
    }


    private Shop(){
        super(MainMenu.mainMenu);
    }

}
