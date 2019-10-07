package model;

import java.util.Random;

public class BJGame {


    private String gameName = "BlackJack";
    private Player pl1;
    private Player pl2;
    private Card[] deck;
    private int deckPoint;

    public BJGame(Player pl1, Player pl2) {
        this.pl1 = pl1;
        this.pl2 = pl2;
        initDeck();
        shuffleDeck();
    }

    public void initDeck() {
        deck = new Card[Suit.values().length*
                Value.values().length];
        int index = 0;
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                deck[index] = new Card(s, v);
                index++;
            }
        }
    }

    public void showDeck(){
        for (Card c : deck) {
            System.out.println(c);
        }
    }

    public void shuffleDeck(){
        deckPoint = 0;
        Random r = new Random();
        for (int j = 0; j < r.nextInt(100) + 10; j++) {
            for (int i = 0; i < deck.length; i++){
                int pairIndex = r.nextInt(deck.length);
                Card temp = deck[i];
                deck[i] = deck[pairIndex];
                deck[pairIndex] = temp;
            }
        }

    }

    public Card getOneCard(){
        Card result = deck[deckPoint];
        deckPoint++;
        return result;
    }

    public Player getPlayer(int index){
        if(index == 1) return pl1;
        return pl2;
    }
}
