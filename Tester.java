public class Tester {
    public static void main(String[] args){
        Simulator s = new Simulator(); //Creating the simulator
        s.populate(10, 5); //creating 10 people and 5 cars
        for(int i = 0; i<32; i++){ //looping the tick several times
            System.out.println("Cycle: "+i);
            s.tick();
            System.out.println(s.toString());
        }
    }
    
}
