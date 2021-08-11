//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		06/01/2021
// 
// This program helps manage book inventory.
//
// --------------------------------------

// Import Java Packages
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Book_Inventory {
	
	// BOOK Class
	public static class Book {
		// Attributes
		private int id;
		private String title;
		private double price;
		
		// Constructor
		public Book(int id, String title, double price) {
			this.id = id;
			this.title = title;
			this.price = price;
		}
						
		// Methods
		// Display Book
		public String displayInfo() {
			//System.out.println();
			return "\nBook ID:\t" + getID()
			+ "\nBook Title:\t" + getTitle()
			+ "\nBook Price:\t$" + getPrice();
		}
		
		// GET Methods
		// ID
		public int getID() {
			return id;
		}
		// Title
		public String getTitle() {
			return title;
		}
		// Price
		public double getPrice() {
			return price;
		}
	}

	
	// INVENTORY Class
	public static class Inventory {
		// Attributes
		ArrayList<Book> list;
		
		// Constructor
		public Inventory() {
			list = new ArrayList<Book>(); // Create Books Array Instance
		}
		
		// Methods
		// Display Menu
		public void displayMenu() {
			System.out.print("\n"
					+ "    MENU:"
					+ "\n1 - Add Book"
					+ "\n2 - Remove Book"
					+ "\n3 - Find Book"
					+ "\n4 - Display All Books"
					+ "\n0 - Exit Program"
					+ "\n> ");
		}
		
		// Process Menu Choices
		public void processChoice(int choice) {
			switch (choice) {
 			case 0:
 				System.out.println("");
 				System.out.print("Exiting program. Thank you, and have a great day!");
 				System.exit(0);
 				break;
 			case 1:
 				addBook();
 				break;
 			case 2:
 				removeBook();
 				break;
 			case 3:
 				findBook();
 				break;
 			case 4:
 				displayBooks();
 				break;
 			default:
 				System.out.println("\nYou did not make an appropriate selection.");
			}
		}
		
		// Add Book
		private void addBook() { 
			//INITIALIZE Scanner
			Scanner inputNumber = new Scanner(System.in);
			Scanner inputString = new Scanner(System.in);

			//ASK for Book Properties
			// Book ID
			System.out.print("\nInput Book ID (Integer Value Only):"
					+ "\n> ");
	        int id = inputNumber.nextInt();
        	// ID Validation
        	if (validateID(id)) {
        		return;
        	}
 
        	// Book Title
			System.out.print("\nBook Title:"
					+ "\n> ");
	        String title = inputString.nextLine();
	        
	        // Book Price
			System.out.print("\nBook Price (Omit Currency Symbol - ie. '19.99':"
					+ "\n> ");
	        double price = inputNumber.nextDouble();
	        
			//CREATE Book
	        Book iBook = new Book(id, title, price);
	        //Output created book
	        System.out.println("\nThe following book was created: " + iBook.displayInfo());
	        //Add Book instance to Book List
	        list.add(iBook);
		}
		
		//Remove Book
		private void removeBook() {
			//INITIALIZE Scanner
			Scanner input = new Scanner(System.in);   
		    
			//Request Book ID to Remove
			System.out.print("\nWhat is the Book ID for the book you would like to remove?:"
					+ "\n> ");
			int id = input.nextInt();
			
			//Find Book to Remove
			int size = list.size();
			for (int i=0; i < size; i++) {
				Book iBook = list.get(i);
				if (iBook.id == id) {
					list.remove(i);
					System.out.println("\nRemoved the following book: " + iBook.displayInfo());
					return;
				}
			}
			// Display Removal/Find Error
			System.out.println("\nThere is no book that matches that ID.");
		}
		
		// Find Book
		private void findBook() {
			//INITIALIZE Scanner
			Scanner input = new Scanner(System.in);   
		    
			//Request Book ID to Remove
			System.out.print("\nWhat is the Book ID for the book you would like to find?:"
					+ "\n> ");
			int id = input.nextInt();
			
			//Find Book
			int size = list.size();
			for (int i=0; i < size; i++) {
				Book iBook = list.get(i);
				if (iBook.id == id) {
					System.out.println("\nThe following book has been found: " + iBook.displayInfo());
					return;
				}
			}
			// Display Removal/Find Error
			System.out.println("\nThere is no book that matches that ID.");
		}
		
		// Display Books
		private void displayBooks() {
			if (list.size() == 0)
				System.out.println("\nThere are no books in the inventory.");
			else {
				for (int i=0; i < list.size(); i++) {
					Book iBook = list.get(i);
					System.out.println(iBook.displayInfo());
				}
			}
		}
		
		// Book Validation
		public boolean validateID(int id) {
			// Set Boolean
			boolean bookExists = false;
			//Find Book
			int size = list.size();
			for (int i=0; i < size; i++) {
				Book iBook = list.get(i);
				if (iBook.id == id) {
					System.out.println("Invalid Entry! Book ID is already in use, or book already exists: " + iBook.displayInfo());
					bookExists = true;
				}
			}
		return bookExists;
		}
    }
	
	
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
		System.out.println("Welcome! This program helps manage book inventories.");
		
		//INITIALIZE Scanner
		Scanner input = new Scanner(System.in);
		
		//VARIABLES
		int action = 1;
        
		// Initiate Instance of the Inventory Class
        Inventory iInventory = new Inventory();
        
        do {
        	iInventory.displayMenu();
        	action = input.nextInt();
        	iInventory.processChoice(action);
        } while (action != 0);
 		
        //CLOSE Scanner
		input.close();   
 		
 		//EXIT Program
 		System.out.println("");
 		System.out.print("Exiting program. Thank you, and have a great day!");
 		System.exit(0);
        
     
	}
}