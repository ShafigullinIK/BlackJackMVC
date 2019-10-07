package controller;

import model.Player;

public class CompController {
    private Player player;
    private BJCardValueController bjCardValueController;

    public CompController(Player player, BJCardValueController bjCardValueController) {
        this.player = player;
        this.bjCardValueController = bjCardValueController;
    }

    public boolean needMore(){
        if(bjCardValueController.valueOfDeck(player.getPlayerDeck()) >= 17){
            return false;
        } else { return true;}

    }
}
