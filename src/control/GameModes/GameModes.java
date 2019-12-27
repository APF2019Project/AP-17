package control.GameModes;

import control.Menu;
import control.ShowGameResultMenu;

public abstract class GameModes extends Menu {
    void generateMap(){

    };
    void checkState(){

    };
    void handleWin(){

    };
    void getHand(){

    };
    protected GameModes(){
        super(ShowGameResultMenu.showGameResultMenu);
    }
}
