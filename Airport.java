
public class Airport extends Location{
    int numberOfTerminals;

    public Airport(String name,float xcord,float ycord,int numberOfTerminals)
    {
        this.name=name;
        this.xcord=xcord;
        this.ycord=ycord;
        this.numberOfTerminals = numberOfTerminals;
    }
}
