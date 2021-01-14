package vehInvOne;
import java.util.*;

import vehInvOne.Vehicle.driveTrain;
import vehInvOne.Vehicle.power;
import vehInvOne.Vehicle.titleStatus;
import vehInvOne.Vehicle.transmission;

public class VehicleInvClient{
	
	private static Map<String, Vehicle> inventory = new HashMap<>();

	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	
//	addCar();
//	addCar();
	
	System.out.println(inventory);
	
//	boolean input = true;
//	while(input){
//		System.out.println("Welcome to the vehicle inventory menu, what would you like to do?");
//		System.out.println("Enter: 1 to add new vehicle, 2 to lookup a vehicle, 3 to edit remove a vehicle's info, 4 to exit");
//	
//		int option = sc.nextInt();
//		switch(option){
//			case 1:
//			addCar();
//			System.out.println("Vehicle added to inventory");
//			break;
//			case 2:
//			break;
//			case 3:
//			break;
//			case 4:
//			System.exit();
//	}
	}

	

	public static void addCar(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter make: ");
		String make = sc.next().toUpperCase();
		System.out.println("Enter model");
		String model = sc.next().toUpperCase();
		System.out.println("Enter VIN");
		String VIN = sc.next().toUpperCase();
		System.out.println("Enter year: ");
		int year = sc.nextInt();

		System.out.println("Enter exterior color: ");
		String exClr = sc.next().toUpperCase();
		System.out.println("Enter interior color: ");
		String intClr = sc.next().toUpperCase();

		System.out.println("Enter mileage: ");
		int mileage = sc.nextInt();
		System.out.println("Enter condition: ");
		String cond = sc.next().toUpperCase();
		System.out.println("Enter titleStatus: ");
		String title = sc.next().toUpperCase();

		System.out.println("Enter drivetrain type: ");
		String dt = sc.next().toUpperCase();
		System.out.println("Enter transmission type: ");
		String trans = sc.next().toUpperCase();
		System.out.println("Enter power type: ");
		String fuel = sc.next().toLowerCase();
		
		System.out.println("Enter sell price: ");
		double price = sc.nextDouble();

		Vehicle addCar = new Vehicle.CarBuilder(VIN, make, model, year)
					.color(exClr, intClr)
					.usageHist(mileage, titleStatus.valueOf(title), cond)
					.engine(driveTrain.valueOf(dt), transmission.valueOf(trans), power.valueOf(fuel))
					.cost(price)
					.build();
		
		inventory.put(addCar.getVIN(), addCar);
	}

//	public static void genID(){
//		Random rand = new Random();
//		int inventID = rand.nextInt(5000);
//		while(inventory.containsKey(inventID)){
//			inventID= rand.nextInt(5000);
//		}
//
//		System.out.println(inventID);
//	}
	





}