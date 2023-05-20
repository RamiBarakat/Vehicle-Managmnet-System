package FinalProject;
//truck is a subclass from the abstract class vehicles 
public class Truck extends Vehicles{
	//here is the attributes of this class
private boolean airConditionON = false;
private int power;
private int numberOfSeats;
//no arg constructor 
public Truck() {
	this("","","","",0,0,new Owner(),false,0,0);
}
// argument constructor that passes some parameters to the super class
	public Truck(String modelName, String modelNo, String brand, String engineType, double tunkSize,double fuelConsumption, Owner owner,boolean airConditionON, int power, int numberOfSeats) {
	super(modelName,modelNo,brand,engineType,tunkSize,fuelConsumption,owner);	
	this.airConditionON = airConditionON;
	this.power = power;
	this.numberOfSeats = numberOfSeats;
}
    
	// the costfor100km method which is abstract in vehicles thats why its overrides it calculates the cost when air conditioning is off as well as on and shows how fuel consumption changes
	@Override
	public double costfor100Km(PetroleumType type) {
		
		
		cost = ((100/fuelConsumption) * PetroleumType.getDieselPrice());
		
	
		return cost;
	}
	
    //overriden method that sets the air conditioing on(abstract method in superclass)
	@Override
	public void setAirConditionON() {
		if (isAirConditionON() == false) {
	    	airConditionON = true;
	    	fuelConsumption = getFuelConsumption() - (getFuelConsumption() * 0.2);
	    }
	    else
		airConditionON = true;	
     
	}
    
	// method to turn of the air conditioning which primarily exists in the superclass
	@Override
	public void  setAirConditionOff() {
		if (isAirConditionON() == true) {
			fuelConsumption = (getFuelConsumption())/0.8 + (getFuelConsumption()  * 0.2);
			airConditionON = false;
		}
		else 
			airConditionON = false;	
	}
   //getter for airconditionON
	public boolean isAirConditionON() {
		return airConditionON;
	}
//setter for airconditionon
	public void ssetAirConditionON(boolean airConditionON) {
		this.airConditionON = airConditionON;
	}
//getter for power
	public int getPower() {
		return power;
	}
//setter for power
	public void setPower(int power) {
		this.power = power;
	}
//getter for number of seats
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
//setter for number of seats
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
    // to string that converts all the info to string so we can print it
	@Override
	public String toString() {
		PetroleumType type = new PetroleumType();
		return "=====TRUCK=====" + super.toString() + "AIRCONDITION: " + airConditionON + ", POWER = "  + power + ", NUMBEROFSEATS= " + numberOfSeats  
			+"COSTFOR100KM = " + costfor100Km(type)    + "NIS";
	}

	public void mymethod5() {
		//we find the  kilowatts according to power
		double kilowatts = power * 0.746;
		System.out.println("the power in kilowatts is " + kilowatts);
		
	}
	
	
	
}
