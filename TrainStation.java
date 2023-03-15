public class TrainStation extends Location{
    int numberOfTrains;

    public TrainStation(String name,float xcord,float ycord, int numberOfTrains) {
        this.name=name;
        this.xcord=xcord;
        this.ycord=ycord;
        this.numberOfTrains=numberOfTrains;
    }
}
