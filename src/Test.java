package FinalProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//test class to test all results 

public class Test {

	// the main class where we put the classes together and put them to use
	// this main class throws io exception to files and cloning also
	public static void main(String[] args) throws IOException, CloneNotSupportedException, IllegalArgumentException {

		// we define an array list to add the objects we read from file
		ArrayList<Vehicles> list = new ArrayList<>();

		// calls the menu to execute an operation the this way the code would be useable
		// and better
		menu(list);

	}

	// a method that has the menu that we choose which thing we want to do that
	// throws exceptions
	public static void menu(ArrayList<Vehicles> list) throws IOException, CloneNotSupportedException, IllegalArgumentException {
		int n = 0;
		Scanner sc = new Scanner(System.in);
         
	
		// do-while loop to continue to take cases as long it is not 9
		do {
			try {
			System.out.println("================MENU====================");
			System.out.println("1 - READ FROM FILE\n2 - ENTER GASOLINE AND DIESEL PRICES\n3 - SORT FOR COSTFOR100KM\n"
					+ "4 - SORT FOR OWNER NAME" + "\n5- SORT FOR VEHICLE BRAND" + "\n6 - CLONE A VEHICLE"
					+ "\n7 - TURN AIR CONDITION ON " + "\n8 - PRINT OBJECTS IN FILE" + "\n9 - QUIT THE PROGRAM");
			System.out.println("========================================\n");
            
			n = sc.nextInt();
			// if we put n not valid it will show a message
			if (n < 1 || n > 9) {
				System.out.println("please choose a number from menu");
			}
			switch (n) {

			// read from file to an array list which throws an exception
			case 1:
				// to read from file we put
				
				    System.out.println("================================== READING FROM FILE ==================================");
					readFile(list);
				
				break;
			// here we enter the prices for gasoline and diesel
			case 2:
				System.out.println("================================================");

				System.out.println(" please enter the price of gasoline ");
				// read from user and since its static we cann call it by its class name
				double gasPrice = sc.nextDouble();
				if(gasPrice < 0) {
					throw new IllegalArgumentException("GASOLINE PRICE IS INVALID"); 
				}
				PetroleumType.setGasolinePrice(gasPrice);
				System.out.println("Gasoline price is  " + PetroleumType.getGasolinePrice());

				System.out.println(" please enter the price of diesel ");
				// same as done above
				double dieselPrice = sc.nextDouble();
				if(dieselPrice < 0) {
					throw new IllegalArgumentException("DIESEL PRICE IS INVALID"); 
				}
				PetroleumType.setDieselPrice(dieselPrice);
				System.out.println("Diesel price is  " + PetroleumType.getDieselPrice());
				System.out.println("================================================");

				break;

			// here we sort the objects according to compareTo method in vehicles based on
			// COSTFOR100KM
			case 3:
				System.out.println("================================================");
				sort(list);
				System.out.println("================================================");

				break;
			// sort according to the owners name
			case 4:
				System.out.println("================================================");
				ownerNameSort(list);
				System.out.println("================================================");
				break;

			// sort according to the vehicle brand
			case 5:
				System.out.println("================================================");
				VenichleBrandSort(list);
				System.out.println("================================================");
				break;

			// clone a n object without cloning the owner
			case 6:
				System.out.println("================================================");
				cloneVehicle(list);
				System.out.println("================================================");
				break;
			// a case which turnes the air conditiong for every car
			case 7:
				System.out.println("================================================");
				turnAirConditionON(list);
				System.out.println("================================================");
				break;

			// prints the thing we read and sorted to a file
			case 8:
				System.out.println("================================================");
				PrintFile(list);
				System.out.println("================================================");
				break;
			// exists the loop and the switch statement
			case 9:
				System.out.println("program Quitting!");
				System.exit(2);
				break;

			}}
			catch (Exception e) {
				System.out.println(e);
				
			}
		} while (n != 9);
		// closing the scanner
		sc.close();
	}

