//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		05/11/2021
//
// This program allows the input and retrieval of employee data.
//
// --------------------------------------

// Import Date Packages

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee_Data {
	
	//VARIABLES
    public static int[] employeeIDs;
    public static int arrayUsed = 0;
    public static String[] employeeNames;
    public static double[] employeeSalaries;
	
	public static void main(String[] args) {
		
		// DATE
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate currentDate = LocalDate.now();
		// SET Submission Requirement Variables
		String firstName = "ZyVerus";
		String lastName = "*******";
		String courseIdentifier = "*******";
		// PRINT Submission Requirement Header
		System.out.println("Name: " + lastName + ", " + firstName);
		System.out.println("Course ID: " + courseIdentifier);
		System.out.println("Date: " + dtf.format(currentDate) + "\n");
		
		// INTRO
		System.out.println("Welcome! This program allows the input and retrieval of employee data..");
		
		//INITIALIZE Scanners
		Scanner inputNumber = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		
	    // Declare Array Variables
		employeeIDs = new int[100];
	    employeeNames = new String[100];
	    employeeSalaries = new double[100];

        ///--MENU--//
        // Initialize While Loop
 		String runProgram = "Y";
 		do {
 			// ASK Which Action to Run
 			System.out.print("\n"
 					+ "    MENU:"
 					+ "\n1 - Load Employees' Data"
 					+ "\n2 - Add New Employee"
 					+ "\n3 - Display All Employees"
 					+ "\n4 - Retrieve Specific Employee's Data"
 					+ "\n5 - Retrieve Employees Based on Salary Range"
 					+ "\n0 - Exit Program"
 					+ "\n> ");
 			int action = inputNumber.nextInt();
 						
 			// RUN Selected Action
 			switch ( action ) {
 			//// CASE 0: Exit Program
 			case 0:
 				System.out.println("");
 				System.out.print("Exiting program. Thank you, and have a great day!");
 				System.exit(0);
 				
 			//// CASE 1: 
 			case 1:
 				loadEmployees();
 				break;
 			//// CASE 2: 
 			case 2:
 				addEmployees();
 				break;
 			//// CASE 3: 
 			case 3:
 				displayEmployees();
 				break;
 			//// CASE 4: 
 			case 4:
 				findEmployee();
 				break;
 	 		//// CASE 5: 
 			case 5:
 				findSalaryRange();
 				break;
 				
 			//// DEFAULT No Selection
 			default:
 				System.out.println("\nYou did not make an appropriate selection.");
 			}
 		}
 		while (runProgram.equalsIgnoreCase("Y"));
 		
 		//EXIT Program
 		System.out.println("");
 		System.out.print("Exiting program. Thank you, and have a great day!");
 		System.exit(0);
	}

	//-------------------//
	//      METHODS      //
	//-------------------//

	//Load Employees
	static public void loadEmployees() {
		//INITIALIZE Scanners
		Scanner inputNumber = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		//ASK for Amount
		System.out.print("\nHow many employees are you entering?"
					+ "\n> ");
	    int count = inputNumber.nextInt();
		//Create Amount of Employees Desired
		for (int i = 0; i < count; i++) {
			// Show Student Number
			System.out.println("Employee " + (i + 1) + ":");
			//Input Employee's ID
			System.out.print("\tEnter employee's ID (5 Digit Number): ");
			employeeIDs[i] = inputNumber.nextInt();
			//Input Employee's Name
			System.out.print("\tEnter employee's name: ");
			employeeNames[i] = inputString.nextLine();
			//Input Employee's Salary
			System.out.print("\tEnter employee's salary: ");
			employeeSalaries[i] = inputNumber.nextDouble();
			arrayUsed = arrayUsed + 1;
		}
	}

	//Add Employees
	static public void addEmployees() {
		//INITIALIZE Scanners
		Scanner inputNumber = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		//Input Employee's ID
		System.out.print("\tEnter employee's ID (5 Digit Number): ");
		employeeIDs[arrayUsed] = inputNumber.nextInt();
		//Input Employee's Name
		System.out.print("\tEnter employee's name: ");
		employeeNames[arrayUsed] = inputString.nextLine();
		//Input Employee's Salary
		System.out.print("\tEnter employee's salary: ");
		employeeSalaries[arrayUsed] = inputNumber.nextDouble();
		arrayUsed = arrayUsed + 1;
	}
	
	//Display All Employees
	static public void displayEmployees() {
		System.out.println("\nEmployee ID" + "\t\t" + "Name"+ "\t\t" + "Salary");
		for (int i = 0; i < arrayUsed; i++) {
			//Print Employee Info
			System.out.println(employeeIDs[i] + "\t\t\t" + employeeNames[i] + "\t\t" + employeeSalaries[i]);	
		}
	}
	
	//Find Specific Employee
	static public void findEmployee() {
		//INITIALIZE Scanners
		Scanner inputNumber = new Scanner(System.in);
		
		//Initialize Employee Found Variable
		int employeeFound = 0;
		
		//Input Employee's ID
		System.out.print("\tEnter the ID of the employee you would like to find: ");
		int idToFind = inputNumber.nextInt();
		
		for (int i = 0; i < arrayUsed; i++) {
			if (idToFind == employeeIDs[i]) {
				//Print Employee Info
				System.out.println("\nEmployee ID" + "\t\t" + "Name"+ "\t\t" + "Salary");
				System.out.println(employeeIDs[i] + "\t\t\t" + employeeNames[i] + "\t\t" + employeeSalaries[i]);
				employeeFound = 1;
			}
		}
		if (employeeFound == 0) {
			System.out.println("\nEmployee not found. Ensure the ID is correct.");
		}
	}
	
	//FIND Salary Range
	static public void findSalaryRange() {
	    //INITIALIZE Scanners
	    Scanner inputNumber = new Scanner(System.in);
	    //Input Salary Finder Range
	    System.out.print("\tEnter the low end of the salary range: ");
	    double lowSalaryRange = inputNumber.nextInt();
	    System.out.print("\tEnter the high end of the salary range: ");
	    double highSalaryRange= inputNumber.nextInt();
	    
		System.out.println("\nEmployee ID" + "\t\t" + "Name"+ "\t\t" + "Salary");
		for (int i = 0; i < arrayUsed; i++) {
			if (employeeSalaries[i] >= lowSalaryRange && employeeSalaries[i] <= highSalaryRange ) {
				//Print Employee Info
				System.out.println(employeeIDs[i] + "\t\t\t" + employeeNames[i] + "\t\t" + employeeSalaries[i]);
			}
		}
	}
}
