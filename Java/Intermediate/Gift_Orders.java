//
// Assignment:	*******
// Name: 		ZyVerus
// Course: 		*******
// Date: 		07/11/2021
// 
// This program helps process gift orders.
//
// --------------------------------------

// Import Java Packages
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Gift_Orders {
	// INIT Scanner
	static Scanner inputString = new Scanner(System.in);
	static Scanner inputNumber = new Scanner(System.in);
	
	// Create Gift Class
	public static class Gift {
		// Attributes
		private String id;
		private static String size;
		private double price;
		// Constructor
		public Gift(String id, String size) {
			this.id = id;
			this.size = size;
		}
		
		// Display Information
		public void displayInfo() {
			System.out.print("\n--Gift--"
					+ "\nID:\t\t" + getID()
					+ "\nSize:\t\t" + getSize()
					+ "\nPrice:\t\t" + getPrice());
		}
		// SET Methods
		//		SIZE
		public void setSize() {
			this.size = selectSize();
		}
		//		PRICE
		public void setPrice(boolean citrusInput) {
			this.price = calculatePrice(size, citrusInput);
		}
		// GET Methods
		// 		ID
		public String getID() {
			return id;
		}
		// 		Size
		public static String getSize() {
			return size;
		}
		// 		Price
		public double getPrice() {
			return price;
		}
				
		// GENERATE Random ID
		private static String generateID(int giftType) {
			String prefix = "";
			// SET ID Prefix based on Gift Type
	        if (giftType == 1) {
	        	prefix = "FB";
	        }
	        else {
	        	prefix = "SB";
	        }
	        // Generate Random Numbers
	        Random rnd = new Random();
	        int numbers = rnd.nextInt(999999);
	        // Convert to String
	        String numbersString = String.format("%06d", numbers);
	        String fullID = prefix + numbersString;
	        // Return Value
	        return fullID;
		}
		// SELECT Gift Size
		private static String selectSize() {
			String size = "";
			int sizeValid = 0;
			do {
				System.out.print("\nWhat size basket would you like?"
						+ "\nS - Small"
						+ "\nM - Medium"
						+ "\nL - Large"
						+ "\n> ");
				size = inputString.nextLine();
				// Ensure String is in UpperCase
				size = size.toUpperCase();
				if (size.equals("S") || size.equals("M") || size.equals("L")) {
					sizeValid = 1;
				}
				else {
					System.out.print("Invalid Entry. Please select an appropriate size from S, M, or L.");
				}
			}
			while (sizeValid == 0);
			return size;
		}
		// DETERMINE Gift Price
		public static double calculatePrice(String size, boolean surcharge) {
			double price = 0;
			if (size.equals("S")) {
				price = 19.99;
			}
			else if (size.equals("M")) {
				price = 29.99;
			}
			else {
				price = 39.99;
			}
			if (surcharge == true) {
				price = price + 5.99;
			}
			return price;
		}		
	}
	// Create Fruit Basket Subclass
	public static class FruitBasket extends Gift {
		// Attributes
		private int numberOfFruits;
		private boolean citrusFruits;
		// Constructor
		public FruitBasket(String id, String size, int numberOfFruits, boolean citrusFruits) {
			super(id, size);
			this.numberOfFruits = numberOfFruits;
			this.citrusFruits = citrusFruits;
		}
		// Display Information
		public void displayFruitInfo() {
			System.out.println(""
					+ "\nFruit Count:\t" + getNumberOfFruits()
					+ "\nHas Citrus:\t" + getCitrusFruits());
		}
		// SELECT Citrus
		private static boolean selectCitrus() {
			Boolean citrus = false;
			String selection ="";
			int selectionValid = 0;
			do {
				System.out.print("\nWould you like citrus fruits included?"
						+ "\nY - Yes"
						+ "\nN - No"
						+ "\n> ");
				selection = inputString.nextLine();
				// Ensure String is in UpperCase
				selection = selection.toUpperCase();
				if (selection.equals("Y")) {
					citrus = true;
					selectionValid = 1;
				}
				else if (selection.equals("N")) {
					citrus = false;
					selectionValid = 1;
				}
				else {
					System.out.print("Invalid Entry. Please select an appropriate value as either 'Y' for Yes, or 'N' for No.");
				}
			}
			while (selectionValid == 0);
			return citrus;
		}
		// DETERMINE Number of Fruits
		public static int calculateNumberOfFruits(String size) {
			int nof = 0;
			if (size.equals("S")) {
				nof = 6;
				return nof;
			}
			else if (size.equals("M")) {
				nof = 9;
				return nof;
			}
			else {
				nof = 15;
				return nof;
			}
		}
		// SET Methods
		//		Number of Fruits
		public void setNumberOfFruits() {
			this.numberOfFruits = calculateNumberOfFruits(getSize());
		}
		//		Has Citrus
		public void setCitrusFruits() {
			this.citrusFruits = selectCitrus();
		}
		// GET Methods
		// 		Number of Fruits
		public int getNumberOfFruits() {
			return numberOfFruits;
		}
		// 		Has Citrus
		public boolean getCitrusFruits() {
			return citrusFruits;
		}
	}
	// Create Sweets Basket Subclass
	public static class SweetsBasket extends Gift {
		// Attributes
		private boolean includesNuts;
		// Constructor
		public SweetsBasket(String id, String size, boolean includesNuts) {
			super(id, size);
			this.includesNuts = includesNuts;
		}
		// Display Information
		public void displaySweetsInfo() {
			System.out.println(""
					+ "\nIncludes Nuts:\t" + getIncludesNuts());
		}
		// SELECT Nuts
		private static boolean selectNuts() {
			Boolean nuts = false;
			String selection ="";
			int selectionValid = 0;
			do {
				System.out.print("\nWould you like nuts included?"
						+ "\nY - Yes"
						+ "\nN - No"
						+ "\n> ");
				selection = inputString.nextLine();
				// Ensure String is in UpperCase
				selection = selection.toUpperCase();
				if (selection.equals("Y")) {
					nuts = true;
					selectionValid = 1;
				}
				else if (selection.equals("N")) {
					nuts = false;
					selectionValid = 1;
				}
				else {
					System.out.print("Invalid Entry. Please select an appropriate value as either 'Y' for Yes, or 'N' for No.");
				}
			}
			while (selectionValid == 0);
			return nuts;
		}
		// SET Methods
		//		Includes Nuts
		public void setIncludesNuts() {
			this.includesNuts = selectNuts();
		}
		// GET Methods
		// 		Includes Nuts
		public boolean getIncludesNuts() {
			return includesNuts;
		}
	}
	// Order System Class
	public static class OrderSystem {
		Object myGift;
		
		// Display Menu
		public void displayMenu() {
			System.out.print("\n"
					+ "\tMENU:"
					+ "\n1 - Order a Gift Basket"
					+ "\n2 - Change Gift Basket"
					+ "\n3 - Display Gift"
					+ "\n9 - Exit Program"
					+ "\n> ");
		}
		// Process Menu Choices
		public void processChoice(int choice) {
			switch (choice) {
				case 9:
					System.out.println("");
					System.out.print("Exiting program. Thank you, and have a great day!");
					System.exit(0);
					break;
				case 1:
					myGift = orderGift();
					break;
				case 2:
					changeGift(myGift);
					break;
				case 3:
					displayGift(myGift);
					break;
				default:
					System.out.println("\nYou did not make an appropriate selection.");
			}
		}
		// MENU Methods
		//		ORDER Gift
		private Object orderGift() {
			int giftType = selectGiftType();
	        // Create Object Based on Type
			String id = Gift.generateID(giftType);
			String size = Gift.selectSize();
	        Object myGift = createGift(giftType, id, size);
	        return myGift;
		}
		//		CHANGE Gift
		private void changeGift(Object myGift) {
			if (myGift != null) {
				((Gift) myGift).setSize();
				((Gift) myGift).setPrice(false);
	 			if (myGift instanceof FruitBasket) {
		 			((FruitBasket) myGift).setNumberOfFruits();
		 			((FruitBasket) myGift).setCitrusFruits();
					((Gift) myGift).setPrice(((FruitBasket) myGift).getCitrusFruits());
					((Gift) myGift).displayInfo();
		 			((FruitBasket) myGift).displayFruitInfo();
	 			}
	 			else if (myGift instanceof SweetsBasket) {
		 			((SweetsBasket) myGift).setIncludesNuts();
					((Gift) myGift).displayInfo();
		 			((SweetsBasket) myGift).displaySweetsInfo();
	 			}
			} else {
				System.out.println("\nNo Gift has been ordered yet.");
			}
		}
		//		DISPLAY Gift
		private void displayGift(Object myGift) {
			if (myGift != null) {
				((Gift) myGift).displayInfo();
	 			if (myGift instanceof FruitBasket) {
		 			((FruitBasket) myGift).displayFruitInfo();
	 			}
	 			else if (myGift instanceof SweetsBasket) {
		 			((SweetsBasket) myGift).displaySweetsInfo();
	 			}
			} else {
				System.out.println("\nNo Gift has been ordered yet.");
			}
		}
		// Gift Type
		private static int selectGiftType() {
			int giftType;
			do {
				System.out.print("\nWhich kind of Gift Basket would you like?:"
						+ "\n1 - Fruit Basket"
						+ "\n2 - Sweets Basket"
						+ "\n> ");
		        giftType = inputNumber.nextInt();
	        }
	        while (giftType < 1 || giftType > 2);
			return giftType;
		}
		// CREATE Gift
		public static Object createGift(int giftType, String id, String size) {
	        if (giftType == 1) {
	        	int numberOfFruits = FruitBasket.calculateNumberOfFruits(size);
				boolean citrusFruits = FruitBasket.selectCitrus();
				FruitBasket myGift = new FruitBasket(id, size, numberOfFruits, citrusFruits);
				((Gift) myGift).setPrice(((FruitBasket) myGift).getCitrusFruits());
				((Gift) myGift).displayInfo();
	 			((FruitBasket) myGift).displayFruitInfo();
				return myGift;
	        }
	        else {
	        	boolean includesNuts = SweetsBasket.selectNuts();
				SweetsBasket myGift = new SweetsBasket(id, size, includesNuts);
				((Gift) myGift).setPrice(false);
				((Gift) myGift).displayInfo();
	 			((SweetsBasket) myGift).displaySweetsInfo();
				return myGift;
	        }
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
		System.out.println("Welcome! This program helps process gift orders.");
		// Create Instance of Order System
		OrderSystem order = new OrderSystem();
		// Action Variable
		int action = 69;
		do {
			order.displayMenu();
			action = inputNumber.nextInt();
			order.processChoice(action);
		} while (action != 9);
		
	}
}