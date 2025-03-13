import java.util.*;
public class Car {
    //fields
    private int destination;
    private int currentLocation;
    private boolean direction;
    private ArrayList<Person> passengers;

    //constructor
    /**
     * Constructor for a car. Each Car contains an array list of passengers, a destination, and a current location.
     * @param myDest the destination station of the car
     * @param start the point where the car starts
     */
    public Car(int myDest, int start){
        destination = myDest;
        currentLocation = start;
        direction = destination > currentLocation;
        passengers = new ArrayList<Person>();
    }
    /**
     * A string representation of the Car, showing its location, destination, and contained passengers
     */
    public String toString(){
        return super.toString()+" Destination: " + destination + " Current location: " + currentLocation + " Going right? " + direction + " Passengers: " + passengers;
     }
     /**
      * Adds a passenger into the car. It automatically checks that the car has room and is traveling the correct way for the passenger.
      * @param p The person to be added into the car.
      */
     public void addPassenger(Person p){
        if(p!=null){
        if(passengers.size() >= 3){
            System.out.println("Error, no room");
        } else if (p!=null) {
            if(p.getDirection() == direction){ //failing this every time?
            passengers.add(p);
            } else {
                System.out.println("ERROR: person being added in wrong direction");
            }
        }
    }
     }
     /**
      * Method for handing back a person that is eligible to be dropped off at any station. 
      * This removes the person from the car as well.
      * There may be multiple people eligible for drop off, but this only returns the first one.
      * You may need to run this up to three times if all passengers are eligible to be dropped off.
      * @return the passenger unloaded, or null if no pass. available
      */
     public Person unload(){
        for(int i = 0; i<passengers.size(); i++){ // loop thru list
            Person a = passengers.get(i);
            if (a.getDestination() == currentLocation){
                return passengers.remove(i);
            }
        }
        return null;
     }
     /**
      * Kicks passengers onto the station even if it is not their destination. Repeat execution of this command
      may be necesssary if the car has more than one passenger.
      This method is intended to be used when a car reaches its destination before a passenger.
      * @return one kicked passenger
      */
     public Person forceUnload(){
        if(passengers.size()>0){
        return passengers.remove(0);
        } else {
            return null; //avoiding an error here?
        }
     }
     /**
      * Checks if the car has room inside.
      * @return true if the car has space, false if it is full
      */
     public boolean hasRoom(){
        return passengers.size()<3;
     }
     /**
      * Moves the car in the direction towards its destination. The method kicks you out early (no errors) if the car is already at its destination.
      */
     public void move(){
        if(currentLocation == destination){
            return; //kicks you out of the method early 
        }
        if(direction){
            currentLocation++;
        } else {
            currentLocation--;
        }
     }
     /**
      * Finds the current location of the car at stations 0-31.
      * @return The car's location
      */
     public int getLocation(){
        return currentLocation;
     }
     /**
      * Finds the car's direction going right or left on the road.
      * @return True if going right, false if going left
      */
     public boolean getDirection(){
        return direction;
     }
     /**
      * Checks if the car is at its destination.
      * @return True if the car is at its destination, false otherwise
      */
     public boolean isAtDestination(){
        return currentLocation == destination;
     }
     /**
      * Returns the number of passengers inside the car.
      * @return
      */
     public int numPassengers(){
        return passengers.size();
     }
        
     }

