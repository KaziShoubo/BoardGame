package View;

import Model.Board.BoardImp;
import Model.Ship.ShipInfo;

public class GameViewImp implements GameView {
    private  String welcomeText = "Welcome to Battle Ship Game ...";
    private  String menuText = "1. Play with virtual opponent\n 2. Play with human opponent\n Choose option: ";
    private  String warningMessage = "Please choose a valid option";
    private String inputMessageForRow = "Input Row(1 to 10)";
    private String inputMessageForCol = "Input Column(1 to 15)";
    private  String invalidRowMessage = "Given row is out of the board. Please input a valid one: ";
    private  String invalidColMessage = "Given column is out of the board. Please input a valid one: ";
    private String humanPlayerHitMessage = "Congrats! You have hit opponent's ship";
    private String humanOpponentPlayerHitMessage = "Ooops! Opponent has hit your ship";
    private String virtualPlayerHitMessage = "Computer has hit your ship";
    private  String humanPlayerMissMessage = "Oops!, you have missed";
    private String humanOpponentMissMessage = "Opponent has missed";
    private String virtualPlayerMissMessage = "Computer has missed";
    private  String humanPlayerSunkMessage = "Ya hoo!, you have sunk one opponent's ship";
    private String virtualPlayerSunkMessage = "Computer has sunk your ship";
    private String initializingBoardMessage = "Initializing Game Boards\n";
    private String humanPlayerShipDeployMessage = "Deploying your ships\n";
    private String virtualPlayerShipDeployMessage = "Deploying Computer's ship\n";
    private String gameStartingMessage = "Start Firing\n";
    private String humanPlayerTurnMessage = "It's your Turn\n";
    private String virtualPlayerTurnMessage = "It's Computer's Turn\n";
    private String humanAlreadyFired = "You have already fired";
    private String computerAlreadyFired = "Computer has already fired";
    private String timeOverMessage = "Time Over";
    private String gameOverMessage = "Game Over";
    private String winMessage = " is the winner";
    private String allShipSunkMessage = "All ship sunk";
    private String serverWaitingMessage = "Waiting for another player to join";
    private String playerJoinedMessage = "Player has joined";
    private String humanOpponentSunkMessage = "Oops! Opponent has sunk your ship";
    private String youWonMessage = "You won";
    private String turnMessageWithName = " 's turn.";
    private String connectedToServerMessage = "Successfully connected to the game server";
    private String opponentDidNotRespondMessage = "Opponent Didn't respond";
    private String startServerWarning = "Please start server";
    private String enterYourNameMessage = "Enter your name: ";

    @Override
    public void printWelcomeMessage() {
        System.out.println( welcomeText );
    }

    @Override
    public void showGameOverMessage() {
        System.out.println(gameOverMessage);
    }

    @Override
    public void showTimeOverMessage() {
        System.out.println(timeOverMessage);
    }

    @Override
    public void showWinnerName(String winner) {
        System.out.println(winner+winMessage);
    }

    @Override
    public void showAllShipSunkMessage() {
        System.out.println(allShipSunkMessage);
    }


    @Override
    public void printAlreadyFiredMessage(int playerType) {

        if(playerType == 1)
        {
            System.out.println(humanAlreadyFired);
        }
        else{
            System.out.println(virtualPlayerMissMessage);
        }

    }

    @Override
    public void printHumanPlayerTurnMessage() {
        System.out.println(humanPlayerTurnMessage);
    }

    @Override
    public void printVirtualPlayerTurnMessage() {
        System.out.println(virtualPlayerTurnMessage);
    }

    @Override
    public void printHitMessage(int playerType) {
        if(playerType==1)
        {
            System.out.println(humanPlayerHitMessage);
        }
        else {
            System.out.println(virtualPlayerHitMessage);
        }
    }

    @Override
    public void printMissMessage(int playerType) {
        if(playerType==1)
        {
            System.out.println(humanPlayerMissMessage);
        }
        else {
            System.out.println(virtualPlayerMissMessage);
        }
    }

    @Override
    public void printSunkMessage(int playerType) {
        if(playerType==1)
        {
            System.out.println(humanPlayerSunkMessage);
        }
        else {
            System.out.println(virtualPlayerSunkMessage);
        }
    }

    @Override
    public void printPoint(int playerType, int point) {

        if(playerType==1)
        {
            System.out.println("Your Point: "+point);
        }
        else {

            System.out.println("Computer's Point: "+point);

        }

    }

