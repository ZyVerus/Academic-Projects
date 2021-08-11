//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		04/20/2021
//
// This program will allow you to input student's exam scores and compare them.
//
// --------------------------------------

// Import Date Packages

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
import java.util.Scanner;

public class Exam_Scores {

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
		System.out.println("This program will allow you to input student's exam scores and compare them.");
		
		//INITIALIZE Scanners
		Scanner numberInput = new Scanner(System.in);
		Scanner stringInput = new Scanner(System.in);

		//VARIABLES
        int count;
        String[] studentList;
        String highestStudent;
        String lowestStudent;
        int[] scoreList;
        int highestScore;
        int lowestScore;
        
		//ASK and INPUT amount of numbers to check
		System.out.print("\nHow many students' grades are you entering?"
				+ "\n> ");
        count = numberInput.nextInt();
		
        // Declare Array Variables
        studentList = new String[count];
        scoreList = new int[count];
        
		//ASK and INPUT Student Names
		for (int i = 0; i < studentList.length; i++) {
			// Show Student Number
			System.out.println("Student " + (i+1) + ":");
			//Enter Student's Name
			System.out.print("\tEnter student's name: ");
			studentList[i] = stringInput.nextLine();
			//Enter Student's Exam Score
			System.out.print("\tEnter student's score (0-100): ");
			scoreList[i] = numberInput.nextInt();
		}
		
        //CALL Methods to check for Highest & Lowest Exam Scores
		highestStudent = checkHighestStudent(studentList, scoreList);
		lowestStudent = checkLowestStudent(studentList, scoreList);
		highestScore = checkHighestScore(scoreList);
		lowestScore = checkLowestScore(scoreList);
		
		//OUTPUT Scores and Comparisons
		System.out.println("\nStudent Name" + "\t\t" + "Score");
		for (int i = 0; i < studentList.length; i++) {
			//Print Student and Exam Score
			System.out.println(studentList[i] + "\t\t" + scoreList[i]);	
		}
		//Print Highest & Lowest Students
		System.out.println("");
		System.out.println(highestStudent + " has the highest score of " + highestScore);
		System.out.println(lowestStudent + " has the lowest score of " + lowestScore);
		
        //CLOSE Scanner
		numberInput.close();
		stringInput.close();

	}
	
	//-------------------//
	//      METHODS      //
	//-------------------//
	
	//HIGHEST
	//CHECK for highest student
	static public String checkHighestStudent(String [] studentList, int [] scoreList) {
		String highestStudent = "";
		int highestScore = 0;
		for (int i = 0; i < studentList.length; i++) {
			if (scoreList[i] > highestScore) {
				highestScore = scoreList[i];
				highestStudent = studentList[i];
			}
		}
	return highestStudent;
	}
	//CHECK for highest score
	static public int checkHighestScore(int [] scoreList) {
		int highestScore = 0;
		for (int i = 0; i < scoreList.length; i++) {
			if (scoreList[i] > highestScore) {
				highestScore = scoreList[i];
			}
		}
	return highestScore;
	}
	//LOWEST
	//CHECK for lowest student
	static public String checkLowestStudent(String [] studentList, int [] scoreList) {
		String lowestStudent = "";
		int lowestScore = 100;
		for (int i = 0; i < studentList.length; i++) {
			if (scoreList[i] < lowestScore) {
				lowestScore = scoreList[i];
				lowestStudent = studentList[i];
			}
		}
	return lowestStudent;
	}
	//CHECK for lowest score
	static public int checkLowestScore(int [] scoreList) {
		int lowestScore = 100;
		for (int i = 0; i < scoreList.length; i++) {
			if (scoreList[i] < lowestScore) {
				lowestScore = scoreList[i];
			}
		}
	return lowestScore;
	}

}
