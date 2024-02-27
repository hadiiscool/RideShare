import java.util.ArrayList;
public class Station {
    //this is second-to-top in order of opperations, the road file will take into considersation overthing else

    //fields
    public int balance; //so the road class can use this
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

    public void loadPassengers(){
        if(cars.size() > 0){ //need this check for some rzn
        for(int i = 0; i < PPLwaiting.size(); i++){ //for all the ppl wiating
            for(int j = 0; j < cars.size(); j++){ //for all the cars
                if(cars.get(j).getNumOfPass() < 3){ //if the num of passengers is less then 3...
                    if(cars.get(j).getDirection() == false){ //and the car is going right//
                        if(PPLwaiting.get(i).getDestPass() > cars.get(j).getLocC()){ // and if the poeple in the car's desitnation is GREATOR then the cars location
                            cars.get(j).addPassenger(PPLwaiting.remove(i)); //remove the passenger from the PPLwaiting list while also adding adding the passenger to the car. 2 for one mehtod special!!!
                            i--; // to avoid index error
                            break;// to avoid index error
                        }
    
                    } else if(cars.get(j).getDirection() == true){ //ifs the car is going left
                            if(PPLwaiting.get(i).getDestPass() < cars.get(j).getLocC()){ //if the persons destinagion is less then the cars position
                                cars.get(j).addPassenger(PPLwaiting.remove(i)); //another 2 for one special
                                i--;  //index error stuff
                                break; //index error stuff
                            }
                    }
                }
            }
        }
    }
}

//getters
public ArrayList<Car> getCars(){
    return cars;
}

public int getStationID(){
    return StationID;
}

//mutators
public void addCars(Car x){
    cars.add(x);
}

public void updateCars(){ //order mattters here
    emptyPassengers();
    elimCars();
    loadPassengers();
}

//prints

public String printCars(){
    String fin = "";
    for(int j = 0; j < cars.size(); j++){ //for all the cars
        fin += cars.get(j).toString();
        fin += "";
    }

    return fin;
}


public String printCompletedPassengers(){
    String fin = "";
    for(int j = 0; j < PPLwaiting.size(); j++){ //for all the pplwating
        if(PPLwaiting.get(j).getDestPass() == StationID){ //if they are at correct station(which is also thier destination)
            fin +=  PPLwaiting.get(j);
        }
}
return fin;
}

public void addToBalance(){ 
    for(int j = 0; j < PPLwaiting.size(); j++){ //for all the pplwating
        if(PPLwaiting.get(j).getDestPass() == StationID){ //if they are at correct station(which is also thier destination)
            balance++; //add 1 to the ballence
        }
}
}
public int getBalance(){ 
    return balance;
}


public String toString(){
return "StationID: " + StationID +  " Cars[" + printCars() + " ] " + " Completed Passengers: [ " + printCompletedPassengers() + "]\n" ;


}

}






