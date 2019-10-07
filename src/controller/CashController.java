package controller;

import model.Player;

public class CashController {

    public boolean changeCash(Player player, int bet){
        return player.changeCash(bet);
    }
}
