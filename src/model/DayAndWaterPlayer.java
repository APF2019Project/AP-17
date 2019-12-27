package model;

public class DayAndWaterPlayer extends Player {
    private int suns;
    public DayAndWaterPlayer(Account account, int suns){
        super(account);
        this.suns = suns;
    }
}
