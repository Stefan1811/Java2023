import java.util.Objects;

public class Road {
    protected Location loc1,loc2;
    protected RoadType type;
    protected float length, speedLimit;

    public Road(RoadType type, Location loc1, Location loc2, float length, float speedLimit){
        this.type = type;
        this.loc1=loc1;
        this.loc2=loc2;
        this.speedLimit=speedLimit;
        this.length=Math.max(length,Algo.euclidianDist(loc1,loc2));
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Location getLoc1() {
        return loc1;
    }

    public void setLoc1(Location loc1) {
        this.loc1 = loc1;
    }

    public Location getLoc2() {
        return loc2;
    }

    public void setLoc2(Location loc2) {
        this.loc2 = loc2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return Float.compare(road.getLength(), getLength()) == 0 && Float.compare(road.getSpeedLimit(), getSpeedLimit()) == 0 && getLoc1().equals(road.getLoc1()) && getLoc2().equals(road.getLoc2()) && getType() == road.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoc1(), getLoc2(), getType(), getLength(), getSpeedLimit());
    }

    @Override
    public String toString() {
        return "Road{" +
                "loc1=" + loc1 +
                ", loc2=" + loc2 +
                ", type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }

    public Location getNeighbour(Location loc)
    {
        if(loc1==loc)
            return loc2;
        if(loc1!=loc && loc2!=loc)
            return null;
        return loc1;
    }
}
