import java.util.ArrayList;
public class Station {
    //this is second-to-top in order of opperations, the road file will take into considersation overthing else

    //fields

    private ArrayList<Car> cars;
    private int StationID;
    private static int StationNumGen;
    private ArrayList<Passenger> PPLwaiting; //makes an array list of the people not in cars who are waiting


    //order of opperations: empty passengers in cars that are at thier destination, eliminaate cars that have reached dest, Put all passengers waiting in cars
    public Station(){
        cars = new ArrayList<Car>();
        PPLwaiting = new ArrayList<Passenger>();
        StationID= StationNumGen;
        StationNumGen++;
    }

    //methods
    public void addPtoPPLWaiting(Passenger x){
        PPLwaiting.add(x);
    }

    public void elimCars(){
        for(int i = 0; i < cars.size(); i++){
        int Position = cars.get(i).getLocC();
    
            if((Position == StationID) && (Position == cars.get(i).getDestC())){ //if the car is at the station and if the car is at its final dest...

            for(int j = 0; j < cars.get(i).getPassangerList().size(); j++){
                PPLwaiting.add(cars.get(i).getPassangerList().get(j)); //add pasengers in the eliminated car to the PPLwaiting list
            }
            cars.remove(i); //this has to be after the previous for loop
            } 
            }
    }
    
    


}
