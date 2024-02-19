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
    
    
    createPassengers();//to do
    createStations(); //to do
    createCars(); //to do
}



//methods

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







}
