package Model.Ship;

import Model.Board.Board;

public class BattleShip extends Ship {

    public BattleShip(Board board, int instanceNo){
        this.shipHealth=ShipInfo.battleShipSize;
        this.shipSize=ShipInfo.battleShipSize;
        this.shipType=ShipInfo.battleShipType;
        this.shipInstance=instanceNo;
        this.board=board.getBoard();
    }


}
