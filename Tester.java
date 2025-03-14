import java.util.*;
public class Tester {
    public static void main(String[] args){ //The main method runs a loop to optimize number of cars to passengers completed.
    Scanner input = new Scanner(System.in);
    System.out.println("Input the lower limit of the number of cars to optimize. Recommended at least 5 so that the program does not use only one car to cut costs the most."); //Scanning for custom parameters
    int carTestRange_LOW = input.nextInt();
    System.out.println("Input the upper limit of the number of cars to optimize");
    int carTestRange_HIGH = input.nextInt();
    System.out.println("Input # of passsengers to spawn");
    int numpass = input.nextInt();
    double maximumValue = 0; //highest value of people per car
    int carsatMaximumValue = 0; //how many cars at best people per car
    int maxProfit = 0;
    int profit = 0; //profit value
    int carsatMaxProfit = 0;
    int carCost = 1; //cost of the car to operate
    int passengerRevenue = 2; //money gained from ferrying passengers to their station succesffully

    for(int i = carTestRange_LOW; i<=carTestRange_HIGH; i++){ //looping through simulations and saving values when appropriate
        double passcomp = runTrial(32, numpass, i);
        if((passcomp/(double)i)>maximumValue){
            maximumValue = passcomp/i;
            carsatMaximumValue = i;
        }
        profit = (int)passcomp*passengerRevenue - i*carCost;
        if(profit>maxProfit){
            maxProfit = profit;
            carsatMaxProfit = i;
        }
        System.out.println("Ran test with "+i+" cars, passengers transported per car equals "+passcomp/i+" with "+numpass+" passengers in the simulation");
        System.out.println(profit+" dollars earned");
        System.out.println();
    }
    System.out.println("Most efficient number of cars = "+carsatMaximumValue+" transporting "+maximumValue+" passengers per car.");
    System.out.println("Most profitable car count: "+carsatMaxProfit+" making $"+maxProfit+" for the rideshare company");
    input.close();
    }
    /**
     * Method to run a simulation repeatedly for use in a loop to optimize number of cars
     * @param cycles number of "ticks" in every simulatioon
     * @param numPassengers the amount of passengers to spawn (usually constant)
     * @param numCars the amount of cars to be spawned (run a loop to optimize)
     * @return the int value representing how many passengers get successfully transported
     */
    public static int runTrial(int cycles, int numPassengers, int numCars){
        int NUMCYCLES = cycles; //number of cycles or "ticks" in the simulator 
        Simulator p = new Simulator(); //Creating the simulator
        p.populate(numPassengers, numCars); //creating 10 people and 5 cars
        for(int i = 1; i<=NUMCYCLES; i++){ //looping the tick several times
            //System.out.println("Cycle: "+i);
            p.tick();
        }
        int pc = p.passCompletedTotal();
        System.out.println(pc+" passengers succesfully transported per car @ "+numCars+" cars and"+numPassengers+" passengers");
        return pc;
    }
    
}
