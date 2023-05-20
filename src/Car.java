package FinalProject;

import java.math.BigDecimal;
import java.math.MathContext;

//subclass that inherits from the abstract class vehicles
public class Car extends Vehicles{
	//attributes of the class
private int numOfSeats;
private boolean airConditionON = false ;
	//no-arg constructor
	public Car() {
		this("","","","",0,0,new Owner(),0,false);
	}
//constructor that takes arguments
	public Car(String modelName, String modelNo, String brand, String engineType, double tunkSize,double fuelConsumption, Owner owner,int numOfSeats, boolean airConditionON) throws IllegalArgumentException {
		super(modelName,modelNo,brand,engineType,tunkSize,fuelConsumption,owner);
		
				this.numOfSeats = numOfSeats;
		this.airConditionON = airConditionON;
		
	}
   // overriden method that prints the cost for 100kms 
	@Override
	public double costfor100Km(PetroleumType type) {
		

		cost = ((100/fuelConsumption) * PetroleumType.getGasolinePrice());
		
		
		return cost;
	}
     // overriden method that is from abstract class that turnes air conditioning on
	@Override
	public void setAirConditionON() {
        if (isAirConditionON() == false) {
        	airConditionON = true;
        	fuelConsumption = getFuelConsumption() - (getFuelConsumption() * 0.1);
        }
        else
		airConditionON = true;	
        
	} 
     
	// overriden method that is from abstract class that turnes air conditioning off
    @Override
	public void setAirConditionOff() {
    	if (isAirConditionON() == true) {
    		fuelConsumption = (getFuelConsumption())/0.9 + (getFuelConsumption()  * 0.1);
    		airConditionON = false;
    	}
    	else 
    		airConditionON = false;
	}


    // setters and getters for the attributes
	public int getNumOfSeats() {
		return numOfSeats;
	}


//setter for numOfSeats
	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}


//getter for airconditionON
	public boolean isAirConditionON() {
		return airConditionON;
	}


//setter for airconditionON
	public void ssetAirConditionON(boolean airConditionON) {
		this.airConditionON = airConditionON;
	}


    // to string that coverts the info to strings
	@Override
	public String toString() {
		PetroleumType type = new PetroleumType();
		return "=====CAR=====" + super.toString() + " NUMBEROFSEATS = " + numOfSeats + " AIRCONDITION = " + airConditionON + " COSTFOR100KM =  " + costfor100Km(type) + "NIS";
	}

	public void mymethod() {//extra method that determines the type of the car
		if ( numOfSeats < 2) {
			System.out.println("this car is a race car");
			
		}
		else if (numOfSeats > 2 || numOfSeats < 5) {
			System.out.println("this car is a regular car or small SUV");

		}
		else if(numOfSeats > 5 || numOfSeats < 8) {
			System.out.println("this car is a big SUV");
		}
		
	}
	
	
	
	
}
