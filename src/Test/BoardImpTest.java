package Test;

import Model.Board.Board;
import Model.Board.BoardImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardImpTest {
    private Board board;

    @BeforeEach
    void setup()
    {
        board = new BoardImp();
        board.initializeBoard();
    }





    @Test
    void getBoardRow() {
        Assertions.assertEquals(board.getBoardRow(),10);
    }

    @Test
    void getBoardColumn() {
        Assertions.assertEquals(board.getBoardColumn(),15);
    }

    @Test
    void getCellValue() {
        Assertions.assertEquals(board.getCellValue(5,5),-1);
        board.fire(1,5);// fires and misses
        Assertions.assertEquals(board.getCellValue(1,5),-5);// -5 denotes miss
    }
}