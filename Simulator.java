import java.util.*;
public class Simulator { //the main class that contains everything

    //fields
    private ArrayList<Station> stations = new ArrayList<Station>();
    private ArrayList<Car> cars = new ArrayList<Car>();

    //constructors
    /**
     * This is the simulator object. It contains everything that runs the Rideshare project and all methods relating to the project run through Main are attached to this object alone.
     * There are 32 stations, with indexes 0-31.
     * @param carCount The amount of cars to start with. Cars are held inside the Simulator class.
     */
    public Simulator(int carCount){
        for(int i = 0; i<32; i++){
            Station s = new Station(i);
            stations.add(s);
        }
        for(int j = 0; j<carCount; j++){
            Car c = new Car((int)(Math.random()*32.0),(int)(Math.random()*32.0));
            cars.add(c);
        }
    }

    //methods
    /**
     * Loads and unloads passengers appropriately.
     */
    public void updatePassengers(){

    }
    /**
     * Moves all cars one step in their direction.
     */
    public void moveCars(){
        for(Car c:cars){
            c.move();
        }
    }
}
