package Controller;

import Model.Board.Board;
import Model.Input.ConsoleInput;
import Model.Player.HumanPlayer;
import Model.Player.Player;
import Model.Player.VirtualPlayer;
import Model.Ship.Ship;
import Model.Ship.ShipInfo;
import View.GameView;
import View.GameViewImp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Timer;


public class GameController {
	private String  playerName;
    private String winnerName ;
    private Scanner scanner ;
    private GameView gameView;
    private HumanPlayer humanPlayer;
    private VirtualPlayer virtualPlayer;
    private static int lastHitPosX = -1;
    private static int lastHitPosY = -1;
    private boolean isGameOver;
    private Timer timer ;
    private long gameStartingTime;
    private int posX = 0,posY = 0;
    private int turnFlag = 0;
    private Random random;


    public GameController(String playerName){
        this.playerName = playerName;
        this.gameView = new GameViewImp();
        this.humanPlayer = new HumanPlayer(playerName);
        this.virtualPlayer = new VirtualPlayer();
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }

    /**
     *  initializes the game play
     */
    public void initializeGame() {
        gameView.printBoardInitializationMessage();
        humanPlayer.initializeGameBoard();
        virtualPlayer.initializeGameBoard();
        humanPlayer.loadShips();
        virtualPlayer.loadShips();
        gameView.showOwnBoard(humanPlayer.getCurrentBoard());
        delay(2);

        gameView.printHumanPlayerShipDeploymentMessage();
        delay(2);
        humanPlayer.deployShips();
        gameView.showOwnBoard(humanPlayer.getCurrentBoard());

        delay(2);
        gameView.printVirtualPlayerShipDeploymentMessage();
        virtualPlayer.deployShips();

        gameView.printGameStartingMessage();
        gameView.showEnemyBoard(virtualPlayer.getCurrentBoard());

        gameStartingTime = System.currentTimeMillis();


    }
    
    
    /**
    *Controls the game flow
    *i.controls turn flow
   	*ii. for each turn it checks if all ship is sunk, if 5 mins passes
   	*/
    public void playGame() throws InterruptedException	{
        
        long gameStartingTime = System.currentTimeMillis();
        turnFlag = 0;

        while (!isAllShipSunk())
        {
            int timeElapse = (int) ((System.currentTimeMillis() -gameStartingTime) / 1000);

            if( timeElapse >= 300 ){
                gameView.showTimeOverMessage();

                break;

            }
            posX=0;
            posY=0;
            if(turnFlag == 0) {    		// human Player's Turn
                humanPlayersTurn();
            }

            else {
                virtualPlayersTurn(); 	// Virtual Player's Turn
            }
            gameView.printPoint(humanPlayer.getPlayerType(), humanPlayer.getPoints());      // prints human player's points
            gameView.printPoint(virtualPlayer.getPlayerType(), virtualPlayer.getPoints());  // prints virtual player's points

        }


        if(isAllShipSunk())	{
            gameView.showAllShipSunkMessage();
        }
        generateGameResultOnGameOver();
    }

    
    /**
     *  when game is over it generates the result
     */
    private void generateGameResultOnGameOver()	{
        gameView.showGameOverMessage();
        if(virtualPlayer.getPoints() > humanPlayer.getPoints()) {

            gameView.printWinMessageWithPlayerName(virtualPlayer.getPlayerName());
        }
        else if (virtualPlayer.getPoints() == humanPlayer.getPoints()) {
            delay(2);
            gameView.printWinMessageWithPlayerName(getWinnerName());
        }
        else {

            gameView.printYouWonMessage();
        }
    }
    
