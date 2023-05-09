package Test;

import Model.Board.Board;
import Model.Board.BoardImp;
import Model.Ship.Destroyer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DestroyerTest {
   Destroyer destroyer ;
    Board board;

    @BeforeEach
    public void setup()
    {
        board = new BoardImp();
        destroyer = new Destroyer(board,3);
    }

    @Test
    public void isSunk()
    {
        Assertions.assertEquals(destroyer.isSunk(),false);
        destroyer.hitShip();
        destroyer.hitShip();
        destroyer.hitShip();
        Assertions.assertEquals(destroyer.isSunk(),true);
    }
}