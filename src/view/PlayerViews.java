package view;

import model.Card;
import model.Hand;
import model.Plant;
import model.PlayerTypes.Player;

import java.util.ArrayList;

public class PlayerViews {
    public static void showHandForPlants(Player player){
        Hand hand = player.getHand();
        ArrayList<Card> cards = hand.getCards();
        for (Card card :
                cards) {
            Plant plant = (Plant) card;
            System.out.println(plant.getName() + " Suns needed: " + plant.getSunsNeeded() +
                    " Cooldown remained: " + plant.getRemainedCooldown());
        }
    }
}
