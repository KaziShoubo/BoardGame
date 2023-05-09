package Model.Ship;

import Model.Board.Board;

public class Destroyer extends Ship{

    public Destroyer(Board board, int instanceNo)
    {
        this.shipHealth=ShipInfo.destroyerSize;
        this.shipSize=ShipInfo.destroyerSize;
        this.shipType=ShipInfo.destroyerType;
        this.shipInstance=instanceNo;
        this.board=board.getBoard();
    }




}