    @Override
    public void showOwnBoard(BoardImp board1) {
        int[][] board= board1.getBoard();
        System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ \tK \tL \tM \tN \tO");
        System.out.println();


        for (int i = 0; i < 10; i++) {
            System.out.print((i+1) + "");
            for (int j = 0; j < 15; j++) {
                if( board[i][j] == -1)
                {
                    System.out.print("\t~"); // denotes empty cell
                }
                else if ( board[i][j] <= 2 ) {
                    System.out.print( "\tc" + (board[i][j] - ShipInfo.carrierType ));
                }
                else if ( board[i][j] <= 5 ) {
                    System.out.print( "\tb" + (board[i][j] - ShipInfo.battleShipType));
                }
                else if ( board[i][j] <= 10 ) {
                    System.out.print( "\td" + (board[i][j] - ShipInfo.destroyerType));
                }
                else if ( board[i][j] <= 18 ) {
                    System.out.print( "\ts" + (board[i][j] - ShipInfo.superPatrolType));
                }
                else {
                    System.out.print( "\tp" + (board[i][j] - ShipInfo.patrolBoatType));
                }
                
            }
            System.out.println("\n");
        }
        System.out.println();

    }

    @Override
    public void printInstructionsMessage() {
        System.out.print(menuText);
    }

    @Override
    public void printWarning() {
        System.out.println(warningMessage);
        printInstructionsMessage();
    }

    @Override
    public void promptInputMessageForRow() {
        System.out.print(inputMessageForRow);
    }

    @Override
    public void promptInputMessageForColumn() {
        System.out.print(inputMessageForCol);
    }

    @Override
    public void invalidRowWarning() {
        System.out.println(invalidRowMessage);
    }

    @Override
    public void invalidColWarning() {
        System.out.println(invalidColMessage);
    }

    @Override
    public void printBoardInitializationMessage() {
        System.out.println(initializingBoardMessage);
    }

    @Override
    public void printHumanPlayerShipDeploymentMessage() {
        System.out.println(humanPlayerShipDeployMessage);
    }

    @Override
    public void printVirtualPlayerShipDeploymentMessage() {
        System.out.println(virtualPlayerShipDeployMessage);
    }

    @Override
    public void showEnemyBoard(BoardImp board1) {
        int[][] board= board1.getBoard();

        System.out.println("\tA \tB \tC \tD \tE \tF \tG \tH \tI \tJ \tK \tL \tM \tN \tO");
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print((i+1) + "");
            for (int j = 0; j < 15; j++) {
                if( board[i][j] == -5)
                {
                    System.out.print("\tx"); // denote miss hit cell
                }
                else if( board[i][j] == 0)
                {
                    System.out.print("\t#");  // denotes hit cell
                }
                else
                {
                    System.out.print("\t~"); // denotes empty
                }

            }
            System.out.println("\n");
        }
        System.out.println();
    }

    @Override
    public void printGameStartingMessage() {
        System.out.println(gameStartingMessage);
    }

    @Override
    public void showServerStartedMessage(String name) {
        System.out.println("Hi "+name+"!\n"+ "Server has started successfully");
    }

    @Override
    public void showServerWaitingMessage() {
         System.out.println(serverWaitingMessage);
    }

    @Override
    public void showPlayerJoinedMessage() {
          System.out.println(playerJoinedMessage);
    }

    @Override
    public void showOpponentsHitMessage() {
        System.out.println(humanOpponentPlayerHitMessage);
    }

    @Override
    public void showOpponentsMissMessage() {
System.out.println(humanOpponentMissMessage);
    }

    @Override
    public void showPointsWithName(String name,int point) {
        System.out.println(name+"'s point: "+point);
    }

    @Override
    public void showHumanOpponentPlayerSunkMessage() {
        System.out.println(humanOpponentSunkMessage);
    }

    @Override
    public void printWinMessageWithPlayerName(String name) {
        System.out.println(name + " wins");
    }

    @Override
    public void printYouWonMessage() {
        System.out.println(youWonMessage);
    }

    @Override
    public void printTurnMessageWithName(String name) {
        System.out.println(name + turnMessageWithName );
    }

    @Override
    public  void printConnectedToServerMessage(String name){
        System.out.println( "Hi " + name + " " + connectedToServerMessage);
    }

    @Override
    public  void printOpponentDidNotResponseMessage() {
        System.out.println(opponentDidNotRespondMessage);
    }

    @Override
    public void printStartServerWarning() {
        System.out.println(startServerWarning);
    }

    @Override
    public void enterYourNameMessage() {
        System.out.print(enterYourNameMessage);
    }
}
