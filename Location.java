import java.util.ArrayList;
import java.util.Objects;

public class Location {
    protected float xcord,ycord;
    protected String name;
    //a list of roads that are between two locations of the problem
    protected ArrayList<Road>listOfRoads= new ArrayList<Road>();
    boolean visited;

    public Location() {
    }

    public Location(float xcord, float ycord, String name, boolean visited) {

        this.xcord = xcord;
        this.ycord=ycord;
        this.name=name;
        visited=false;
    }

    public void addRoad(Road newRoad)
    {
        //verify a road exist, if it exist, it will be add to the list of roads
        for(Road existentRoad: listOfRoads)
        {
            if(existentRoad==newRoad)
                return;
        }
        listOfRoads.add(newRoad);
    }
    public float getXcord() {
        return xcord;
    }

    public float getYcord() {
        return ycord;
    }

    public void setXcord(float xcord) {
        this.xcord = xcord;
    }

    public void setYcord(float ycord) {
        this.ycord = ycord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Road> getListOfRoads() {
        return listOfRoads;
    }

    @Override
    public String toString() {
        return "Location{" +
                "xcord=" + xcord +
                ", ycord=" + ycord +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Float.compare(location.getXcord(), getXcord()) == 0 && Float.compare(location.getYcord(), getYcord()) == 0 && getName().equals(location.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getXcord(), getYcord(), getName());
    }
}
