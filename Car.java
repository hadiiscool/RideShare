import java.util.ArrayList;
public class Car {
    


    //fields
    private static int idGen;
    private int idNum;
    private int location;
    private int destinaton;
    private double balance;
    private boolean isMovingleft;
    private boolean isMovingright;
    private ArrayList<Passenger> people; 
    
    //constructors
    public Car(int myLocation, int myDestinaton){
        people = new ArrayList<Passenger>();
        location = myLocation;
        destinaton = myDestinaton;
        idNum = idGen;
        idGen++;
        
        balance = 0.0;
        if(destinaton < location){
            isMovingleft = true;
            isMovingright = false;
        }
        else{
            isMovingleft = false;
            isMovingright = true;
        }
    }

    //methods

    //getters
    public ArrayList<Passenger> getpassangerlist(){
        return people;//retnrs this array list, still need to add ppl to it
    }

}

   