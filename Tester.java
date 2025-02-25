public class Tester {
    public static void main(String[] args){
        Person a = new Person(5,7);
        Person b = new Person(2, 0);
        Person c = new Person(3, 24);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        Car JBLTOYOTATUNDRA = new Car(9, 5);
        System.out.println(JBLTOYOTATUNDRA);
        JBLTOYOTATUNDRA.addPassenger(a);
        System.out.println(JBLTOYOTATUNDRA);
        System.out.println(JBLTOYOTATUNDRA.unload());
    }
    
}
