package view;

import model.Card;
import model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView {

    public boolean needMore(Player player){
        System.out.println(player.getName() + ", " +
                "do you need more card?");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String s = "";
        try{
            s = reader.readLine();
            if("y".equals(s)) return true;
        }catch (IOException e){

        }
        return false;
    }

    public void printPlayerAndCard(Player player, Card card){
        System.out.println(player.getName() + " --> "
         + card);
    }

    public void draw(int v1, int v2){
        System.out.println("draw (" + v1 + " | " + v2 + ")" );
    }

    public void firstWin(int v1, int v2){
        System.out.println("firstWin (" + v1 + " | " + v2 + ")");
    }

    public void secondWin(int v1, int v2){
        System.out.println("secondWin (" + v1 + " | " + v2 + ")");
    }

}