	public static void readFile(ArrayList<Vehicles> list)  throws IOException, CloneNotSupportedException, IllegalArgumentException {
		
	
		
		Scanner sc = new Scanner(System.in);
		// we put the name of the file we will be reading from after creating it
		File myfile = new File("inputdata.txt");
		sc = new Scanner(myfile);
		// do-while loop to read as long as the file has anything left(sc.hasnext)
		do {

			// we put a string to put the line we read in it
			StringBuilder linee = new StringBuilder();
			linee.append(sc.nextLine());
			// then we convert it to a stringbuilder to do manupliations to it
			// then we convert it to array of strings to read word by word
			String[] line2 = linee.toString().split(",");

			for (int i = 0; i < line2.length; i++) {
				// this for loops trims everyword splitted so we don't have problems like
				// reading spaces

				line2[i] = line2[i].trim();
			}

			// the key word in every line is the class name like here we have first word is
			// car so we put the line in the car object
			if (line2[0].equalsIgnoreCase("car")) {
			
				//CHECKING THE VALUES THE USER ENTERS IF ANY WRONG THE EXCEPTION CATCHES
				if ((Double.parseDouble(line2[7])) < 0 || (Double.parseDouble(line2[6])) < 0 || Integer.parseInt(line2[8]) < 0 ) {
					throw new IllegalArgumentException("THERE IS A MINUS VALUE IN CAR");
				}
				
				else if(!(line2[5].equalsIgnoreCase("gasoline")) && !(line2[5].equalsIgnoreCase("hybrid"))){
					throw new IllegalArgumentException("PLEASE CHECK THE CAR ENGINE TYPE");
				}
				//here we put all of the info we read from file into the constructor with
				// converting string to different data types if needed
				
				Car car = new Car(line2[1], line2[2], line2[3], line2[5], Double.parseDouble(line2[6]),
						Double.parseDouble(line2[7]), new Owner(line2[4]), Integer.parseInt(line2[8]), false);
				
				// then we add it to the ArrayList
				list.add(car);

			}
			// if the first word is minivan then it reads to the minivan object from the
			// file into the constructor as shown
			else if (line2[0].equalsIgnoreCase("minivan")) {
				// here we convert from string to other types if needed
				
				//CHECKING THE VALUES THE USER ENTERS IF ANY WRONG THE EXCEPTION CATCHES
				if(!(line2[5].equalsIgnoreCase("gasoline")) && !(line2[5].equalsIgnoreCase("diesel"))){
					throw new IllegalArgumentException("PLEASE CHECK THE MINIVAN ENGINE TYPE");
				}
				
				else if ( !(line2[9].equalsIgnoreCase("true")) && !(line2[9].equalsIgnoreCase("false")) ) {
				throw new IllegalArgumentException("boolean values are wrong(AUTO DOORS IN MINIVAN)");	
				}
				else if ((Double.parseDouble(line2[7])) < 0 || (Double.parseDouble(line2[6])) < 0 || Integer.parseInt(line2[8]) < 0 ) {
					throw new IllegalArgumentException("THERE IS A MINUS VALUE IN MINIVAN");
				}
				
				Minivan mini = new Minivan(line2[1], line2[2], line2[3], line2[5], Double.parseDouble(line2[6]),
						(Double.parseDouble(line2[7])), new Owner(line2[4]), Integer.parseInt(line2[8]), false,
						Boolean.parseBoolean(line2[9]));

				// here we add the object to the
				list.add(mini);
			}
			// if the first word is truck then it reads to the truck object from the file
			// into the constructor as shown

			else if (line2[0].equalsIgnoreCase("truck")) {
				
				//CHECKING THE VALUES THE USER ENTERS IF ANY WRONG THE EXCEPTION CATCHES
				if(!(line2[5].equalsIgnoreCase("DIESEL")) ){
					throw new IllegalArgumentException("PLEASE CHECK THE CAR ENGINE TYPE");
				}
				
				else if ((Double.parseDouble(line2[7])) < 0 || (Double.parseDouble(line2[6])) < 0 || (Integer.parseInt(line2[8])) < 0 || (Integer.parseInt(line2[9])) < 0 ) {
					throw new IllegalArgumentException("THERE IS A MINUS VALUE IN TRUCK");
				}

				Truck truck = new Truck(line2[1], line2[2], line2[3], line2[5], (Double.parseDouble(line2[6])),
						(Double.parseDouble(line2[7])), new Owner(line2[4]), false, (Integer.parseInt(line2[9])),
						(Integer.parseInt(line2[8])));

				// adds it to the arrayList of objects
				list.add(truck);

			}
			else throw new IllegalArgumentException(" not car nor truck nor minivan");
			// here is the while and its expression
		} while (sc.hasNext());

		
		System.out.println("\n======================FILE READ SUCCESSFULLY======================");
		for ( int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
			
		}
		// closing the reader
		sc.close();
	
		// return to menu to choose the next operation
		menu(list);

	}

