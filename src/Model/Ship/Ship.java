package Model.Ship;

import Model.Board.Board;
import Model.Board.BoardImp;

import java.io.Serializable;
import java.util.Random;

public abstract class Ship implements Serializable {

    protected int shipSize;
    protected int shipType;
    protected int shipInstance;
    protected int shipHealth;
    protected int[][] board;

    /**
     *  returns true if it's sunk
     */
    public boolean isSunk(){
        return shipHealth==0;
    }

    /**
     *  decreasing ship health by one if hit once
     */
    public void hitShip(){
        --shipHealth; 

    }

    public int getShipType(){
        return shipType;
    }

    public int getShipInstance(){
        return shipInstance;
    }

    /**
     *  randomly deploying ship horizontally on user game board
     */
    public void deployShip() { 

        Random random= new Random();
        Board boardInfo = new BoardImp();
        boolean deployed= false;
        int shipDenotedInt = shipType + shipInstance;  // let's for c1(carrier1), ship type = 0 and instance = 1, ship denotedInt = 0 + 1 = 1

        while(!deployed){

        	// Randomly calculating starting coordinates for ship placement
        	int posX= random.nextInt(boardInfo.getBoardRow() - 1);
        	int posY= random.nextInt(boardInfo.getBoardColumn() - 1);

        	// checking if the starting cell is valid for the ship placement
        	boolean slotFound = true;

        	for(int i=0; i<shipSize; i++){

        		if(posY + i > 14){
        			slotFound = false;
        			break;
        		}
        		if( board[posX][posY + i] != -1){
        			slotFound = false;
        			break;
        		}

        	}


        	//Deploying the ship if found valid starting cell

        	if(slotFound) {
        		for(int i=0; i<shipSize; i++){
        			board[posX][posY + i] = shipDenotedInt;
        		}

        		deployed=true;


        	}
        }
    }
}
