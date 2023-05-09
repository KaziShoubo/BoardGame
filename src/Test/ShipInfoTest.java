package Test;

import Model.Ship.ShipInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipInfoTest {

    @Test
    public void getTotalShipCount()
    {
        Assertions.assertEquals(ShipInfo.getTotalShipCount(),28);
    }

}