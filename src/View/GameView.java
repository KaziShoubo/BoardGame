package View;

import Model.Board.BoardImp;

public interface GameView {

    public void printWelcomeMessage();

    public void showGameOverMessage();

    public void showTimeOverMessage();

    public void showWinnerName(String winner);

    public void showAllShipSunkMessage();

    public void printAlreadyFiredMessage(int playerType);

    public void printHumanPlayerTurnMessage();

    public void printVirtualPlayerTurnMessage();

    public void printHitMessage(int playerType);

    public void printMissMessage(int playerType);

    public  void printSunkMessage(int playerType);

    public void printPoint(int playerType, int point);

    /**
     *  printing own board with deployed ship
     * @param board
     */
    public void showOwnBoard(BoardImp board);

    public void printInstructionsMessage();

    public void printWarning();

    public void promptInputMessageForRow();

    public void promptInputMessageForColumn();

    public void invalidRowWarning();

    public void invalidColWarning();

    public void printBoardInitializationMessage();

    public void printHumanPlayerShipDeploymentMessage();

    public void printVirtualPlayerShipDeploymentMessage();
    
    /**
     *  printing board containing fired cell
     * @param board
     */
    public void showEnemyBoard(BoardImp board);

    public void printGameStartingMessage();

    public void showServerStartedMessage(String name);

    public void showServerWaitingMessage();

    public void showPlayerJoinedMessage();

    public void showOpponentsHitMessage();

    public void showOpponentsMissMessage();

    public void showPointsWithName(String name,int point);

    public void showHumanOpponentPlayerSunkMessage();

    public void printWinMessageWithPlayerName(String name);

    public void printYouWonMessage();

    public void printTurnMessageWithName(String name);

    public  void printConnectedToServerMessage(String name);

    public  void printOpponentDidNotResponseMessage();

    public void printStartServerWarning();

    public void enterYourNameMessage();
}
