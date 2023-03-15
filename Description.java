import java.util.ArrayList;

public class Description {
    Location start,finish;
    ArrayList<Location>listOfLocations=new ArrayList<Location>();
    ArrayList<Road>listOfRoads=new ArrayList<Road>();

    public Description() {
    }

    public Description(Location start, Location finish) {
        this.start = start;
        this.finish=finish;
    }

    boolean existLocation(Location loc)
    {
        // we check if a location exists
        for(Location existloc:listOfLocations)
        {
            if(existloc==loc) {
                return true;
            }
        }
        return false;
    }
    public void addLocation(Location loc)
    {
        //we add the location to the locations array if it doesn't exists in array
        if(this.existLocation(loc)==true)
        {
            return;
        }
        listOfLocations.add(loc);
    }
    boolean existRoad(Road r)
    {
        //we check if a road exists
        for(Road existr:listOfRoads)
        {
            if(existr==r) {
                return true;
            }
        }
        return false;
    }
    public void addRoad(Road r)
    {
        //we check if the road exists in the roads array, if the road exists we do nothing
        if(this.existRoad(r))
        {
            return;
        }
        boolean firstloc=this.existLocation(r.loc1);
        boolean secondloc=this.existLocation(r.loc2);
        // we check if both of location are in the problem
        if((firstloc && secondloc)==false)
        {
            return;
        }
        // if the road pass the above test, we add the road to the road array
        listOfRoads.add(r);

    }
    public boolean validProb()
    {
        //the validation of the problem means that the start and finish destinations exists
        if(!this.existLocation(start) || !this.existLocation(finish)) {
            return false;
        }
        return true;
    }
    public boolean existRoadBetweenLocations()
    {
        //we check if the problem is valid and if it is true we run dfs algoritm to verify if we can arrive to finish destination from start destination
        if(this.validProb()==false){
            return false;
        }
        for(Location loc:listOfLocations)
            loc.setVisited(false);
        boolean resultDFS=Algo.DFS(start,finish);
        return resultDFS;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getFinish() {
        return finish;
    }

    public void setFinish(Location finish) {
        this.finish = finish;
    }
}
