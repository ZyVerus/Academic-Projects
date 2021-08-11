//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		04/20/2021
//
// This program will create some shapes!
//
// --------------------------------------

// Import Date Packages
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.util.Scanner;

public class Shapes {

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
		
		// INTRO
		System.out.println("Welcome to the shapes program!");
		
		// ASK Which Shape to Run
		System.out.print("Which shape would you like to output (1 or 2)?"
				+ "\nTriangle - 1"
				+ "\nDiamond  - 2"
				+ "\n> ");
		int shape = input.nextInt();
		
		// RUN Selected Shape
		int row, col;
		switch ( shape ) {
		// CASE 1: Triangle
		case 1:
			System.out.println("How many rows would you like in your triangle?"
					+ "\n> ");
			int triSize = input.nextInt();
			
			// For-Loop
			for (row = 1; row <= triSize; row++) {
				for (col = 1; col <= triSize; col++) {
					if (col <= row)
						System.out.print("# ");
				}
				System.out.println();
			}
			break;
		// CASE 2: Diamond
		case 2:
			System.out.print("How long would you like the sides to be?"
					+ "\n> ");
			int diSize = input.nextInt();
			
			// For-Loop
			for(row = 0; row <= diSize; row++) {
				for(col = 1; col <= diSize - row; col++)
		    		System.out.print("   ");
		    	for(col = 1; col <= 2 * row - 1; col++)
		    		System.out.print("#  ");
		    	System.out.println();
		    }
			for(row = diSize - 1; row >= 1; row--) {
				for(col = 1; col <= diSize - row; col++)
					System.out.print("   ");
				for(col = 1; col <= 2 * row - 1; col++)
					System.out.print("#  ");
				System.out.println();
			}
		// DEFAULT No Shape
		default:
			System.out.print("You did not make an appropriate selection.");
		}
		// CLOSE input Scanner
		input.close();
	}
}