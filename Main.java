public class Main {
    public static void main(String[] args) {
        Location loc1=new City("Bodesti",12.35f,32.43f,10000);
        Location loc2=new City("Piatra", 23.31f, 44.21f,50000);
        Location loc3=new GasStation("OMW", 30.12f, 55.22f,7.65f);
        Location loc4=new GasStation("Petrom", 43.52f, 67.32f,8.12f);
        Location loc5=new Airport("AeroportIasi", 40.78f, 62.34f,4);
        Location loc6=new Airport("AeroportBacau", 24.68f, 35.28f,2);
        Location loc7=new TrainStation("GaraPiatra", 25.12f, 45.62f,4);
        Location loc8=new TrainStation("GaraIasi", 31.72f, 88.62f,10);

        Road r1=new Road(RoadType.EXPRESS,loc1,loc3,145f,100f);
        Road r2=new Road(RoadType.EXPRESS,loc1,loc2,120f,100f);
        Road r3=new Road(RoadType.EXPRESS,loc3,loc4,165f,100f);
        Road r4=new Road(RoadType.EXPRESS,loc4,loc7,200f,100f);
        Road r5=new Road(RoadType.EXPRESS,loc7,loc8,110f,100f);

        Description firstProblem=new Description();
        firstProblem.addLocation(loc1);
        firstProblem.addLocation(loc2);
        firstProblem.addLocation(loc3);
        firstProblem.addLocation(loc4);
        firstProblem.addLocation(loc5);
        firstProblem.addLocation(loc6);
        firstProblem.addLocation(loc7);
        firstProblem.addLocation(loc8);

        firstProblem.addRoad(r1);
        firstProblem.addRoad(r2);
        firstProblem.addRoad(r3);
        firstProblem.addRoad(r4);
        firstProblem.addRoad(r5);

        firstProblem.setStart(loc1);
        firstProblem.setFinish(loc8);

        System.out.println(firstProblem.existRoadBetweenLocations());

        //firstProblem.setStart(loc1);
        //firstProblem.setFinish(loc5);

       // System.out.println(firstProblem.existRoadBetweenLocations());
    }
}