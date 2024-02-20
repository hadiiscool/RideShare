public class RideShareTester {
    public static void main (String [] args){
    
    Road T1 = new Road(10, 5, 5);
    System.out.println(T1.toString());
    System.out.println();
    
    System.out.println("updating...");
    System.out.println();
    
    T1.run();
    System.out.println(T1.toString());
    }
}