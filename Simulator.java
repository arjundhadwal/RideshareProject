import java.util.*;
public class Simulator { //the main class that contains everything

    //fields
    private Station[] stations;
    private ArrayList<Car> fleet = new ArrayList<Car>();
    private static final int NUMSTATIONS = 32;

    //constructors
    /**
     * This is the simulator object. It contains everything that runs the Rideshare project and all methods relating to the project run through Main are attached to this object alone.
     * There are 32 stations, with indexes 0-31.
     * @param carCount The amount of cars to start with. Cars are held inside the Simulator class.
     */
    public Simulator(int carCount){
        stations = new Station[NUMSTATIONS];
        for(int i = 0; i<NUMSTATIONS; i++){
            Station s = new Station(i);
            stations[i] = s;
        }
        for(int j = 0; j<carCount; j++){
            Car c = new Car((int)(Math.random()*32.0),(int)(Math.random()*32.0));
            fleet.add(c);
        }
    }

    //methods
    /**
     * Loads and unloads passengers appropriately.
     */
    public void updatePassengers(){

    }

    public void populate(int numpeople, int numCars){
        for(int i = 0; i<numpeople; i++){
            int initialPos =  (int)(Math.random()*32);
            int destination = (int)(Math.random()*32);
            stations[initialPos].addPerson(new Person(destination, initialPos));
        }
        for(int i = 0; i<numCars; i++){
            int initialPos2 =  (int)(Math.random()*32);
            int destination2 = (int)(Math.random()*32);
            fleet.add(new Car(destination2, initialPos2));
        }
    }
    /**
     * Moves and updates stuff
     */
    public void tick(){
        //unload all people from cars
        for(Car c: fleet){
            Person p = c.unload(); //null if no passengers
            while(true){
            if(p != null){
                stations[c.getLocation()].addPerson(p);
            } else {
                break;
            }
        }
    }
        //load all people to cars
        for(Car c:fleet){
            if(c.getDirection()){
                if(stations[c.getLocation()].nextRight() != null){
                    c.addPassenger(stations[c.getLocation()].nextRight());
                }
            } else {
                if(stations[c.getLocation()].nextLeft() != null){
                    c.addPassenger(stations[c.getLocation()].nextLeft());
                }
            }
        }
        //move all the cars
        for(Car c:fleet){
            c.move();
        }
    }

    /**
     * Returns a string of all cars and stations
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
