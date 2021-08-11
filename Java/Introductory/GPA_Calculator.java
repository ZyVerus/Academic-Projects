//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		04/08/2021
//
// This program is meant to calculate a student's new overall GPA
//
// --------------------------------------

// Import Date Packages

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.util.Scanner;

public class GPA_Calculator {

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
		System.out.println("Welcome! This program is will calculate a student's new overall GPA!");
		
		// INPUT DATA
		Scanner scanint = new Scanner(System.in);
		Scanner scandouble = new Scanner(System.in);
		Scanner scanstring = new Scanner(System.in);
		// ASK for Student ID
		System.out.print("Enter student ID:\n> ");
		int studentID = scanint.nextInt();
		// ASK for Current Grade
		System.out.print("Enter current class grade in GPA format (e.g. 3.5):\n> ");
		double currentGrade = scandouble.nextDouble();
		// ASK for Number of Class Credits
		System.out.print("Enter current class number of credits:\n> ");
		int classCredits = scanint.nextInt();
		// ASK for Overall GPA
		System.out.print("Enter overall GPA:\n> ");
		double overallGPA = scandouble.nextDouble();
		// ASK for Overall Credits
		System.out.print("Enter overall number of credits:\n> ");
		int overallCredits = scanint.nextInt();
				
		// CLOSE Scanner to prevent Resource Leaks
		scanint.close();
		scandouble.close();
		scanstring.close();
		
		// CALCULATE GPA
		double newGPA;
		newGPA = ((currentGrade * classCredits) + (overallGPA * overallCredits)) / (classCredits + overallCredits);
		
		// DISPLAY Student Data and Calculation
		System.out.println("");
		System.out.println("STUDENT DATA:");
		System.out.println("Student ID: " + studentID);
		System.out.println("Current Class GPA: " + currentGrade);
		System.out.println("Current Class Credits: " + classCredits);
		System.out.println("Overall GPA: " + overallGPA);
		System.out.println("Overall Credits: " + overallCredits);
		System.out.println("");
		System.out.printf("NEW GPA: %.1f", newGPA);
	}

}