    /**
     * perform the turn based following the strategy
     * if last firing is not a hit, then taking random coordinate
     * checks if the currently fired cell is already fired or not
     * if current fire is a hit, then storing the coordinates to use make best guess
     */
    private void virtualPlayersTurn() {
    	gameView.printVirtualPlayerTurnMessage();
    	if(!wasHit()){  
    		do{
               posX = random.nextInt(virtualPlayer.getCurrentBoard().getBoardRow());
               while (posX < 1) {
                   posX = random.nextInt(virtualPlayer.getCurrentBoard().getBoardRow());
                }

                posY = random.nextInt(virtualPlayer.getCurrentBoard().getBoardColumn());
                while (posY < 1) {
                    posY = random.nextInt(virtualPlayer.getCurrentBoard().getBoardColumn());
                }
            }while (humanPlayer.getCurrentBoard().isAlreadyFired(posX,posY));

        }
        else {

            if(isRightMovePossible()){
                // Right move
                posX=lastHitPosX;
                posY=lastHitPosY+1;
            }
            else {
                if(isUpMovePossible()){
                    // Up move
                    posX=lastHitPosX+1;
                    posY=lastHitPosY;
                }
                else {
                    // Down move
                    posX=lastHitPosX-1;
                    posY=lastHitPosY;

                }

            }
        }

        if(humanPlayer.getCurrentBoard().isHit(posX,posY)){
            lastHitPosX = posX;
            lastHitPosY = posY;
            turnFlag = 1;     // computer turn remains
        }else{
            lastHitPosX = -1; // denotes last fire was a miss
            lastHitPosY = -1;
            turnFlag = 0;    // changing turn
        }

        performPlayerTurn(virtualPlayer, humanPlayer, posX, posY);
    }

    
    /**
     * control left to human player to get row and col value, perform the turn
     * @throws InterruptedException
     * it waits 30 seconds after prompting message for input
     */
    private void humanPlayersTurn() throws InterruptedException {

        gameView.printHumanPlayerTurnMessage();
        gameView.promptInputMessageForRow();

        ConsoleInput con = new ConsoleInput(  
                1
                ,
                30,
                TimeUnit.SECONDS
        );
        long startingTime = System.currentTimeMillis();

        String inputLine = con.readLine();

        if(inputLine != null) {               // null means user didn't put any input
            posX = Integer.parseInt(inputLine);
        }



        while ((posX > 10 || posX < 1) && posX != 0) { // true only if posX is valid for the board

            gameView.invalidRowWarning();
            inputLine = con.readLine();
            if(inputLine != null) {
                posX = Integer.parseInt(inputLine);
            }
        }

        if(posX != 0) { 	// false if user puts no input

            int restTime = (int) (30 - (System.currentTimeMillis() - startingTime) / 1000);

            ConsoleInput con1 = new ConsoleInput(
                    1
                    ,restTime
                    ,
                    TimeUnit.SECONDS
            );

            gameView.promptInputMessageForColumn();
            inputLine = con1.readLine();
            if(inputLine != null) {
                posY = Integer.parseInt(inputLine);
            }

            while ((posY > 15 || posY < 1) && posY != 0 ) {

                gameView.invalidColWarning();
                inputLine = con1.readLine();
                if(inputLine != null) {
                    posY = Integer.parseInt(inputLine);
                }
            }

            if(posX > 0 && posY > 0) {

                if (virtualPlayer.getCurrentBoard().isHit(posX , posY )) {
                    turnFlag = 0; 	// turn remains same

                } else {

                    turnFlag = 1;  	// turn changes
                }

                performPlayerTurn(humanPlayer, virtualPlayer, posX, posY);
                gameView.showEnemyBoard(virtualPlayer.getCurrentBoard());


            } else {
                turnFlag = 1; 	// turn changes
            }
        }
        else {
            turnFlag = 1;  		// turn changes
        }
    }

