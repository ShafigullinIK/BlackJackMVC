package controller;

import model.Player;
import view.ConsoleView;

public class PlayerController {

    Player player;
    BJCardValueController bjCardValueController;
    ConsoleView consoleView;

    public PlayerController(Player player, ConsoleView consoleView, BJCardValueController bjCardValueController) {
        this.player = player;
        this.consoleView = consoleView;
        this.bjCardValueController = bjCardValueController;
    }

    public boolean needMore(){
        if(bjCardValueController.valueOfDeck(player.getPlayerDeck()) >= 20){
            return false;
        }
        return consoleView.needMore(player);
    }
}
