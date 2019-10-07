import controller.*;
import model.*;
import view.ConsoleView;


public class Main {

    public static void main(String[] args) {
        Player pl1 = new Player("Vasya", 50, 9); // создаём первого игрока
        Player pl2 = new Player("Petya", 10, 9); // создаём второго игрока
        BJGame game = new BJGame(pl1, pl2); // создаём игру для этих 2 игроков.
        CashController cashController = new CashController(); // создаём контроллер для денег этих игроков
        ConsoleView consoleView = new ConsoleView(); // создаём объект для вывода информации на консоль
        CardController cardController = new CardController(game, consoleView); // создаём контроллер карт. Ему передаём игру (доступ к колоде) и передаём ConsoleView чтобы была возможность выводить информацию на экран
        BJCardValueController bjCardValueController = new BJCardValueController();  // создаём контроллер для возможности считать "цену" карт в руках игроков

        PlayerController playerController = new PlayerController(pl1, consoleView, bjCardValueController); // создаём контроллер для первого игрока, консольвью для вывода информации и считалку стоимости карт.
        CompController compController = new CompController(pl2, bjCardValueController); // контроллер для второго игрока. тут нет вывода вопросов на экран.
        RoundController roundController = new RoundController(cashController, cardController,bjCardValueController, consoleView, game, playerController, compController); // основной на данный момент контроллер, который контролирует игру в рамках одного раунда
        roundController.startNewRound(); // начало нового раунда игры.
    }
}
