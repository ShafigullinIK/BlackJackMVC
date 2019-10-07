package controller;

import model.BJGame;
import model.Card;
import model.Player;
import view.ConsoleView;

public class RoundController {

    private CashController cashController;  // В данной версии программы он не исользуется, нужен для того, чтобы поменять количество денег у пользователя.
    private CardController cardController;  // С помощью него мы из колоды достаем карты и передаём их игрокам. Также, можем обнулять колоды игроков
    private PlayerController playerController; // С помощью него мы взаимодействуем с игроком и узнаем нужны ли ему ещё карты.
    private CompController compController; // Аналогично игроку, но нет выхода на консоль, вопрос решается алгоритмом.
    private BJCardValueController bjCardValueController; //Считает стоимость наших карт в колоде игрока.
    private ConsoleView consoleView; // Вывод на консоль любой требуемой информации.
    private BJGame game;
    private Player pl1;  // доступ к первому игроку
    private Player pl2; // доступ ко второму игроку.

    public RoundController(CashController cashController, // передаём ссылки на все требуемые нам объекты в конструкторе класса
                           CardController cardController,
                           BJCardValueController bjCardValueController,
                           ConsoleView consoleView,
                           BJGame game,
                           PlayerController playerController,
                           CompController compController) {
        this.cashController = cashController;
        this.cardController = cardController;
        this.playerController = playerController;
        this.compController = compController;
        this.bjCardValueController = bjCardValueController;
        this.game = game;
        this.consoleView = consoleView;
        pl1 = game.getPlayer(1);
        pl2 = game.getPlayer(2);
    }

    public void startNewRound() {       // начало нового раунда игры.
        cardController.deletePlayerDeck(pl1); // обнуляем колоду первого игрока
        cardController.deletePlayerDeck(pl2); // обнуляем колоду второго игрока
        cardController.takeCard(pl1, 2); // берём первым игроком 2 карты
        cardController.takeCard(pl2, 2); // берём вторым игроком 2 карты
        while (playerController.needMore()) { // в цикле, пока первый игрок говорит что ему нужны карты, то берём по 1 карте
            cardController.takeCard(pl1, 1);
        }
        while (compController.needMore()) {   // аналогично для второго игрока
            cardController.takeCard(pl2, 1);
        }
        int pl1Value = bjCardValueController.valueOfDeck(pl1.getPlayerDeck()); // посчитали сумму очков первого игрока
        int pl2Value = bjCardValueController.valueOfDeck(pl2.getPlayerDeck()); // посчитали сумму очков второго игрока
        if (pl1Value > 21 && pl2Value > 21) { // подведение итогов
            draw(pl1Value, pl2Value);
        } else {
            if (pl1Value > 21) {
                consoleView.secondWin(pl1Value, pl2Value);
            } else {
                if(pl2Value > 21) {
                    consoleView.firstWin(pl1Value, pl2Value);
                }else{
                    if(pl1Value == pl2Value) {
                        draw(pl1Value, pl2Value);
                    } else {
                        if(pl1Value > pl2Value) {
                            consoleView.firstWin(pl1Value, pl2Value);
                        } else {
                            consoleView.secondWin(pl1Value, pl2Value);
                        }
                    }
                }
            }
        }
    }

    public void draw(int pl1V, int pl2V) {
        consoleView.draw(pl1V, pl2V);
    }


    public void demo() {   // временный метод, нужен был просто чтобы на паре демонстрировать промежуточные результаты. его можно удалить, в контроллерах не должно быть ничего, что печатает на консоль.
        for (Card card :
                pl1.getPlayerDeck()) {
            System.out.println(card);
        }
        System.out.println("===================");
        for (Card card :
                pl2.getPlayerDeck()) {
            System.out.println(card);
        }


    }
}
