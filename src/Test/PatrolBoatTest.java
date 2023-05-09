package Test;

import Model.Board.Board;
import Model.Board.BoardImp;
import Model.Ship.PatrolBoat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatrolBoatTest {
    PatrolBoat patrolBoat ;
    Board board;

    @BeforeEach
    public void setup()
    {
        board = new BoardImp();
        patrolBoat = new PatrolBoat(board,3);
    }

    @Test
    public void shipType()
    {
        Assertions.assertEquals(patrolBoat.getShipType(),18);
    }

    @Test
    public void shipInstance()
    {
        Assertions.assertEquals(patrolBoat.getShipInstance(),3);
    }

    @Test
    public void isSunk()
    {
        Assertions.assertEquals(patrolBoat.isSunk(),false);
        patrolBoat.hitShip();
        Assertions.assertEquals(patrolBoat.isSunk(),true);
    }

}