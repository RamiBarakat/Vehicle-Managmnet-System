package FinalProject;

import java.util.InputMismatchException;

// this is an abstract class which is the super class for all the other classes in this project which implements the interfaces comaparable and cloneable
public abstract class Vehicles implements Comparable<Vehicles>,Cloneable {
	// here we define the attributes of this class and notice an aggregation(composition) relation
	protected String modelName;
	protected String modelNo;
	protected String brand;
	protected String engineType;
	protected double tunkSize;
	protected double fuelConsumption;
	public Owner owner;
	protected double cost;
	// no-arg constructor
	public Vehicles	() {
		this("","","","",0,0,new Owner());
	}
	
	//constructor that takes arguments and passes them 
 public Vehicles(String modelName, String modelNo, String brand, String engineType, double tunkSize,double fuelConsumption, Owner owner) throws IllegalArgumentException {
		super();
		this.modelName = modelName;
		this.modelNo = modelNo;
		this.brand = brand;
		//here we use the setter so the exception can take action
		setEngineType(engineType);
		this.tunkSize = tunkSize;
		this.fuelConsumption = fuelConsumption;
		this.owner = owner;
	}

//abstract method which takes petroleumType as a parameter which calculates the cost for 100 kms and this must be implemented in all the sub classes
public abstract double costfor100Km(PetroleumType type);
	
	//a method that calculates the distance that a car can move with a full tank 
	public double movabledistance(){
	return tunkSize*fuelConsumption;	
	}
	
	// methods that is abstract that turn air conditioning on 
	public abstract void setAirConditionON();
	// methods that is abstract that turn air conditioning off
	public abstract void setAirConditionOff();

     // to string method to help print info as a string
	@Override
	public String toString() {
		return "MODELNAME: " + modelName + ", MODELNO: " + modelNo + ", BRAND: " + brand + ", ENGINETYPE: "
				+ engineType + ", TUNKSIZE:" + tunkSize + ", FUELCONSUMPTION = " + fuelConsumption + ", MOVABLE-DISTANCE: " + movabledistance() +"KM " +",OWNER NAME: " + getOwner() + ",";
	}

 //getter for getmodelname
	public String getModelName() {
		return modelName;
	}

//setter for nodelName
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

//getter for modelno
	public String getModelNo() {
		return modelNo;
	}

//setter for model no
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

//getter for brand
	public String getBrand() {
		return brand;
	}

//setter for brand
	public void setBrand(String brand) {
		this.brand = brand;
	}

//getter for enginetype
	public String getEngineType() {
		return engineType;
	}
	// engineType.equalsIgnoreCase("gasoline") || engineType.equalsIgnoreCase("diesel") || engineType.equalsIgnoreCase("hybrid") throw new IllegalArgumentException("the engine type is invalid"); 
     //here we throw an exception when engine type is invalid it throws it(type mismatch) ( illegal argument exception)
	public void setEngineType(String engineType) throws IllegalArgumentException {
		//this keyword refers to this class
		if(engineType.equalsIgnoreCase("gasoline") || engineType.equalsIgnoreCase("diesel") || engineType.equalsIgnoreCase("hybrid")){
			this.engineType = engineType;
		}
	    else
			//if the exception is catched it prints this statement
			throw new IllegalArgumentException ("the engine type is invalid"); 
	    
			}
	
	

//getter for tunk size
	public double getTunkSize() {
		return tunkSize;
	}

//setter for tunk size
	public void setTunkSize(double tunkSize) {
		this.tunkSize = tunkSize;
	}

//getter for fuelconsumption
	public double getFuelConsumption() {
		return fuelConsumption;
	}

//setter for fuelconsumption
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

//getter for owner
	public Owner getOwner() {
		return owner;
	}

//setter for owner
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
     
	//comppareTo method which is from the interface comparable that compares between the objects based on the cost for 100 kms
	@Override
	public int compareTo(Vehicles v) {
		//here we define a type petroleumtype
		PetroleumType p = new PetroleumType();
		if (costfor100Km(p) > v.costfor100Km(p) ) {
			return 1;
			//could be accessed using collections.sort
		}
			else if (costfor100Km(p) < v.costfor100Km(p)) {
				return -1;
			}
		
				else {
		         return 0;
				}
	}
	
	   //clone method which is from the interface cloneable that helps clone an object without mess or change with its actual information
		@Override
		public Object clone()throws CloneNotSupportedException {
			Vehicles veh =  (Vehicles)super.clone();
			//we set owner to null as requested
			veh.setOwner(null);
			
			//and we clone the object
	        return veh;
	
	}
	
	
	
	public void mymethod2() {
		
		if (movabledistance() > 1500) {
			System.out.println("this model is a long range model");
		}
		else {
			System.out.println("this is a short range model");		}
	}
	
	
	
}
