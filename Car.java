import java.util.*;
public class Car {
    //fields
    private int destination;
    private int currentLocation;
    private boolean direction;
    private ArrayList<Person> passengers;

    //constructor
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
            if(p.getDirection() == direction){
            passengers.add(p);
            } else {
                System.out.println("ERROR: person being added in wrong direction");
            }
        }
     }
     public boolean hasRoom(){
        return passengers.size()<3;
     }
}
