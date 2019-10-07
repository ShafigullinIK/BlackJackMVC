package model;

public class Player {

    private String name;
    private int cash;
    private Card[] playerDeck;

    public Player(String name, int cash, int maxCards){
        this.name = name;
        this.cash = cash;
        playerDeck = new Card[maxCards];
    }

    public void setPlayerDeck(Card[] deck){
        playerDeck = deck;
    }

    public boolean changeCash(int bet){
        cash += bet;
        if(cash > 0){
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + "| cash = " + cash;
    }

    public void addCard(Card card){
        for (int i = 0; i < playerDeck.length; i++) {
            if(playerDeck[i] == null){
                playerDeck[i] = card;
                return;
            }
        }
    }

    public Card[] getPlayerDeck(){
        int index = 0;
        for (int i = 0; i < playerDeck.length; i++) {
            if(playerDeck[i] == null){
                index = i;
                break;
            }
        }
        Card[] result = new Card[index];
        for (int i = 0; i < index; i++) {
            result[i] = playerDeck[i];
        }
        return result;
    }



}
