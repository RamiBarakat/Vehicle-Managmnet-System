package FinalProject;
//a class for the petrol type
public class PetroleumType {
//static attributes for the class
	//the class members and methods are all static which make it easy to call from different classes without the need of an  object 
public static int diesel;
public static int gasoline;
public static double gasolinePrice;
public static double dieselPrice;
//constants for diesel and gasoline
public static final int DIESEL=1;
public static final int GASOLINE=2;


//cannot generate a constructor


//setters and getters for attributes
public static int getDiesel() {
	return diesel;
}
//setter for setdiesel
public static void setDiesel(int diesel) {
	PetroleumType.diesel = diesel;
}
//getter for gasoline
public static int getGasoline() {
	return gasoline;
}
//setter for gasoline
public static void setGasoline(int gasoline) {
	PetroleumType.gasoline = gasoline;
}
//getter for gasoline price
public static double getGasolinePrice() {
	return gasolinePrice;
}
//sets the price for the  the gasoline
public static void setGasolinePrice(double gasolinePrice) {
	PetroleumType.gasolinePrice = gasolinePrice;
}
//getter for diesel price
public static double getDieselPrice() {
	return dieselPrice;
}
//sets the price for the diesel
public static void setDieselPrice(double dieselPrice) {
	PetroleumType.dieselPrice = dieselPrice;
}

public void mymethod3() {
	//average for gasoline is 5.44 nis
	//average price for diesel is 4.3 nis
	
	//method that calculates if the diesel and gasline price are above than average or not
	if (dieselPrice > 4.3) {
	System.out.println("the price now is more than average");
	}
	else if (dieselPrice < 4.3)   {
		System.out.println("the diesel price is lowe than average");
	}
	else if( gasolinePrice > 5.44) {
		System.out.println("the price now is more than average");
	}
	else if(gasolinePrice < 5.44) {
		System.out.println("the price now is less than average");
		
	}
	
	
}


}
