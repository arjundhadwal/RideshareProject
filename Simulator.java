import java.util.*;
public class Simulator { //the main class that contains everything

    //fields
    private Station[] stations;
    private ArrayList<Car> fleet;
    private static final int NUMSTATIONS = 32; //Number of stations to generate

    //constructors
    /**
     * This is the simulator object. It contains everything that runs the Rideshare project and all methods relating to the project run through Main are attached to this object alone.
     * There are 32 stations, with indexes 0-31. The constructor only spawns stations; the populate method must be used to add in passengers and cars.
     *
     */
    public Simulator(){
        fleet = new ArrayList<Car>();
        stations = new Station[NUMSTATIONS];
        for(int i = 0; i<NUMSTATIONS; i++){
            Station s = new Station(i);
            stations[i] = s;
        }
        System.out.println("Simulator initiated");
    }

    //methods
    /**
     * Unloads passengers appropriately upon a car reaching its destination. This method is used to kick passengers out of the car so they don't get "stuck" inside the car before reaching their destination.
     */
    public void endOfTheLine(){
        for(Car c: fleet){
            if(c.isAtDestination()){
                for(int i = 0; i<c.numPassengers(); i++){
                    stations[c.getLocation()].addPerson(c.forceUnload());
                }
            }
        }
    }
    /**
     * This method spawns a specified amount of people and cars into the simulation, both having random starting points and destinations.
     * @param numpeople The amount of people to spawn.
     * @param numCars The amount of cars to spawn.
     */
    public void populate(int numpeople, int numCars){
        for(int i = 0; i<numCars; i++){
            int initialPos2 =  (int)(Math.random()*(double)NUMSTATIONS);
            int destination2 = (int)(Math.random()*(double)NUMSTATIONS);
            fleet.add(new Car(destination2, initialPos2));
        }
        for(int i = 0; i<numpeople; i++){
            int initialPos =  (int)(Math.random()*(double)NUMSTATIONS);
            int destination = (int)(Math.random()*(double)NUMSTATIONS);
            stations[initialPos].addPerson(new Person(destination, initialPos));
        }
        System.out.println("Successfully populated Simulator with people and cars");
    }
    /**
     * Unloads arriving passengers, loads departing passengers appropriately, checks for completed cars, and then moves the cars by one step. This is the simulator's "runner" method used in the tester.
     */
    public void tick(){
        //unload people from cars
        for(Car c: fleet){
            while(true){
            Person p = c.unload(); //null if no passengers
            if(p != null){
                stations[c.getLocation()].addPerson(p);
            } else {
                break;
            }
            }
    }
        //load people to cars
        for(Car c:fleet){
            if(c.getDirection()){
                if(stations[c.getLocation()].getNextRight() != null){
                    Person pToAdd = stations[c.getLocation()].nextRight();
                    System.out.println(pToAdd.toString()); //for debug purposes
                    c.addPassenger(pToAdd);
                }
            } else {
                if(stations[c.getLocation()].getNextLeft() != null){
                    Person pToAdd2 = (stations[c.getLocation()].nextLeft());
                    c.addPassenger(pToAdd2);
                }
            }
        }
        //check for completed cars, then move all the cars
        for(Car c:fleet){
             endOfTheLine();
            c.move();
        }
    }

    /**
     * Returns a string representation of the simulator, displaying the status of all people, cars, and stations.
     * @return A string representation of the Simulator.
     */
    public String toString(){
        String s = "";
        s+="Stations: \n";
        for(Station st:stations){
            s += st.toString();
            s += "\n";
        }
        s+="Cars: \n";
        for(Car c:fleet){
            s+=c.toString();
            s +="\n";
        }
        return s;
    }
}
