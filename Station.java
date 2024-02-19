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
    
    public void emptyPassengers(){
        for(int i = 0; i < cars.size(); i++){ //for all the cars...
        int locationC = cars.get(i).getLocC(); //the cars location is
            for(int j = 0; j < cars.get(i).getPassangerList().size(); j++){ //run through the list of passengers in the car
            int DestPass = cars.get(i).getPassangerList().get(j).getDestPass(); //the passengers dest is
                if(locationC == DestPass){ //if the location == the destination
                    PPLwaiting.add(cars.get(i).getPassangerList().get(j)); //add the person to the ppl waiitng list
                    cars.get(i).getPassangerList().remove(cars.get(i).getPassangerList().get(j)); //remove them from the car
                }
            }
        }
    }
    


}
