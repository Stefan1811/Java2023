
public class Algo {
     public static float euclidianDist(Location loc1,Location loc2)
     {
         double first=Math.pow((loc1.getXcord()-loc2.getXcord()),2);
         double second=Math.pow((loc1.getYcord()-loc2.getYcord()),2);
         double result=Math.sqrt(first+second);
         return (float) result;
     }
     public static boolean DFS(Location start,Location finish)
     {
         if(start==finish)
             return true;
         start.setVisited(true);
         for(Road road:start.getListOfRoads())
         {
             Location next=road.getNeighbour(start);
             if(DFS(next,finish) && !next.isVisited())
                 return true;
         }
         return false;
     }

}
