package controller;

import model.Card;

public class BJCardValueController {

    private int valueToInt(Card card){
        switch (card.getValue()){
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            default: return 0;
        }
    }

    public int valueOfDeck(Card[] deck){
        int sum = 0;
        for (int i = 0; i < deck.length; i++) {
            sum += valueToInt(deck[i]);
        }
        return sum;
    }
}
