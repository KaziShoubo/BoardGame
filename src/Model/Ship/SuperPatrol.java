package Model.Ship;


import Model.Board.Board;

public class SuperPatrol extends Ship {

    public SuperPatrol(Board board, int instanceNo)
    {
        this.shipHealth=ShipInfo.superPatrolSize;
        this.shipSize=ShipInfo.superPatrolSize;
        this.shipType=ShipInfo.superPatrolType;
        this.shipInstance=instanceNo;
        this.board=board.getBoard();
    }


}