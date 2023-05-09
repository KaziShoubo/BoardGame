package Model.Board;


public interface Board {

    /**
     * Initializing game board
     */
    public void initializeBoard();

    public int[][] getBoard();

    /**
     * It's a hit when the cell is empty and for this empty cell no hit and miss event has been occured.
     */
    public boolean isHit(int posX, int posY);
    
    /**
     * Makes afire to the cell, -1 denotes empty cell, 0 denotes a hit and -5 denotes a miss
     */

    public void fire(int posX, int posY);

    /**
     * If for a specific cell the hit or the miss even has occured, then it's an already fired cell
     */
    public boolean isAlreadyFired(int posX, int posY);

    public int getCellValue(int posX, int posY);

    public int getBoardRow();

    public int getBoardColumn();
}
