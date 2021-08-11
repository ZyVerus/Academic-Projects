//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		04/15/2021
//
// This program will help with solving simple arithmetic.
//
// --------------------------------------

// Import Date Packages
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.util.Scanner;

public class Simple_Arithmetic {

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
		System.out.println("Welcome! This program will help with solving simple arithmetic.");
		
		// START SCANNER
		Scanner input = new Scanner(System.in);

		// ASK for Numbers & Operation Symbol
		System.out.print("Enter the first number:\n> ");
		double firstNumber = input.nextDouble();
		System.out.print("Enter the second number:\n> ");
		double secondNumber = input.nextDouble();
		System.out.print("Enter one of the arithmetic operation symbols below:"
				+ "\nAddition: +"
				+ "\nSubtraction: -"
				+ "\nMultiplication: *"
				+ "\nDivision: /"
				+ "\n> ");
		char operationSymbol = input.next().charAt(0);
		// CLOSE Scanner to prevent Resource Leaks
		input.close();
		
		// SWITCH Calculations
		double solution = 0;
		
		switch (operationSymbol) {
		case '+':
			solution = firstNumber + secondNumber;
			break;
		case '-':
			solution = firstNumber - secondNumber;
			break;
		case '*':
			solution = firstNumber * secondNumber;
			break;
		case '/':
			solution = firstNumber / secondNumber;
			break;
		default:
			System.out.println("You did not enter a valid arithmetic operation.");
			// END Program
			return;
		}
		
		// DISPLAY Result
		System.out.println("Solution: " + firstNumber + " " + operationSymbol + " " + secondNumber + " = " + solution );
	}
}