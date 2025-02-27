import java.util.*;
public class Simulator { //the main class that contains everything

    //fields
    private ArrayList<Station> stations = new ArrayList<Station>();

    //constructors
    public Simulator(){
        for(int i = 0; i<32; i++){
            Station s = new Station(i);
            stations.add(s);
        }
    }
}
