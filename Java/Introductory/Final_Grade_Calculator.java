//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		04/15/2021
//
// This program will calculate student's final course grade.
//
// --------------------------------------

// Import Date Packages
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.util.Scanner;

public class Final_Grade_Calculator {

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
		
		//VARIABLES
		//String runProgram;
		//String studentName;
		
		// INTRO
		System.out.println("Welcome to the grade calculation program.");
		
		// START SCANNER
		Scanner strInput = new Scanner(System.in);

		// INITIATE User Interaction
		System.out.print("Do you want to enter student's data?"
				+ "\nYes/No"
				+ "\n> ");
		String runProgram = strInput.nextLine();
		
		// WHILE Loop
		while (runProgram.equalsIgnoreCase("YES")) {
			//Student Name
			System.out.print("Enter student's name (FirstName LastName):"
					+ "\n> ");
			String studentName = strInput.nextLine();
			//Assignment 1
			System.out.print("Grade - Assignment 1:"
					+ "\n> ");
			Double ass1 = inputGrades();				
			//Assignment 2
			System.out.print("Grade - Assignment 2:"
					+ "\n> ");
			Double ass2 = inputGrades();
			//Exam
			System.out.print("Grade - Exam:"
					+ "\n> ");
			Double exam = inputGrades();
			//Participation
			System.out.print("Grade - Participation:"
					+ "\n> ");
			Double participation = inputGrades();
			
			//CALCULATE Final Grade
			double finalGrade = (
					(ass1 * 0.25) + 
					(ass2 * 0.25) +
					(exam * 0.40) +
					(participation * 0.10)
					);
			
			//DISPLAY Inputs and Results
			System.out.println("Student Name: " + studentName
					+ "\nA1=" + ass1 + " A2=" + ass2 + " Exam=" + exam + " Participation=" + participation
					+ "\nFinal Grade: " + finalGrade
					);

			//ASK to Repeat Loop
			System.out.print("Do you want to enter another student's data?"
					+ "\nYes/No"
					+ "\n> ");
			runProgram = strInput.nextLine();
		}
		
		System.out.println("Thank you for using the grade calculation program! Have a great day.");
		
		// CLOSE Scanner to prevent Resource Leaks
		strInput.close();
		// END Program
		return;
	}

	//METHOD to enter grades and provide input validation
	static public double inputGrades() {
		Scanner methodInput = new Scanner(System.in);
		double value = methodInput.nextDouble();
		while (value < 0 || value > 100) {
			System.out.print("Invalid Entry. Enter a number between 0 - 100 inclusive:"
					+ "\n> ");
			value = methodInput.nextDouble();
		}
	//methodInput.close(); //--Resource Leak. For some reason closing the Scanner here breaks the rest of the program when returning to main()
	return value;
	}
}