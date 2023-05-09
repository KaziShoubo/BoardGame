package Test;

import Model.Board.Board;
import Model.Board.BoardImp;
import Model.Ship.Carrier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarrierTest {
    Carrier carrier ;
    Board board;

    @BeforeEach
    public void setup()
    {
        board = new BoardImp();
        carrier = new Carrier(board,3);
    }

    @Test
    public void isSunk()
    {
        Assertions.assertEquals(carrier.isSunk(),false);
        carrier.hitShip();
        carrier.hitShip();
        carrier.hitShip();
        carrier.hitShip();
        carrier.hitShip();
        Assertions.assertEquals(carrier.isSunk(),true);
    }
}