	// this method sets the prices for gasoline and diesel and it throws io
	// exception and clone not supported
	//public static void setPrices(ArrayList<Vehicles> list) throws IOException, CloneNotSupportedException {
	
	//}

	// sorting the arraylist objects using collections.sort whhich compares
	// according to cost for 100km
	public static void sort(ArrayList<Vehicles> list) throws IOException, CloneNotSupportedException {
		Collections.sort(list);

	
		// calls menu to continue the menu operations
		for (int i = 0; i < list.size(); i++) {
			System.out.println((list.get(i).toString()));
			
		}
	
		menu(list);
	}

	public static void cloneVehicle(ArrayList<Vehicles> list) throws CloneNotSupportedException, IOException,IllegalArgumentException {

		Scanner sc = new Scanner(System.in);
		// to clone we first display the list
		System.out.println("\n=======================Please choose from the list to clone============================");
		
		for (int i = 0; i < list.size(); i++) {

			System.out.println((i + 1) + "-" + list.get(i).toString());
		}
		
	
			// here we enter the number if the object we want to clone
			int clone = sc.nextInt();
			
			if (clone > 6 || clone < 0) {
				throw new IllegalArgumentException("VEHICLE DOESN'T EXIST IN LIST");
			}
			
			// here we type cast the object to Vehicle and then call the clone method to
			// clone it
			int choose = clone - 1;
			Vehicles vehicleClone = (Vehicles) (list.get(choose)).clone();
			// here we print it
			
			System.out.println(vehicleClone.toString());

		
      
		// calls menu to continue the operations
		menu(list);

	}

	// this methods turnes the air conditiong on in all of the object which affects
	// fuel consumption
	public static void turnAirConditionON(ArrayList<Vehicles> list) throws IOException, CloneNotSupportedException {
		// for loop to turn it on in all of the objects
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAirConditionON();
		}
		System.out.println("AIR CONDITIONING IS TURNED ON");
		// calls menu to continue the menu operations

		menu(list);

	}

	// here we sort it manually according to owners name as it throws ioexception
	// and clonenotsupported exceptions
	public static void ownerNameSort(ArrayList<Vehicles> list) throws IOException, CloneNotSupportedException {
		// temp to hold the object when sorting
		Vehicles temp;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if ((list.get(i).owner.getName().compareToIgnoreCase((list.get(j).owner.getName()))) > 0) {
					// we compare the names in ascending order from small to big (letter for letter
					// Comparison)
					// if the if-statement success we put the first object in temp
					// then we swap the two objects around
					temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}

		}
	
		for (int i = 0; i < list.size(); i++) {
			System.out.println((list.get(i).toString()));
		
		}

		// calls menu to continue the menu operations
		menu(list);

	}

	// here we sort the vehicles according to vehicle brand as it throws io
	// exception and clone not supported
	public static void VenichleBrandSort(ArrayList<Vehicles> list) throws IOException, CloneNotSupportedException {
		Vehicles temp;
		// temp to store a vehicle type object in it
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				// nested loop that takes the object and object +1 and compares them
				if (list.get(i).getBrand().compareToIgnoreCase((list.get(j).getBrand())) < 0) {
					// here it does like the above sorting nothing different but here it is
					// decending order as in the if statement
					temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);

				}
			}
			
		}
		System.out.println("\n=================VEHICLE BRAND SORT==================");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((list.get(i).toString()));
			
		}
		
		// calls menu to continue the menu operations
		menu(list);
	}

	// this function is to print the array list to the file it throws io exception
	// and clone not supported
	public static void PrintFile(ArrayList<Vehicles> list) throws IOException, CloneNotSupportedException {
		// here we declare fileWriter and PrintWriter to write to the file
		FileWriter mywriter = new FileWriter(new File("output.txt"), true);// if without true it overwrites same as
																			// so we put it inside of printwriter
		PrintWriter out = new PrintWriter(mywriter);
		Collections.sort(list);
		out.println("\n========================PRINTING TO FILE=======================");

		for (int i = 0; i < list.size(); i++) {
			// here we print them using out.println
			out.println((list.get(i).toString()));
			System.out.println((list.get(i).toString()));
		}
		out.close();
		menu(list);
	}

}
