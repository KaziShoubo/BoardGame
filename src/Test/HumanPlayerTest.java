package Test;

import Model.Player.HumanPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest  {

    private HumanPlayer humanPlayer;

    @BeforeEach
    void setup()
    {
        humanPlayer = new HumanPlayer("John");
        humanPlayer.loadShips();
    }

    @Test
    public void getPlayerName()
    {
        Assertions.assertEquals(humanPlayer.getPlayerName(),"John");
    }

    @Test
    public void getTotalShipNumbers()
    {

        Assertions.assertEquals(humanPlayer.getTotalShipNumbers(),28);
    }

    @Test
    public void getPoint()
    {
        Assertions.assertEquals(humanPlayer.getPoints(),0);
        humanPlayer.increasePoint();
        Assertions.assertEquals(humanPlayer.getPoints(),1);
        humanPlayer.increasePoint();
        humanPlayer.increasePoint();
        humanPlayer.increasePoint();
        humanPlayer.increasePoint();
        Assertions.assertEquals(humanPlayer.getPoints(),5);
    }


}