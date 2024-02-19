public class Passenger {
    //feilds
    private int start;
    private int dest;
    private static int idGen;
    private int idNum;
    private boolean isInCar;
    private boolean isAtDest;



//construcrtor
public Passenger(int myStart, int myDest){
    start = myStart;
    dest = myDest;
    isInCar = false;
    idNum = idGen;
    idGen++;
    isAtDest = false;
}

//methods

public int getStartPass(){
    return start;
}

public int getDestPass(){
    return dest;
}

public boolean getIsInCar(){
    return isInCar;
}

public void putInCar(){
    isInCar = true;
}

public void removefromCar(){
    isInCar = false;
}

public int getIdNum(){
    return idNum;
}

public void AtDest(){
    isAtDest = true;
}

public String toString(){
    return "Passenger ID: " + idNum + " Passenger Destination: " + dest+ " Are they at their Destination? " + isAtDest;
}

}
