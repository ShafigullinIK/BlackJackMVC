package controller;

import model.BJGame;
import model.Card;
import model.Player;
import view.ConsoleView;

public class CardController {

    BJGame game;
    ConsoleView consoleView;

    public CardController(BJGame game, ConsoleView consoleView) {
        this.consoleView = consoleView;
        this.game = game;
    }

    public void takeCard(Player player, int amount){
        for (int i = 0; i < amount; i++) {
            Card newCard = game.getOneCard();
            player.addCard(newCard);
            consoleView.printPlayerAndCard(player,newCard);
        }
    }

    public void deletePlayerDeck(Player player){
        Card[] emptyDeck = new Card[9];
        player.setPlayerDeck(emptyDeck);
    }
}
