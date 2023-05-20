package FinalProject;

//a subclass from the abstract class vehicles 
public class Minivan extends Vehicles{
	// attributes of the class
private int numOfSeats;
private boolean airConditionON = false;
private boolean hasAutoDoors;

//no-arg constructor that passes nothing
public Minivan() {
	this("","","","",0,0,new Owner(),0,false,false);
	
}
// arg constructor that passes attributes to the super class 
public Minivan(String modelName, String modelNo, String brand, String engineType, double tunkSize,double fuelConsumption, Owner owner,int numOfSeats, boolean airConditionON, boolean hasAutoDoors) {
	super(modelName,modelNo,brand,engineType,tunkSize,fuelConsumption,owner);
	this.numOfSeats = numOfSeats;
	this.airConditionON = airConditionON;
	this.hasAutoDoors = hasAutoDoors;
}



//method to find the cost for 100 kms depending on the air conditioning if on or off
@Override
public double costfor100Km(PetroleumType type) {
	//if air condition is on fuel consumption increases by 20%	
	//a minivan can take the two petrol types
	//takes diesel we take the diesel price

	//if it takes gasoline we take the price of gasoline
	
	if (engineType.equalsIgnoreCase("diesel")) {	
	   cost = ((100/fuelConsumption) * PetroleumType.getDieselPrice());
}
	//if it takes gasoline we take the price of gasoline
	else if(engineType.equalsIgnoreCase("gasoline")) {
		cost = ((100/fuelConsumption) * PetroleumType.getGasolinePrice());
	}
	
	return cost;
}
	
	
	
	
//overriden method that turns the air conditioning on	
@Override
public void setAirConditionON() {
	if (isAirConditionON() == false) {
    	airConditionON = true;
    	fuelConsumption = getFuelConsumption() - (getFuelConsumption() * 0.2);
    }
    else
	airConditionON = true;	
}
//overriden method that turns the air conditioning off
@Override
public void setAirConditionOff() {
	if (isAirConditionON() == true) {
		fuelConsumption = (getFuelConsumption())/0.8 + (getFuelConsumption()  * 0.2);
		airConditionON = false;
	}
	else 
		airConditionON = false;
}
//setters and getters for the attributes of this class
public int getNumOfSeats() {
	return numOfSeats;
}
//setter for number of seats
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
//getter for hasAutoDoors
public boolean isHasAutoDoors() {
	return hasAutoDoors;
}
//setter for hasAutoDoors
public void setHasAutoDoors(boolean hasAutoDoors) {
	this.hasAutoDoors = hasAutoDoors;
}
// to string method to convert info to string
@Override
public String toString() {
	PetroleumType type = new PetroleumType();
	return "=====Minivan===== " + super.toString() +  " NUMOFSEATS = " + numOfSeats + ", AIRCONDITION = " + airConditionON + ", AUTODOORS = " + hasAutoDoors
			+ " COSTFOR100KM = " + costfor100Km(type) +  "NIS";
}

public void mymethod1() {//an extra method that defines the type of a minivan
 if ( hasAutoDoors == true && numOfSeats > 6) {
	 
	 System.out.println("this is a mini bus");
 }
	
 else if (hasAutoDoors == true && numOfSeats < 6) {
	 System.out.println("this is a luxury minivan");
 }
 else {
	 System.out.println("this is a regular minivan");
 }
 
}





}
