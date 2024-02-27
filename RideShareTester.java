public class RideShareTester {
    public static void main (String [] args){
    


    System.out.println();
    System.out.println("establishing a road with 10 passengers, 5 cars, and 5 stations... ");
    Road T1 = new Road(10, 5, 5);
    System.out.println(T1.toString());
    
    System.out.println();
    
    System.out.println("updating...");
    System.out.println();
    
    T1.run();
    System.out.println(T1.toString());

    System.out.println("updating...");
    System.out.println();
    
    T1.run();
    System.out.println(T1.toString());
    System.out.println();
    System.out.println();


    }
}