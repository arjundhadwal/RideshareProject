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

    public String toString(){
        return super.toString()+" Destination: " + destination + " Current location: " + currentLocation + " Going right? " + direction + " Passengers: " + passengers;
     }

     public void addPassenger(Person p){
        if(passengers.size() >= 3){
            System.out.println("Error, no room");
        } else {
            if(p!=null && p.getDirection() == direction){
            passengers.add(p);
            } else {
                System.out.println("ERROR: person being added in wrong direction");
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
      * Kicks passengers onto the station even if it is not their destination. Must be executed thrice.
      * @return one kicked passenger
      */
     public Person forceUnload(){
        if(passengers.size()>0){
        return passengers.remove(0);
        } else {
            return null; //avoiding an error here?
        }
     }

     public boolean hasRoom(){
        return passengers.size()<3;
     }

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
     public int getLocation(){
        return currentLocation;
     }

     public boolean getDirection(){
        return direction;
     }

     public boolean isAtDestination(){
        return currentLocation == destination;
     }
        
     }

