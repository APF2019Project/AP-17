package control.GameModes;

import control.BattleClasses.Map;
import control.Menu;
import control.ShowGameResultMenu;
import model.PlayerTypes.Player;
import model.Projectile;

import java.util.ArrayList;

public abstract class GameMode extends Menu {
    protected Player planter;
    protected Player zombiesLeader;
    protected int turn = 0;
    protected Map map;
    protected boolean hasEnded = false;

    public abstract void handleWin();

    public abstract void preProcess();

    private Player whoseTurn(){
        if (turn % 2 == 0){
            return planter;
        }
        return zombiesLeader;
    }

    protected GameMode(Player planter, Player zombiesLeader, Map map) {
        super(ShowGameResultMenu.showGameResultMenu);
        this.planter = planter;
        this.zombiesLeader = zombiesLeader;
        this.map = map;
    }

    public void hasEnded(){
        hasEnded = true;
    }
}
