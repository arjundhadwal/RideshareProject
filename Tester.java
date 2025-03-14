import java.util.*;
public class Tester {
    public static void main(String[] args){ //The main method runs a loop to optimize number of cars to passengers completed.
    Scanner input = new Scanner(System.in);
    System.out.println("Input the lower limit of the number of cars to optimize"); //Scanning for custom parameters
    int carTestRange_LOW = input.nextInt();
    System.out.println("Input the upper limit of the number of cars to optimize");
    int carTestRange_HIGH = input.nextInt();
    System.out.println("Input # of passsengers to spawn");
    int numpass = input.nextInt();
    double maximumValue = 0;
    int carsatMaximumValue = 0;
    for(int i = carTestRange_LOW; i<=carTestRange_HIGH; i++){ //looping through simulations and saving values when appropriate
        double test = runTrial(64, numpass, i);
        if(test>maximumValue){
            maximumValue = test;
            carsatMaximumValue = i;
        }
        System.out.println("Ran test with "+i+" cars, passengers transported per car equals "+test+" with "+numpass+" passengers in the simulation");
    }
    System.out.println("Most ideal number of cars = "+carsatMaximumValue+" transporting "+maximumValue+" passengers per car.");
    input.close();
    }
    /**
     * Method to run a simulation repeatedly for use in a loop to optimize number of cars
     * @param cycles number of "ticks" in every simulatioon
     * @param numPassengers the amount of passengers to spawn (usually constant)
     * @param numCars the amount of cars to be spawned (run a loop to optimize)
     * @return the double value representing how many passengers get successfully transported per car
     */
    public static double runTrial(int cycles, int numPassengers, int numCars){
        int NUMCYCLES = cycles; //number of cycles or "ticks" in the simulator 
        Simulator p = new Simulator(); //Creating the simulator
        p.populate(numPassengers, numCars); //creating 10 people and 5 cars
        for(int i = 0; i<NUMCYCLES; i++){ //looping the tick several times
            System.out.println("Cycle: "+i);
            p.tick();
        }
        double pc = p.passCompletedPerCar();
        System.out.println(pc+" passengers succesfully transported per car @ "+numCars+" cars and"+numPassengers+" passengers");
        return pc;
    }
    
}
