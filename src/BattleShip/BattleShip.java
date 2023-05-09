package BattleShip;
import Controller.GameController;
import View.GameView;
import View.GameViewImp;

import java.util.Scanner;


public class BattleShip {
    public static void main(String[] args) throws InterruptedException{

        Scanner scanner = new Scanner(System.in);

        GameView gameView = new GameViewImp();

        gameView.printWelcomeMessage();
        gameView.enterYourNameMessage();
        String name = scanner.nextLine();

        GameController gameController = new GameController(name);

        gameController.initializeGame();
        gameController.playGame();

        
    }
}

