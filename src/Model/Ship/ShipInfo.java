package Model.Ship;

public class ShipInfo {
    //Size of Ships

    public static int carrierSize=5;
    public static int battleShipSize=4;
    public static int destroyerSize=3;
    public static int superPatrolSize=2;
    public static int patrolBoatSize=1;

    //Ship Type No

    public static int carrierType=0;
    public static int battleShipType=2;
    public static int destroyerType=5;
    public static int superPatrolType=10;
    public static int patrolBoatType=18;

    //Quantity of Ships

    public static int carrierQuantity=2;
    public static int battleShipQuantity=3;
    public static int destroyerQuantity=5;
    public static int superPatrolQuantity=8;
    public static int patrolBoatQuantity=10;

    public static int getTotalShipCount()
    {
        return carrierQuantity+battleShipQuantity+destroyerQuantity+superPatrolQuantity+patrolBoatQuantity;
    }
    public static int getNumberOfShipTypes()
    {
        return 5;
    }
}
