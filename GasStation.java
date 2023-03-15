public class GasStation extends Location{

    float gasPrice;
    public GasStation(String name,float xcord,float ycord,float gasPrice)
    {
        this.name=name;
        this.xcord=xcord;
        this.ycord=ycord;
        this.gasPrice = gasPrice;
    }
}
