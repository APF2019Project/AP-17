package control.GameModes;

import control.BattleClasses.Map;
import control.Menu;
import control.ShowGameResultMenu;
import model.Player;

public abstract class GameModes extends Menu {
    protected Player planter;
    protected Player zombiesLeader;
    protected int turn = 0;
    protected Map map;
    protected boolean hasEnded = false;

    void generateMap() {

    }

    ;

    void checkState() {

    }

    ;

    void handleWin() {

    }

    ;

    void getHand() {

    }

    ;

    protected GameModes(Player planter, Player zombiesLeader, Map map) {
        super(ShowGameResultMenu.showGameResultMenu);
        this.planter = planter;
        this.zombiesLeader = zombiesLeader;
        this.map = map;
    }
}
