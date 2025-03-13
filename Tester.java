public class Tester {
    public static void main(String[] args){
        final int NUMCYCLES = 10; //number of cycles or "ticks" in the simulator 
        Simulator s = new Simulator(); //Creating the simulator
        s.populate(10, 5); //creating 10 people and 5 cars
        for(int i = 0; i<NUMCYCLES; i++){ //looping the tick several times
            System.out.println("Cycle: "+i);
            s.tick();
            System.out.println(s.toString());
        }
    }
    
}
