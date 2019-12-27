package model;

public abstract class Player {
    private Account account;
    private int suns;
    private Hand hand;

    public Hand getHand(){
        return hand;
    }
    public Player(Account account){
        this.account = account;
        hand = new Hand();
    }
}
