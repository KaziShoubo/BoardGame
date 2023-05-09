 package Model.Board;

 import java.io.Serializable;

 public class BoardImp implements Board , Serializable {
    static int boardRow = 10;
    static int boardColumn = 15;
    public int[][] board = new int[boardRow][boardColumn];
  
    @Override
    public void initializeBoard() {

        for(int i=0; i<boardRow; i++){


            for(int j=0; j<boardColumn; j++){

                board[i][j]=-1;  // -1 denotes empty cell

            }

        }

    }
     @Override
    public int getBoardRow(){
        return boardRow;
    }
     @Override
    public int getBoardColumn(){
        return boardColumn;
    }

    @Override
    public int[][] getBoard() {
        return board;
    }

    @Override
    public boolean isHit(int posX, int posY) {
        return board[posX-1][posY-1] != -1 && board[posX-1][posY-1] != 0 && board[posX-1][posY-1] != -5;
    }

    @Override
    public void fire(int posX, int posY) {

        if(board[posX-1][posY-1]!=0 && board[posX-1][posY-1]!=-5)
        {
            if(isHit(posX,posY))
            {
                board[posX-1][posY-1] = 0;  // 0 denotes hit
            }
            else {
                board[posX-1][posY-1] = -5;  // -5 denotes miss
            }
        }

    }

    @Override
    public boolean isAlreadyFired(int posX, int posY)
    {
        return board[posX-1][posY-1] == 0 || board[posX-1][posY-1] == -5;
    }
    @Override
    public int getCellValue(int posX, int posY) {
        return board[posX-1][posY-1];
    }
}
