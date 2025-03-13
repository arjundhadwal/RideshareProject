public class Person{
    //fields
    private boolean direction; //true = right, false = left
    private int destination; 
    private int startLoc;
    //constructors
    /**
     * The Person object. 
     * @param myDestination destination that the person is trying to reach
     * @param myStartingLoc starting location that the person starts from
     */
    public Person(int myDestination, int myStartingLoc){
        destination = myDestination;
        startLoc = myStartingLoc;
        direction = (destination>startLoc);
        }
    //methods
    /**
     * Returns the destination of the person.
     * @return the destination station number.
     */
    public int getDestination(){
        return destination;
    }
    /**
     * Returns the direction of the person.
     * @return true if going right, false if going left
     */
    public boolean getDirection(){
        return direction;
    }
    /**
     * Returns the starting location of the person.
     * @return Starting location (station #)
     */
    public int getStartLoc(){
        return startLoc;
    }
    /**
     * A string representation of the person.
     * 
     */
    public String toString(){
        return super.toString() + "Start:  " + startLoc + " Destination: " +destination + " Going right? "+ direction;
    }
}