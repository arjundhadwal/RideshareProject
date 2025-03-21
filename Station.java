import java.util.*;
public class Station {
    //fields
    private ArrayList<Person> waitingLeft;
    private ArrayList<Person> waitingRight;
    private ArrayList<Person> completed;
    private int number; //station ID
    private int passengersCompleted;

    public Station(int myNumber){
        number = myNumber;
        waitingLeft = new ArrayList<Person>();
        waitingRight = new ArrayList<Person>();
        completed = new ArrayList<Person>();
        passengersCompleted = 0;
    }

    public void addPerson(Person p){
        if(p.getDestination() == number){
            completed.add(p);
            passengersCompleted++;
        } else if (p.getDirection()){
            waitingRight.add(p);
        } else {
            waitingLeft.add(p);
        }
    }

    /**
     * Gets and removes the next person available in the left queue.
     * @return The next available passenger going left, kicked off the list once returned.
     */
    public Person nextLeft(){
        if(waitingLeft.size()>0 && waitingLeft.get(0)!=null){
            return waitingLeft.remove(0);
        } else {
            System.out.println("No one to return in nextLeft");
            return null;
        }
    }
    /**
     * Gets the next person in the right queue.
     * @return The next available passenger going left.
     */
    public Person getNextLeft(){
        if(waitingLeft.size()>0 && waitingLeft.get(0)!=null){
            return waitingLeft.get(0);
        } else {
            return null;
        }
    }
    /**
     * Gets and removes the next person available in the right queue.
     * @return The next available passenger going right, kicked off the list once returned.
     */
    public Person nextRight(){
        if(waitingRight.size()>0 && waitingRight.get(0)!=null){
            return waitingRight.remove(0);
        } else {
            System.out.println("No one to return in nextRight");
            return null;
        }
    }
    /**
     * Gets the next person in the right queue.
     * @return The next available passenger going right.
     */
    public Person getNextRight(){
        if(waitingRight.size()>0 && waitingRight.get(0)!=null){
            return waitingRight.get(0);
        } else {
            return null;
        }
    }
    /**
     * toString returns a string of the station's queues plus the passengers inside them.
     * @return A string representation of the station.
     */
    public String toString(){
        String s = "Station: "+number+"\n";
        s+= "Leftbound:  "+waitingLeft.toString()+"\n";
        s+="Rightbound: "+waitingRight.toString()+"\n";
        s+="Completed:  "+completed.toString();
        return s;
    }
    /**
     * Gets the count of passengers in the Completed list
     * @return passengers who have arrived at this station as their destination
     */
    public int getPassCompleted(){
        return passengersCompleted;
    }
}
