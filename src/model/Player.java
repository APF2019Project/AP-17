package model;

public class Player {
    private Account account;
    private int suns;
    private Hand hand;
    public Player(Account account, int suns){
        this.account = account;
        this.suns = suns;
        hand = new Hand();
    }
}
