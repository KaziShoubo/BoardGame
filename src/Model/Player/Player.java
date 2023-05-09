package Model.Player;

import java.io.Serializable;
import java.util.ArrayList;

import Model.Board.Board;
import Model.Board.BoardImp;
import Model.Ship.*;
import View.GameView;
import View.GameViewImp;

public abstract class Player implements Serializable {

    protected int playerType;
    protected BoardImp board;
    protected String playerName;
    protected ArrayList<Ship> listOfShips;
    protected int points;

    public Player(){
        this.listOfShips = new ArrayList<Ship>();
        this.board= new BoardImp();
        this.points = 0;
    }

    public int getTotalShipNumbers () {
        return listOfShips.size();
    }

    public void initializeGameBoard(){
        board.initializeBoard();
    }

    public int getPoints(){
        return points;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public BoardImp getCurrentBoard(){
        return board;
    }

    public ArrayList<Ship> getListOfShips(){
        return listOfShips;
    }

    /**
     * loads 5 types of ships each of which has more than one instance in a arrayList namely listOfShips
     */
    public void loadShips(){
        int[] shipQuantity= {2,3,5,8,10};
        for(int i=0; i<5; i++){
        	for(int j=1; j <= shipQuantity[i]; j++ ){
                     
                if(i==0){
                    listOfShips.add(new Carrier(board, j));
                } else if(i==1) {
                    listOfShips.add(new BattleShip(board, j));
                } else if(i==2) {
                    listOfShips.add(new Destroyer(board, j));

                } else if(i==3) {
                    listOfShips.add(new SuperPatrol(board, j));

                } else if(i==4) {
                    listOfShips.add(new PatrolBoat(board, j));

                }

            }

        }

    }

    /**
     *  deploying the loaded ships in the player-board
     */
    public void deployShips(){
        for(int i=0; i< listOfShips.size(); i++) {
            listOfShips.get(i).deployShip();
        }
    }

    /**
     *  increase points for hit and sunk
     */
    public void increasePoint(){
        points++;
    }

    /**
     *  gets player's name from the object
     */
    public String getPlayerName(){
        return playerName;
    }

    /**
     *  gets player's type from the object
     */
    public int getPlayerType(){
        return playerType;
    }


}
