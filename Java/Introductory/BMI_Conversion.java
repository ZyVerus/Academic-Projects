//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		04/20/2021
//
// This program offers different conversions calculators and a Body Mass index (BMI) assessment.
//
// --------------------------------------

// Import Date Packages
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.util.Scanner;

public class BMI_Conversion {

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
		
		// START SCANNER
		Scanner input = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		
		// INITIALIZE Variables
		double pounds = 0,
				kilograms = 0,
				inches = 0,
				centimeters = 0,
				bodyMassIndex = 0;
	
		// INITIALIZE While Loop
		String runProgram = "Y";
		do {
			// ASK Which Shape to Run
			System.out.print("\n"
					+ "    MENU:"
					+ "\n1 - Convert weight in Pounds (lbs) to Kilograms (kg)"
					+ "\n2 - Convert height in Inches (in) to Centimeters (cm)"
					+ "\n3 - Calculate Body Mass Index (BMI) using weight in Kilograms (kg) and height in inches (in)"
					+ "\n0 - Exit Program"
					+ "\n> ");
			int action = input.nextInt();
						
			// RUN Selected Action
			switch ( action ) {
			// CASE 3: BMI Assessment
			case 0:
				System.out.println("");
				System.out.print("Exiting program. Thank you, and have a great day!");
				System.exit(0);
			// CASE 1: Weight - Pounds to Kilograms
			case 1:
				System.out.println("");
				System.out.print("Please enter the weight in Pounds (lbs):"
						+ "\n> ");
				pounds = input.nextDouble();
				kilograms = convertWeight(pounds);
				System.out.println("Kilograms (kg): " + kilograms);
				// ASK to Re-run Program
				System.out.println("");
				System.out.print("Would you like to run another operation?"
						+ "\n(Y/N):"
						+ "\n> ");
				runProgram = inputString.nextLine();
				break;
			// CASE 2: Height - Inches to Centimeters
			case 2:
				System.out.println("");
				System.out.print("Please enter the height in Inches (in):"
						+ "\n> ");
				inches = input.nextDouble();
				centimeters = convertHeight(inches);
				System.out.println("Centimeters (cm): " + centimeters);
				// ASK to Re-run Program
				System.out.println("");
				System.out.print("Would you like to run another operation?"
						+ "\n(Y/N):"
						+ "\n> ");
				runProgram = inputString.nextLine();
				break;
			// CASE 3: BMI Assessment
			case 3:
				if (kilograms != 0) {
					System.out.println("");
					System.out.print("Would you like to use the previously calculated Kilograms (kg) value?"
							+ "\n(Y/N):"
							+ "\n> ");
					String useKgValue = inputString.nextLine();
					if (useKgValue.equalsIgnoreCase("N")) {
						System.out.print("Please enter the weight in Kilograms (kg):"
								+ "\n> ");
						kilograms = input.nextDouble();	
					}
				}
				else {
					System.out.print("Please enter the weight in Kilograms (kg):"
							+ "\n> ");
					kilograms = input.nextDouble();	
				}
				if (centimeters != 0) {
					System.out.println("");
					System.out.print("Would you like to use the previously calculated Centimeters (cm) value?"
							+ "\n(Y/N):"
							+ "\n> ");
					String useCmValue = inputString.nextLine();
					if (useCmValue.equalsIgnoreCase("N")) {
						System.out.print("Please enter the height in Centimeters (cm):"
								+ "\n> ");
						centimeters = input.nextDouble();	
					}
				}
				else {
					System.out.print("Please enter the height in Centimeters (cm):"
							+ "\n> ");
					centimeters = input.nextDouble();	
				}
				
				bodyMassIndex = assessBMI(kilograms, centimeters);
				System.out.println("Body Mass Index (BMI) Value:    " + bodyMassIndex);
				
				// SHOW BMI Category
				String bmiCategory = "";
				if (bodyMassIndex < 18.5) {
					bmiCategory = "Underweight";
				}
				else if (bodyMassIndex >= 18.5 && bodyMassIndex <= 24.99) {
					bmiCategory = "Normal";			
				}
				else if (bodyMassIndex >= 25.0 && bodyMassIndex <= 29.99) {
					bmiCategory = "Overweight";
				}
				else if (bodyMassIndex >= 30) {
					bmiCategory = "Obese";
				}
				else {
					System.out.print("Unknown Category.");
				}
				
				System.out.println("Body Mass Index (BMI) Category: " + bmiCategory);
				// ASK to Re-run Program
				System.out.println("");
				System.out.print("Would you like to run another operation?"
						+ "\n(Y/N):"
						+ "\n> ");
				runProgram = inputString.nextLine();
				break;
			// DEFAULT No Selection
			default:
				System.out.print("You did not make an appropriate selection.");
			}
		}
		while (runProgram.equalsIgnoreCase("Y"));
		// CLOSE input Scanners
		input.close();
		inputString.close();
		
		//EXIT Program
		System.out.println("");
		System.out.print("Exiting program. Thank you, and have a great day!");
		System.exit(0);
	}

	//---------//
	// METHODS //
	//---------//
	
	//Convert Pounds to Kilograms
	static public double convertWeight(double pounds) {
		return (pounds * 0.45);
	}
	
	//Convert Feet to Inches
	static public double convertHeight(double inches) {
		return (inches * 2.54);
	}
	
	//Assess BMI
	static public double assessBMI(double weight, double height) {
		return (weight / height / height * 10000);
	}
	
}