package FinalProject;

import java.util.Calendar;
import java.util.GregorianCalendar;


//owner class which has an aggregation(composition) relation with the abstract class vehicles 
public class Owner {
	// here is the class attributes 
String name;
String pin;
String address;
String mobileNO;
//date is in gregorian here
GregorianCalendar dateOfBirth;

//no-arg constructor that passes nothing
public Owner() {
	this("","","","",new GregorianCalendar());
	
}
//overloaded constructor to only pass the name of the owner 
public Owner(String name) {
	this.name = name;
	
}

// an overloaded method that passes all the attributes of the class 
public Owner(String name, String pin, String address, String mobileNO, GregorianCalendar dateOfBirth) {
	super();
	this.name = name;
	this.pin = pin;
	this.address = address;
	this.mobileNO = mobileNO;
	this.dateOfBirth = dateOfBirth;
}



//to string method that converts info to strings
@Override
public String toString() {
	return  name ;
}
//setters and getters for all of the attributes
public String getName() {
	return name;
}
//setter for name
public void setName(String name) {
	this.name = name;
}
//getter for pin
public String getPIN() {
	return pin;
}
//setter for pin
public void setPIN(String pin) {
	this.pin =  pin;
}
//getter for address
public String getAddress() {
	return address;
}
//setter for address
public void setAddress(String address) {
	this.address = address;
}
//getter for mobileNo
public String getMobileNO() {
	return mobileNO;
}
//setter for MobileNo
public void setMobileNO(String mobileNO) {
	this.mobileNO = mobileNO;
}
//getter for birthofdate
public GregorianCalendar getDateOfBirth() {
	return dateOfBirth;
}
//setter for dateOfBirth
public void setDateOfBirth(GregorianCalendar dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
//an extra method
public void mymethod() {//method that makes sure that the owner is 18 or over to get a car
	
	Calendar cal = new GregorianCalendar();
	if (cal.get(Calendar.YEAR) > (dateOfBirth.get(Calendar.YEAR) + 18)) {
	System.out.println("age is valid ");	
		
		
	}
	else {
		System.out.println("age is invalid");
	}
	
	
	
	
}


}
