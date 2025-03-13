public class Tester {
    public static void main(String[] args){
        Simulator s = new Simulator();
        s.populate(10, 5);
        for(int i = 0; i<100; i++){
            s.tick();
            System.out.println(s.toString());
        }
    }
    
}
