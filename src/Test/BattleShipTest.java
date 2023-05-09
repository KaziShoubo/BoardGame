package Test;

import Model.Board.Board;
import Model.Board.BoardImp;
import Model.Ship.BattleShip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleShipTest {

    BattleShip battleShip ;
    Board board;

    @BeforeEach
    public void setup()
    {
        board = new BoardImp();
        battleShip = new BattleShip(board,2);
    }

    @Test
    public void shipType()
    {
        Assertions.assertEquals(battleShip.getShipType(),2);
    }

    @Test
    public void shipInstance()
    {
        Assertions.assertEquals(battleShip.getShipInstance(),2);
    }

    @Test
    public void isSunk()
    {
        Assertions.assertEquals(battleShip.isSunk(),false);
        battleShip.hitShip();
        battleShip.hitShip();
        battleShip.hitShip();
        battleShip.hitShip();
        Assertions.assertEquals(battleShip.isSunk(),true);
    }
}