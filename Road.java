import java.util.ArrayList;
public class Road {
    
//fields
private ArrayList<Station> road; //the BIG BOY arraylist
private int numPassengers;
private int numCars;
private int numStations;

private ArrayList<Passenger> TotPass;
private ArrayList<Car> TotCar;

//constructors
public Road(int myNumPassengers,int myNumCars, int myNumStations){
    road = new ArrayList<Station>();
    TotPass = new ArrayList<Passenger>();
    TotCar = new ArrayList<Car>();
    
    numPassengers = myNumPassengers;
    numCars = myNumCars;
    numStations = myNumStations;
    
    
    createPassengers();
    createCars(); 
    createStations(); //to do
    
}



//methods

//need this
public void run(){
    for(int k = 0; k < road.size(); k++){
        road.get(k).updateCars();
    }
    }

public void updateCars(){ //this moved the car along, the actull intricate stuff is done in the update cars file in the station class
    for(int i = 0; i < road.size(); i++){ //for all the stations
        for(int j = 0; j < road.get(i).getCars().size(); j++){ //for all the cars at each station
            road.get(i).getCars().get(j).changeLoc(); //move the car to the right or left
            
            if(road.get(i).getCars().get(j).getLocC() < 0){  //if the loc is less then zero
            road.get(road.size() - 1).addCars(road.get(i).getCars().get(j)); //in the right most station, add the car the just went off to the left 
            }
            else if(road.get(i).getCars().get(j).getDirection()){ //if its going left, but its not all the way at zero
                road.get(i - 1).addCars(road.get(i).getCars().get(j)); //add the car to the  station firectly to its right
                road.get(i).getCars().remove(j); //remove that car from the list of cars AT THE PREV STATION
            }
            else if(road.get(i).getCars().get(j).getDirection() == false){ //rightbound
                road.get(i + 1).addCars(road.get(i).getCars().get(j)); 
                road.get(i).getCars().remove(j);
            }
    }
        road.get(i).updateCars(); //calls the function(in the stationfile) for each station
}
}


public void createPassengers(){
    for(int i = 0; i < numPassengers; i++){ //for all the passengers
        int start = (int)(Math.random() * numStations); //put them somehwere amoung the stations
        int dest = (int)(Math.random() * numStations); //put thier goal osmehwere amoung the stations
        
        Passenger a = new Passenger(start, dest);
        TotPass.add(a);
    
        for(int j = 0; j < road.size(); j++){ //for all the stations
        for(int k = 0; k < TotPass.size(); k++){ //for all the passengers 
        if(TotPass.get(k).getStartPass() == road.get(j).getStationID()){ //if the start == the corrct sttion id
            road.get(j).addPtoPPLWaiting(TotPass.remove(k)); //add the person to the ppl waiting list at that station while also removing them from the totpass list, 2 for 1 speciall!!!!
            k--; //for the idex error
        }
}
}
    }
}



public void createCars(){
    for(int i = 0; i < numCars; i++){
        int start = (int) (Math.random() * numStations);
        int dest = (int) (Math.random() * numStations);
        Car a = new Car(start,dest);
        TotCar.add(a);
    }
    for(int j = 0; j < road.size(); j++){ //for all the stations
        for(int k = 0; k < TotCar.size(); k++){ //for all the cars
        if(TotCar.get(k).getLocC() == road.get(j).getStationID()){ //if the location of the car is the same as the station 
            road.get(j).addCars(TotCar.remove(k)); //romove cars from the total cars and put it in the station
            k--; //index
            }
        }
        }
    }

    public void createStations(){
        for(int i = 0; i < numStations; i++){//for all the stations
            Station a = new Station();
            road.add(a);
        }
    }



    public String toString(){
    String fin = "";
    for(int i = 0; i < road.size(); i++){
            fin += road.get(i).toString() + " ";
        }
    return fin;
    }
            

}
