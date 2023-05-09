package Test;

import Model.Player.VirtualPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VirtualPlayerTest {
    private VirtualPlayer virtualPlayer;

    @BeforeEach
    void setup()
    {
        virtualPlayer = new VirtualPlayer();
        virtualPlayer.loadShips();
    }

    @Test
    public void getPlayerName()
    {
        Assertions.assertEquals(virtualPlayer.getPlayerName(),"Computer");
    }

    @Test
    public void getTotalShipNumbers()
    {

        Assertions.assertEquals(virtualPlayer.getTotalShipNumbers(),28);
    }

    @Test
    public void getPoint()
    {
        Assertions.assertEquals(virtualPlayer.getPoints(),0);
        virtualPlayer.increasePoint();
        Assertions.assertEquals(virtualPlayer.getPoints(),1);
        virtualPlayer.increasePoint();
        virtualPlayer.increasePoint();
        Assertions.assertEquals(virtualPlayer.getPoints(),3);
    }
}