package Test;

import Model.Board.Board;
import Model.Board.BoardImp;
import Model.Ship.SuperPatrol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperPatrolTest {
    SuperPatrol superPatrol ;
    Board board;

    @BeforeEach
    public void setup()
    {
        board = new BoardImp();
        superPatrol = new SuperPatrol(board,3);
    }

    @Test
    public void isSunk()
    {
        Assertions.assertEquals(superPatrol.isSunk(),false);
        superPatrol.hitShip();
        superPatrol.hitShip();
        Assertions.assertEquals(superPatrol.isSunk(),true);
    }
}