    public void delay(int time)  {

        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  checking  if all ships is sunk
     */
    public boolean isAllShipSunk() {
        boolean allSunk = false;
        int sunk_count =0;
        int totalShipCount = ShipInfo.getTotalShipCount();
        ArrayList<Ship> shipsOfHumanPlayer = humanPlayer.getListOfShips();
        ArrayList<Ship> shipsOfVirtualPlayer = virtualPlayer.getListOfShips();

        for(int i=0; i<shipsOfHumanPlayer.size(); i++){
            if(shipsOfHumanPlayer.get(i).isSunk()){
                sunk_count++;
            }
        }

        if(sunk_count == totalShipCount){
            winnerName = virtualPlayer.getPlayerName();
            allSunk = true;
            return allSunk;
        }

        sunk_count = 0;
        for(int i=0; i<shipsOfVirtualPlayer.size(); i++){
            if(shipsOfVirtualPlayer.get(i).isSunk()){
                sunk_count++;
            }
        }

        if(sunk_count == totalShipCount){
            winnerName = humanPlayer.getPlayerName();
            allSunk = true;
            return allSunk;
        }

        return allSunk;

    }

    /**
     * it helps the strategy by telling  if the last fire was a hit
     */
    public boolean wasHit() {
        return lastHitPosX != -1 && lastHitPosY != -1;
    }

    /**
     * if computer ended up in the last col of that row
     */
    public boolean isRightMovePossible() {
        return lastHitPosY <14;
    }

    /**
     *  if computer ended up in the last first
     */
    public boolean isUpMovePossible() {
        return lastHitPosX < 10;
    }
    
    /**
     *  deriving winner based on the sunk count
     */
    public  String getWinnerName() {  
        String winnerName ="" ;
        int sunk_count1 =0;
        int sunk_count2 =0;
        int[]  shipTypes = {ShipInfo.carrierType,ShipInfo.battleShipType,ShipInfo.destroyerType,ShipInfo.superPatrolType,ShipInfo.patrolBoatType};
        ArrayList<Ship> humanPlayerShips = humanPlayer.getListOfShips();
        ArrayList<Ship> virtualPlayerShips = virtualPlayer.getListOfShips();


        for(int i=0; i<ShipInfo.getNumberOfShipTypes(); i++){
            sunk_count1=0;
            sunk_count2=0;
            for(int k=0; k<humanPlayerShips.size(); k++){
                if(humanPlayerShips.get(i).getShipType()==shipTypes[i] &&  humanPlayerShips.get(i).isSunk()){
                    sunk_count1++;
                }
            }

            for(int k=0; k<virtualPlayerShips.size(); k++){
                if(virtualPlayerShips.get(i).getShipType()==shipTypes[i] && virtualPlayerShips.get(i).isSunk()){
                    sunk_count2++;
                }
            }

            if(sunk_count1 > sunk_count2) {

                winnerName = humanPlayer.getPlayerName();
                break;

            } else if(sunk_count1 < sunk_count2) {

                winnerName = virtualPlayer.getPlayerName();
                break;
            }

        }

        if(winnerName != "") 
        	return winnerName;
        else 
        	return "no one";

    } 
         
         
    /**
     * executes a player's turn
     * 1. checks if it's a hit or not
     * i.find ship type and instance number
     * ii. identifies the ship
     * iii. increase points
     * iv. checks if it's sunk or not
     */
    public void performPlayerTurn ( Player currentPlayer, Player enemyPlayer, int posX, int posY) {
        GameView gameView = new GameViewImp();
        Board enemyBoard ;
        ArrayList<Ship> enemyShipList ;
        enemyBoard = enemyPlayer.getCurrentBoard();
        enemyShipList = enemyPlayer.getListOfShips();

        if(enemyBoard.isHit(posX, posY)) {
            gameView.printHitMessage(currentPlayer.getPlayerType());
            int cellValue = enemyBoard.getCellValue(posX, posY);
            int shipType = cellValueToType(cellValue);
            int shipInstanceNumber = cellValue - shipType;

            for (Ship ship: enemyShipList ) {
                if( ship.getShipType() == shipType && shipInstanceNumber == ship.getShipInstance()) {
                    ship.hitShip();
                    currentPlayer.increasePoint();
                    if(ship.isSunk()) {
                        gameView.printSunkMessage(currentPlayer.getPlayerType());
                        currentPlayer.increasePoint();
                    }

                }
            }

            enemyBoard.fire(posX,posY);

        } else {

            if(enemyBoard.getCellValue(posX, posY) == 0 || enemyBoard.getCellValue(posX, posY) == -5){
                gameView.printAlreadyFiredMessage(currentPlayer.getPlayerType());
            }else{
                gameView.printMissMessage(currentPlayer.getPlayerType());
            }

            enemyBoard.fire(posX,posY);

        }

    }

    /**
     *  computing type value from  cellValue
     */
    public int cellValueToType (int cellValue) {

        if (  cellValue <= 2 ) {
            return ShipInfo.carrierType;
        }
        else if(cellValue <= 5 ) {
            return ShipInfo.battleShipType;
        }else if (cellValue <= 10) {
            return ShipInfo.destroyerType;
        }else if (cellValue <= 18) {
            return ShipInfo.superPatrolType;
        }else {
            return ShipInfo.patrolBoatType;
        }
    }
}
