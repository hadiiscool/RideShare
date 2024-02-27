import java.util.ArrayList;
public class Car {
    


    //fields
    private static int idGen;
    private int idNum;
    private int location;
    private int destination;
  
    private boolean isMovingleft;
    private boolean isMovingright;
    private ArrayList<Passenger> people; 
    
    //constructors
    public Car(int myLocation, int myDestination){
        people = new ArrayList<Passenger>();
        location = myLocation;
        destination = myDestination;
        idNum = idGen;
        idGen++;
        
        
        if(destination < location){
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
    public ArrayList<Passenger> getPassangerList(){
        return people;//retnrs this array list, still need to add ppl to it
    }

    public int getNumOfPass(){
        int total = 0;
        for(Passenger x : people){ //for each loop, no mutating required so this is fine
            total++;
        }
    return total;
    }

    public int getID(){
        return idNum;
    }

    public int getLocC(){
        return location;
    }
    
    public int getDestC(){
        return destination;
    }


    public boolean getDirection(){
        return isMovingleft; //when i need this Ill just write a if statemt, so this way i only need 1 varaible
    }

    //mutators

public void addPassenger(Passenger x){
    people.add(x);
}

public void changeLoc(){
    if(getDirection() == true){ //if its going left...
    location--;
    }
    else{
    location++;
    }
}


    
//printor
public String printDirection(){
    String fin = "";
    
    if(isMovingleft == true){
        fin += "Left";
    }
    else{
        fin += "Right";
    }
return fin;

}



public String toString(){
    return "[Car ID: " + idNum + " Direction: " + printDirection() + " ] ";
}
}

   