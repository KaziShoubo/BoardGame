package Model.Ship;

import Model.Board.Board;


public class PatrolBoat extends Ship{

    public PatrolBoat(Board board, int instanceNo){
        this.shipHealth=ShipInfo.patrolBoatSize;
        this.shipSize=ShipInfo.patrolBoatSize;
        this.shipType=ShipInfo.patrolBoatType;
        this.shipInstance=instanceNo;
        this.board=board.getBoard();
    }



}
